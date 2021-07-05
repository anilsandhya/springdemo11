package com.anil.demo11.domainobject;

import java.util.List;

public class WeatherNow {
	
	public List<Weather> weather;
	public Main main;
	
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	
	
}
