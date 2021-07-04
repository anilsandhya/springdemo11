package com.anil.demo11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.demo11.domainobject.TimeNow;
import com.anil.demo11.service.TimeNowService;

@RestController
public class TimeNowController {
	
	@Autowired
	private TimeNowService timeNowService;
	private static final String template = "The time now is %s.";
	
	@GetMapping("/timenow")
	public TimeNow timenow() {
		String currenttime = timeNowService.getTime(); 
		return new TimeNow(String.format(template, currenttime));
	}
}
