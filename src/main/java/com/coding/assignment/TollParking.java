package com.coding.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.coding.assignment.exception.TollParkingException;
import com.coding.assignment.model.Car;
import com.coding.assignment.model.CarType;

/**
 * This Class handle the Operation for Incoming and OutGoing Cars. 
 */
public  class TollParking {
	
	final static Logger logger = Logger.getLogger(TollParking.class);
	
	// To initialize the Toll Parking with the Configuration of the User.
	private final TollParkingConfiguration config;
	
	// To Store the Car Type of and List of That particular Car Type.
	 private final Map<CarType,List<Car>> carSlots;
	 
	 // To Keep the Count of the Car of the Particular Type
	 private final Map<CarType,Integer> carCount;
	
	/**
	 * When we Initialize the Toll Parking then we will inject the Configuration of our choice.  
	 * @param config
	 */
	public TollParking(TollParkingConfiguration config) {
		
		if(config == null) 
			throw new TollParkingException("Configuration for the parking cannot be null");
		
		this.config = config;
		this.carSlots = new HashMap<CarType, List<Car>>();
		this.carCount = new HashMap<CarType, Integer>();
		
		for(Map.Entry<CarType, Integer> entrySet: config.getCarSlot().entrySet()) {
			carSlots.put(entrySet.getKey(), new ArrayList<>(entrySet.getValue())); 
			carCount.put(entrySet.getKey(), entrySet.getValue());
		}
	}

	
	/**
	 * Method to check if the Slot is free for a give Car Type 
	 * If Yes then return true else false.
	 * @param carType
	 * @return
	 */
	public boolean isFree(CarType carType) {
		logger.info("Verifying If the Car Slot is Free for the Car Type:"+carType);
		boolean free = false;
		for(Map.Entry<CarType,Integer> entry: this.carCount.entrySet()) {
			if(entry.getKey().equals(carType)) {
				if(entry.getValue() > 0 ) {
					free = true;
				}
			}
		}
		if(!free) 
			logger.info("Car Slot for the Type:"+carType+" is not Available for the moment.");
		
		return free;
	}
	
	/**
	 * Method to add a Car of a Particular Type to its respective Slot.
	 * @param car
	 * @throws TollParkingException
	 */
	public void carEntry(Car car) throws TollParkingException {
		synchronized (car) {
			if(this.isFree(car.getCarType())) {
				for(Map.Entry<CarType,List<Car>> entry: this.carSlots.entrySet()) {
					if(entry.getKey().equals(car.getCarType())) {
						logger.info("Adding the Car: "+car.getCarNumber() +" to the Slot: "+car.getCarType());
						entry.getValue().add(car);
						carCount.put(car.getCarType(),carCount.get(car.getCarType())-1 );	
					}
				}
			}
		}

	}
	
	/**
	 * Method to add a Car of a Particular Type to its respective Slot.
	 * After Removing we will return the Bill Amount.
	 * @param car
	 * @return
	 * @throws TollParkingException
	 */
	public Double carExit(Car car) throws TollParkingException {
		synchronized (car) {
			Double billAmount = 0.0;
			for(Map.Entry<CarType,List<Car>> entry: this.carSlots.entrySet()) {
				if(entry.getKey().equals(car.getCarType())) {
					entry.getValue().remove(car);
					carCount.put(car.getCarType(),carCount.get(car.getCarType())+1 );
					logger.info("Car Removed: "+car.getCarNumber() +" from the Slot: "+car.getCarType());
					
					billAmount = this.config.getPricingPolicy(car.getCarType()).calculateTollFees(car);
					logger.info("The bill amount for the car is "+billAmount+" Euros");
					break;
				}
			}
			return billAmount;
		}	
	}
}
