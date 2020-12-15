package com.machineLearning.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alert implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int alertNumber;
	
	private int oldScore; 
	
	private int score;
	
	private double distance;
	
	private String customer;
	
	private String scienarioName;
	
	private String branch;
	
	private String sequence;
	
	private boolean important;
	
	private String type;

	public Alert(int alertNumber, int oldScore, int score, double distance, String customer,
			String scienarioName, String branch, String sequence, boolean important, String type) {
		super();
		this.alertNumber = alertNumber;
		this.oldScore = oldScore;
		this.score = score;
		this.distance = distance;
		this.customer = customer;
		this.scienarioName = scienarioName;
		this.branch = branch;
		this.sequence = sequence;
		this.important = important;
		this.type = type;
	}

	public Alert() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAlertNumber() {
		return alertNumber;
	}

	public void setAlertNumber(int alertNumber) {
		this.alertNumber = alertNumber;
	}

	public double getOldScore() {
		return oldScore;
	}

	public void setOldScore(int oldScore) {
		this.oldScore = oldScore;
	}

	public double getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getScienarioName() {
		return scienarioName;
	}

	public void setScienarioName(String scienarioName) {
		this.scienarioName = scienarioName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public boolean getImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Alert [id=" + id + ", alertNumber=" + alertNumber + ", oldScore=" + oldScore + ", score=" + score
				+ ", distance=" + distance + ", customer=" + customer + ", scienarioName=" + scienarioName + ", branch="
				+ branch + ", sequence=" + sequence + ", important=" + important + ", type=" + type + "]";
	}
}
