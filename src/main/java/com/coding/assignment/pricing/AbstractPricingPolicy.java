package com.coding.assignment.pricing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.coding.assignment.exception.TollParkingException;
import com.coding.assignment.model.Car;

/**
 * Abstract Method for the Pricing Policy. 
 *
 */
public abstract class AbstractPricingPolicy implements IPricingPolicy{

	/**
	 * Abstract Method to calculate the toll fee for the Car.  
	 */
	public abstract Double calculateTollFees(Car car);
	
	/**
	 * Method to calculate the time difference between two date.
	 * @param startTime
	 * @param endTime
	 * @return no of Hours. If the Hour is less than 1 then it will return 1 else 
	 * it will return the actual hours.   
	 */
	public long calculateTimeDifferecne(LocalDateTime startTime, LocalDateTime endTime) {
		if(startTime ==null || endTime == null ) {
			throw new TollParkingException("Date cannot be null");
		}
		
		long hours = startTime.until(endTime, ChronoUnit.HOURS);
		if(hours == 0L) {
			hours = 1L;
		}
		
		return hours;
	}

	/**
	 * Method to calculate the hours difference between Give dateTime and Current Date Time
	 * @param startTime
	 * @return no.of Hours.
	 */
	public long calculateTimeDifferecne(LocalDateTime startTime) {
		return this.calculateTimeDifferecne(startTime, LocalDateTime.now());
	}
}
