package com.anil.demo11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anil.demo11.domainobject.WeatherNow;
import com.anil.demo11.service.WeatherNowService;

@RestController
public class WeatherController {

	/*private String temp;
	private String main;
	private String description;
	private String feelslike;
	private String tempmin;
	private String tempmax; */
	
	@Autowired
	private WeatherNowService weatherNowService;
	private static final String template = "%s min-%s max-%s, currently it is %s, %sF, feels like %sF.";
	
	@GetMapping("/weathernow")
	public WeatherNow weathernow(@RequestParam(value = "city", defaultValue = "Marietta,GA,USA") String city) {
		
		WeatherNow currentWeather = weatherNowService.getWeather(city);
		System.out.println(String.format(template, currentWeather.getMain(), currentWeather.getTempmin(), currentWeather.getTempmax(),
				currentWeather.getMain(), currentWeather.getTemp(), currentWeather.getFeelslike()));
		
		return new WeatherNow();
	}
}
