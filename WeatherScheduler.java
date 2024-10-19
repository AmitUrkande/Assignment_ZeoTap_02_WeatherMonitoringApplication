package com.any.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.any.model.WeatherData;
import com.any.service.WeatherFetcherService;
import com.any.service.WeatherProcessingService;

public class WeatherScheduler 
{
	@Autowired
    private WeatherFetcherService weatherFetcherService;

    @Autowired
    private WeatherProcessingService weatherProcessingService;

    private static final String CITY = "London"; // Example city

    @Scheduled(fixedRate = 3600000) // Fetch every hour
    public void fetchAndProcessWeatherData() 
    {
        WeatherData weatherData = weatherFetcherService.fetchWeather(CITY);
        weatherProcessingService.saveWeatherData(weatherData);
        weatherProcessingService.generateDailySummary(CITY);
    }
}
