package com.sapient.interview.test.weatherservice.utility;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sapient.interview.test.weatherservice.customexception.ServiceException;

@Component
public class WeatherUtility {

	RestTemplate restTemplate = new RestTemplate();
	XmlMapper xmlMapper = new XmlMapper();

	public JSONArray httpRequest(String url) throws ServiceException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result;
		try {
			result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		} catch (RestClientException e) {
			throw new ServiceException(e.getLocalizedMessage());
		}

		JSONObject xmlJSONObj = XML.toJSONObject(result.getBody().toString());
		JSONObject weatherdata = xmlJSONObj.getJSONObject("weatherdata");
		JSONObject forecast = weatherdata.getJSONObject("forecast");
		JSONArray jsonArray = forecast.getJSONArray("time");
		return jsonArray;

	}

}
