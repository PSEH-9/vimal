package com.sapient.interview.test.weatherservice.model;

import java.util.List;

public class WeatherForecast {
	List<Data> list;

	public List<Data> getList() {
		return list;
	}

	public void setList(List<Data> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "WeatherForecast [list=" + list + "]";
	}
	
}
