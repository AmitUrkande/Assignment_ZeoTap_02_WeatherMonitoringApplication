package com.any.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.any.model.DailySummary;

public interface DailySummaryRepository extends JpaRepository<DailySummary, Long>
{
	List<DailySummary> findByCity(String city);
}
