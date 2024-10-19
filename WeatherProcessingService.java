package com.any.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.any.model.DailySummary;
import com.any.model.WeatherData;
import com.any.repository.DailySummaryRepository;
import com.any.repository.WeatherDataRepository;

@Service
public class WeatherProcessingService 
{
	 	private final WeatherDataRepository weatherDataRepository;
	    private final DailySummaryRepository dailySummaryRepository;

	    public WeatherProcessingService(WeatherDataRepository weatherDataRepository, DailySummaryRepository dailySummaryRepository) {
	        this.weatherDataRepository = weatherDataRepository;
	        this.dailySummaryRepository = dailySummaryRepository;
	    }

	    public void saveWeatherData(WeatherData weatherData) {
	        weatherDataRepository.save(weatherData);
	    }

	    public void generateDailySummary(String city) 
	    {
	        List<WeatherData> dataList = weatherDataRepository.findByCity(city);
	        if (dataList.isEmpty()) return;

	        double totalTemp = 0;
	        double maxTemp = Double.MIN_VALUE;
	        double minTemp = Double.MAX_VALUE;
	        String dominantCondition = "";

	        for (WeatherData data : dataList) 
	        {
	            totalTemp += data.getTempreture();
	            maxTemp = Math.max(maxTemp, data.getTempreture());
	            minTemp = Math.min(minTemp, data.getTempreture());
	            dominantCondition = data.getCondotion();
	        }

	        double avgTemp = totalTemp / dataList.size();
	        DailySummary summary = new DailySummary(city, avgTemp, maxTemp, minTemp, dominantCondition, LocalDate.now());

	        dailySummaryRepository.save(summary);
	    }
}
