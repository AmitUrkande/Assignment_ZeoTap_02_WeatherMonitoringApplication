package com.any.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_summary")
public class DailySummary 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
	private double avgTemperature;
	private double maxTemperature;
	private double minTemperature;
	private String dominantCondition;
	private LocalDate date;
	
	public DailySummary() 
	{
		
	}

	public DailySummary(String city, double avgTemperature, double maxTemperature, double minTemperature,
			String dominantCondition, LocalDate date) {
		super();
		this.city = city;
		this.avgTemperature = avgTemperature;
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
		this.dominantCondition = dominantCondition;
		this.date = date;
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

	public double getAvgTemperature() {
		return avgTemperature;
	}

	public void setAvgTemperature(double avgTemperature) {
		this.avgTemperature = avgTemperature;
	}

	public double getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public String getDominantCondition() {
		return dominantCondition;
	}

	public void setDominantCondition(String dominantCondition) {
		this.dominantCondition = dominantCondition;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

	
	
	
}
