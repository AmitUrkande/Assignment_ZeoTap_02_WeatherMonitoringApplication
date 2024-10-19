package com.any.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.any.model.WeatherData;
import java.util.List;


public interface WeatherDataRepository extends JpaRepository<WeatherData, Long>
{
	List<WeatherData> findByCity(String city);
}
