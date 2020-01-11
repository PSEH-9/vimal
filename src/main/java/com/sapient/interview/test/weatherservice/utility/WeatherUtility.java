package com.sapient.interview.test.weatherservice.utility;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sapient.interview.test.weatherservice.customexception.ServiceException;
import com.sapient.interview.test.weatherservice.model.WeatherForecast;

@Component
public class WeatherUtility {

	RestTemplate restTemplate = new RestTemplate();

	public WeatherForecast httpRequest(String city, String country) throws ServiceException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<WeatherForecast> result;
		try {
			result = restTemplate.exchange(new StringBuilder("http://api.openweathermap.org/data/2.5/forecast?q=")
					.append(city).append(",").append(country)
					.append("&mode=json&appid=d2929e9483efc82c82c32ee7e02d563e&units=metric").toString(),
					HttpMethod.GET, entity, WeatherForecast.class);
		} catch (RestClientException e) {
			throw new ServiceException(e.getLocalizedMessage());
		}
		System.out.println(result.getBody());
		return result.getBody();
	}

}
