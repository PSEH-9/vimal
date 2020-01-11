package com.sapient.interview.test.weatherservice.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.interview.test.weatherservice.customexception.ServiceException;
import com.sapient.interview.test.weatherservice.utility.WeatherUtility;

@Service
public class WeatherService {

	@Autowired
	private WeatherUtility weatherUtility;

	public String condition(int days, String city, String country) throws ServiceException {
		float maximum = 0;
		float minimum = 0;
		String url = new StringBuilder("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=").append(city)
				.append(",").append(country).append("&mode=xml&appid=b6907d289e10d714a6e88b30761fae22").toString();
		JSONArray data = weatherUtility.httpRequest(url);
		for (int index = 0; index < days * 24; index++) {
			JSONObject time = data.getJSONObject(index);
			JSONObject temperature = time.getJSONObject("temperature");
			if (!(temperature.isNull("min") || temperature.isNull("min"))) {
				float min = temperature.getFloat("min");
				float max = temperature.getFloat("max");
				if (minimum > temperature.getInt("min") || index == 0) {
					minimum = min;
				}
				if (maximum < temperature.getInt("max") || index == 0) {
					maximum = max;
				}
			}
		}

		StringBuilder response = new StringBuilder();
		response.append("Max :: ").append(maximum).append(System.lineSeparator());
		response.append("Min :: ").append(minimum);
		if ((maximum - 273.15) > 40) {
			response.append(System.lineSeparator()).append("recommendation :: ")
					.append("Carry umbrella or Use sunscreen lotion");
		}
		return response.toString();
	}

}
