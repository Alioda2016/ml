package com.machineLearning.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.machineLearning.model.Alert;
import com.machineLearning.repository.AlertRepository;
import com.machineLearning.service.AlertServiceInterface;

@Service
public class AlertServiceImpl implements AlertServiceInterface {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(AlertServiceImpl.class);
	
	@Autowired
	private  AlertRepository repository;
	
	private boolean type;

	@Override
	public List<Alert> getImportantAlerts() {
		LOGGER.info("getting imp alerts");
		return repository.getImportantAlerts();
	}

	@Override
	public List<Alert> getNonImportantAlerts() {
		LOGGER.info("getting non imp alerts");
		return repository.getNonImportantAlerts();
	}

	@Override
	public Alert saveAlert(Alert alert) {
		return repository.save(alert);
	}

	@Override
	public List<Alert> getEqualAlerts(int value, String columnName, String alertType) {
		List<Alert> alerts = repository.findAll(new Specification<Alert>() {

			@Override
			public Predicate toPredicate(Root<Alert> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				if(alertType.equals("imp")) {
					type = true;
				}else {
					type = false;
				}
				Predicate p1 = criteriaBuilder.equal(root.get(columnName), value);
				Predicate p2 = criteriaBuilder.equal(root.get("important"), type);
				Predicate p = criteriaBuilder.and(p1, p2);
				return p; 
			}
		});
		
		return alerts;
	}

	@Override
	public List<Alert> getGreaterAlerts(int value, String columnName, String alertType) {
		List<Alert> alerts = repository.findAll(new Specification<Alert>() {
			
			@Override
			public Predicate toPredicate(Root<Alert> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				if(alertType.equals("imp")) {
					type = true;
				}else {
					type = false;
				}
				Predicate p1 = criteriaBuilder.greaterThan(root.get(columnName), value);
				Predicate p2 = criteriaBuilder.equal(root.get("important"), type);
				Predicate p = criteriaBuilder.and(p1, p2);
				return p; 
			}
		});
		
		return alerts;
	}

	@Override
	public List<Alert> getLesserAlerts(int value, String columnName, String alertType) {
		List<Alert> alerts = repository.findAll(new Specification<Alert>() {
			
			@Override
			public Predicate toPredicate(Root<Alert> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				if(alertType.equals("imp")) {
					type = true;
				}else {
					type = false;
				}
				Predicate p1 = criteriaBuilder.lessThan(root.get(columnName), value);
				Predicate p2 = criteriaBuilder.equal(root.get("important"), type);
				Predicate p = criteriaBuilder.and(p1, p2);
				return p; 
			}
		});
		
		return alerts;
	}

	@Override
	public List<Alert> getGreaterOrEqualAlerts(int value, String columnName, String alertType) {
		List<Alert> alerts = repository.findAll(new Specification<Alert>() {
			
			@Override
			public Predicate toPredicate(Root<Alert> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				if(alertType.equals("imp")) {
					type = true;
				}else {
					type = false;
				}
				Predicate p1 = criteriaBuilder.greaterThanOrEqualTo(root.get(columnName), value);
				Predicate p2 = criteriaBuilder.equal(root.get("important"), type);
				Predicate p = criteriaBuilder.and(p1, p2);
				return p; 
			}
		});
		
		return alerts;
	}

	@Override
	public List<Alert> getLesserOrEqualAlerts(int value, String columnName, String alertType) {
		List<Alert> alerts = repository.findAll(new Specification<Alert>() {
			
			@Override
			public Predicate toPredicate(Root<Alert> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				if(alertType.equals("imp")) {
					type = true;
				}else {
					type = false;
				}
				Predicate p1 = criteriaBuilder.lessThanOrEqualTo(root.get(columnName), value);
				Predicate p2 = criteriaBuilder.equal(root.get("important"), type);
				Predicate p = criteriaBuilder.and(p1, p2);
				return p; 
			}
		});
		
		return alerts;
	}

	@Override
	public List<Alert> getBetweenAlerts(int first, int last, String columnName, String alertType) {
		List<Alert> alerts = repository.findAll(new Specification<Alert>() {
			
			@Override
			public Predicate toPredicate(Root<Alert> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				if(alertType.equals("imp")) {
					type = true;
				}else {
					type = false;
				}
				Predicate p1 = criteriaBuilder.between(root.get(columnName), first, last);
				Predicate p2 = criteriaBuilder.equal(root.get("important"), type);
				Predicate p = criteriaBuilder.and(p1, p2);
				return p; 
			}
		});
		
		return alerts;
	}

	public int getImportantCount() {
		LOGGER.info("getting imp count alerts");
		return repository.getImportantCount();
	}

	public int getNonImportantCount() {
		LOGGER.info("getting non imp count alerts");
		return repository.getNonImportantCount();
	}
}
