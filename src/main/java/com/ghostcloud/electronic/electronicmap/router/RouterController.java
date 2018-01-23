package com.ghostcloud.electronic.electronicmap.router;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ghostcloud.electronic.electronicmap.handler.GPSMileageHandler;
import com.ghostcloud.electronic.electronicmap.handler.IHandler;
import com.ghostcloud.electronic.electronicmap.handler.UserHandler;

@RestController
public class RouterController {

	private Logger logger = LoggerFactory.getLogger("RouterController");

	private Map<String, IHandler> handlers = new HashMap<String, IHandler>();

	@Autowired
	private GPSMileageHandler gpsMileageHandler;
	
	@Autowired
	private UserHandler userHandler;

	@PostConstruct
	public void init() {
		handlers.put("huoyunren.gpsMileage.getTruckMileage", gpsMileageHandler);
		handlers.put("user", userHandler);
	}

	@RequestMapping("/router")
	public Object router(@RequestParam String method, 
			@RequestParam(required = false) String startDate, 
			@RequestParam(required = false) String endDate,
			@RequestParam(required = false) String macno, 
			@RequestParam(required = false) String gpsno, 
			@RequestParam(required = false) Integer type)
			throws HandlerNotFoundException {
		IHandler hanlder = handlers.get(method);
		if (hanlder == null) {
			throw new HandlerNotFoundException(method + " not found.");
		}
		Map<String, String> paramMaps = new HashMap<String, String>();
		if (startDate != null ) paramMaps.put("startDate", startDate);
		if (endDate != null ) paramMaps.put("endDate", endDate);
		if (macno != null ) paramMaps.put("macno", macno);
		if (type != null ) paramMaps.put("type", String.valueOf(type));
		return hanlder.handle(paramMaps);
	}
	

	@ExceptionHandler(value = HandlerNotFoundException.class)
	@ResponseBody
	public Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error("HandlerNotFoundException ---Host {} invokes url {} ERROR: {}", req.getRemoteHost(),
				req.getRequestURL(), e.getMessage());
		return e.getMessage();
	}

}
