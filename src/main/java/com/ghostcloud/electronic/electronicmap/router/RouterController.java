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

import com.ghostcloud.electronic.electronicmap.handler.GPSMileage;
import com.ghostcloud.electronic.electronicmap.handler.IHandler;

@RestController
public class RouterController {

	private Logger logger = LoggerFactory.getLogger("RouterController");

	private Map<String, IHandler> handlers = new HashMap<String, IHandler>();

	@Autowired
	private GPSMileage gpsMileage;

	@PostConstruct
	public void init() {
		handlers.put("huoyunren.gpsMileage.getTruckMileage", gpsMileage);
	}

	@RequestMapping("/router")
	public String router(@RequestParam String method, @RequestParam String startDate, @RequestParam String endDate,
			@RequestParam String macno, @RequestParam String gpsno, @RequestParam int type)
			throws HandlerNotFoundException {
		IHandler hanlder = handlers.get(method);
		if (hanlder == null) {
			throw new HandlerNotFoundException(method + " not found.");
		}
		Map<String, String> paramMaps = new HashMap<String, String>();
		paramMaps.put("startDate", startDate);
		paramMaps.put("endDate", endDate);
		paramMaps.put("macno", macno);
		paramMaps.put("type", String.valueOf(type));
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
