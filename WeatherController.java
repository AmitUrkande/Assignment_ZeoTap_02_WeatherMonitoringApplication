package com.any.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.any.model.DailySummary;
import com.any.model.WeatherData;
import com.any.repository.DailySummaryRepository;
import com.any.repository.WeatherDataRepository;

@RestController
@RequestMapping("/api/weather")
public class WeatherController 
{
	private final WeatherDataRepository weatherDataRepository;
    private final DailySummaryRepository dailySummaryRepository;

    public WeatherController(WeatherDataRepository weatherDataRepository, DailySummaryRepository dailySummaryRepository) 
    {
        this.weatherDataRepository = weatherDataRepository;
        this.dailySummaryRepository = dailySummaryRepository;
    }

    @GetMapping("/{city}/current")
    public List<WeatherData> getCurrentWeather(@PathVariable String city) 
    {
        return weatherDataRepository.findByCity(city);
    }

    @GetMapping("/{city}/summary")
    public List<DailySummary> getDailySummary(@PathVariable String city) 
    {
        return dailySummaryRepository.findByCity(city);
    }
}
