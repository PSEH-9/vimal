package com.sapient.interview.test.weatherservice.utility;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.interview.test.weatherservice.customexception.ServiceException;
import com.sapient.interview.test.weatherservice.service.WeatherService;

@SpringBootTest
class WeatherServiceTest {

	@Autowired
	private WeatherService service;

	@Test
	void checkNotNull() {
		assertNotNull(service);
	}

	@Test
	void contextLoads1() throws ServiceException {
		String condition = service.condition(3, "Bangalore", "IN");
		assertNotNull(condition);
	}

}
