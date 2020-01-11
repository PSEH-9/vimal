package com.sapient.interview.test.weatherservice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.interview.test.weatherservice.customexception.ServiceException;
import com.sapient.interview.test.weatherservice.model.WeatherForecast;
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
		WeatherForecast httpRequest = utility.httpRequest("Bangalore", "IN");
		assertNotNull(httpRequest);
	}

}
