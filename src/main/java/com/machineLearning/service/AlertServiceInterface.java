package com.machineLearning.service;

import java.util.List;


import com.machineLearning.model.Alert;

public interface AlertServiceInterface {

	public Alert saveAlert(Alert alert);
	
	public List<Alert> getImportantAlerts();
	
	public List<Alert> getNonImportantAlerts();
	
	List<Alert> getEqualAlerts(int value, String columnName, String alertType);

	List<Alert> getGreaterAlerts(int value, String columnName, String alertType);

	List<Alert> getLesserAlerts(int value, String columnName, String alertType);

	List<Alert> getGreaterOrEqualAlerts(int value, String columnName, String alertType);

	List<Alert> getLesserOrEqualAlerts(int value, String columnName, String alertType);

	List<Alert> getBetweenAlerts(int first, int last, String columnName, String alertType);

}
