package com.anil.demo11.domainobject.weather;

import java.util.List;

import com.anil.demo11.domainobject.Main;

public class WeatherNow {
	
	public List<Weather> weather;
	public Main main;
	public String city;
	
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
