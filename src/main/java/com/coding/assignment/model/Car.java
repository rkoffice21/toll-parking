package com.coding.assignment.model;

import java.time.LocalDateTime;

public class Car {

	private CarType carType;
	
	private LocalDateTime arrivalTime;
	
	private String carNumber;
	
	public Car() {
		
	}
	
	public Car(CarType carType, LocalDateTime arrivalTime, String carNumber) {
		super();
		this.carType = carType;
		this.arrivalTime = arrivalTime;
		this.carNumber = carNumber;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	
}
