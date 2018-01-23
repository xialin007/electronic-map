package com.ghostcloud.electronic.electronicmap.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class GPSMileageHandler implements IHandler{

	public String handle(Map<String, String> paramMaps) {
		return "GPSMileage handle";
	}
	
}
