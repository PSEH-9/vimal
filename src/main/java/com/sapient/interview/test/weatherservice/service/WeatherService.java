package com.sapient.interview.test.weatherservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.interview.test.weatherservice.customexception.ServiceException;
import com.sapient.interview.test.weatherservice.model.Data;
import com.sapient.interview.test.weatherservice.model.WeatherForecast;
import com.sapient.interview.test.weatherservice.utility.WeatherUtility;

@Service
public class WeatherService {

	@Autowired
	private WeatherUtility weatherUtility;

	public String condition(String city, String country) throws ServiceException {
		WeatherForecast weaterInfo = weatherUtility.httpRequest(city,country);
		for (Data data : weaterInfo.getList()) {
			if (data.getMain().getTemp_max() > 40) {
				return "Carry umbrella or Use sunscreen lotion";
			}
		}
		return "";
	}

}
