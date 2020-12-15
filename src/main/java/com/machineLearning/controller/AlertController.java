package com.machineLearning.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.machineLearning.model.Alert;
import com.machineLearning.service.impl.AlertServiceImpl;

@RestController
@RequestMapping("aml/ml")
@CrossOrigin(origins = "*")
public class AlertController {

	@Autowired
	private AlertServiceImpl service;
	
	@PostMapping("alert")
	public Alert saveAlert(@RequestBody Alert alert) {		
		Alert alert1 = new Alert(34, 70, 90, 654, "ALIOUDA", "fdjghjgdkjad", "fhgfdt", "fgshdghj", true, "jfkjk");
		
		return service.saveAlert(alert1);
	}
	
	@GetMapping("important")
	public List<Alert> getImportantAlerts(){
		return service.getImportantAlerts();
	}
	
	@GetMapping("non-important")
	public List<Alert> getNonImportantAlerts(){
		return service.getNonImportantAlerts();
	}
	
	@GetMapping("nonImp-count")
	public int getNonImportantCount(){
		return service.getNonImportantCount();
	}
	
	@GetMapping("imp-count")
	public int getImportantCount(){
		return service.getImportantCount();
	}
	
	@GetMapping("equality")
	public List<Alert> getEqualAlerts(
									  @RequestParam("value") int value,
									  @RequestParam(required=false, name="col") String columnName,
									  @RequestParam(required=false, name="type") String alertType
									  ){
		return service.getEqualAlerts(value, columnName, alertType);
	}
	
	@GetMapping("great")
	public List<Alert> getGreaterAlerts(
									    @RequestParam("value") int value,
									    @RequestParam("col") String columnName,
									    @RequestParam("type") String alertType
									    ) {
		return service.getGreaterAlerts(value, columnName, alertType);
	}
	
	@GetMapping("lessThan")
	public List<Alert> getLesserAlerts(
										@RequestParam("value") int value,
										@RequestParam("col") String columnName,
									    @RequestParam("type") String alertType
									    ) {
		return service.getLesserAlerts(value, columnName, alertType);
	}

	@GetMapping("greatOrEqual")
	public List<Alert> getGreaterOrEqualAlerts(
											   @RequestParam("value") int value,
											   @RequestParam("col") String columnName,
											   @RequestParam("type") String alertType
											   ) {
		return service.getGreaterOrEqualAlerts(value, columnName, alertType);
	}

	@GetMapping("lessOrEqual")
	public List<Alert> getLesserOrEqualAlerts(
											  @RequestParam("value") int value,
											  @RequestParam("col") String columnName,
											  @RequestParam("type") String alertType) {
		return service.getLesserOrEqualAlerts(value, columnName, alertType);
	}

	@GetMapping("between")
	public List<Alert> getBetweenAlerts(
										@RequestParam("first") int first, 
										@RequestParam("last")int last,
										@RequestParam("col") String columnName,
										@RequestParam("type") String alertType
										) 
	{
		return service.getBetweenAlerts(first, last, columnName, alertType);
	}
}
