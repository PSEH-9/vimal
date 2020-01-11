package com.sapient.interview.test.weatherservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.interview.test.weatherservice.customexception.ServiceException;
import com.sapient.interview.test.weatherservice.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping("condition/{city}/{country}")
	public String getWeaterCondition(@PathVariable("city") String city, @PathVariable("country") String country) {
		try {
			return weatherService.condition(city, country);
		} catch (ServiceException e) {
			return e.getMessage();
		}
	}

}
