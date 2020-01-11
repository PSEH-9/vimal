package com.sapient.interview.test.weatherservice.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	@GetMapping("weather-forecast/{days}/{city}/{country}")
	public String getWeaterConditionForGivenDays(@PathVariable("days") @NotBlank @Size(max = 4) Integer days,
			@PathVariable("city") String city, @PathVariable("country") String country) throws ServiceException {
		return weatherService.condition(days, city, country);
	}

}
