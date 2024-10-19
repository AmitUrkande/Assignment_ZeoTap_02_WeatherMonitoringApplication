package com.any.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.any.model.WeatherData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class WeatherFetcherService 
{
	@Value("${openweathermap.api.key}")
	private String apiKey;
	
	@Value("${openweathermap.api.url}")
	private String apiUrl;
	
	public WeatherData fetchWeather(String city)
	{
		String url = apiUrl + "?q= " + city + "&appid= " + apiKey + "&units = metric";
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);
		
		JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        JsonObject main = jsonObject.getAsJsonObject("main");
        String condition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();

        return new WeatherData(city, main.get("temp").getAsDouble(), main.get("feels_like").getAsDouble(), condition, jsonObject.get("dt").getAsLong());
		
		
		
	}
}
