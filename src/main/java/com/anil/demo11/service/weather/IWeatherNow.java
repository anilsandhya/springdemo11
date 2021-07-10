package com.anil.demo11.service.weather;

import com.anil.demo11.domainobject.weather.WeatherNow;

public interface IWeatherNow {
	public WeatherNow getWeather(String city);
}
