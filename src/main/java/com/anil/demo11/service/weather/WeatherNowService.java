package com.anil.demo11.service.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anil.demo11.domainobject.weather.WeatherNow;

@Service
public class WeatherNowService implements IWeatherNow {

	private static String WEATHER_URL = "";
	
	@Override
	public WeatherNow getWeather(String city) {
		
		WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=imperial&appid=022592b3adee8905633e8fb604e8f107";
		System.out.println("*** Hello from WeatherNowService.");
		System.out.println(WEATHER_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		WeatherNow response = restTemplate.getForObject(WEATHER_URL, WeatherNow.class);
		System.out.println(response.toString());
		response.setCity(city);
		return response;
	}

}
