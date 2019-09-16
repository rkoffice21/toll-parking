package com.coding.assignment.pricing;

import com.coding.assignment.model.Car;

/**
 * Concrete Implementation of the Pricing Policy. 
 */
public class PricingPolicyByHours extends AbstractPricingPolicy implements IPricingPolicy{

	/**
	 * Hour Price 
	 */
	private Double hourPrice;
	
	public PricingPolicyByHours(Double hourPrice) {
		this.hourPrice = hourPrice;
	}
	
	/**
	 * Using this Policy the Toll Fees is calculated as 
	 * Hour spent in the parking (nb hours * hour price)
	 */
	@Override
	public Double calculateTollFees(Car car) {
		long hours = this.calculateTimeDifferecne(car.getArrivalTime());
		Double result =  new Double(hours) *this.hourPrice;
		return result;
	}
	
	public Double getHourPrice() {
		return hourPrice;
	}

}
