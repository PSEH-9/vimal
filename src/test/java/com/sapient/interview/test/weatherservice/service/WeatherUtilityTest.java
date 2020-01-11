package com.sapient.interview.test.weatherservice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.interview.test.weatherservice.customexception.ServiceException;
import com.sapient.interview.test.weatherservice.utility.WeatherUtility;

@SpringBootTest
class WeatherUtilityTest {

	@Autowired
	private WeatherUtility utility;

	@Test
	void checkNotNull() {
		assertNotNull(utility);
	}

	@Test
	void weatherForecast() throws ServiceException {
		JSONArray httpRequest = utility.httpRequest("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&mode=xml&appid=b6907d289e10d714a6e88b30761fae22");
		assertNotNull(httpRequest);
	}

}
