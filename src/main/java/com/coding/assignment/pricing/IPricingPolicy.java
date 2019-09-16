package com.coding.assignment.pricing;

import com.coding.assignment.model.Car;

/**
 * Interface to implement the Pricing Policy for  the parking. 
 */
public interface IPricingPolicy {

	/**
	 * Abstract method to calculate the fee for the car.
	 * @param car
	 * @return Returns the amount.
	 */
	public Double calculateTollFees(Car car);
}
