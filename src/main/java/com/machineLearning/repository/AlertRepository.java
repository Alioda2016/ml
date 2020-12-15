package com.machineLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.machineLearning.model.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long>, JpaSpecificationExecutor<Alert> {

	@Query("SELECT at FROM Alert at where at.important = true")
	public List<Alert> getImportantAlerts();
	
	@Query("SELECT at FROM Alert at where at.important = false")
	public List<Alert> getNonImportantAlerts();
	
	@Query(value ="SELECT COUNT(*) FROM Alert where Alert.important = 1", nativeQuery = true)
	public int getImportantCount();

	@Query(value ="SELECT COUNT(*) FROM Alert where Alert.important = 0", nativeQuery = true)
	public int getNonImportantCount();

}
