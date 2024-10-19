package com.any.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="weather_data")
public class WeatherData 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
	private double temperature;
	private double feelsLike;
	private String condotion;
	private long timestamp;
	public WeatherData() 
	{
		
	}
	public WeatherData(String city, double temperature, double feelsLike, String condotion, long timestamp) {
		super();
		this.city = city;
		this.temperature = temperature;
		this.feelsLike = feelsLike;
		this.condotion = condotion;
		this.timestamp = timestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getTempreture() {
		return temperature;
	}
	public void setTempreture(double tempreture) {
		this.temperature = tempreture;
	}
	public double getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}
	public String getCondotion() {
		return condotion;
	}
	public void setCondotion(String condotion) {
		this.condotion = condotion;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
}
