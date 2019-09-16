package com.coding.assignment.pricing;

import com.coding.assignment.model.Car;

/**
 * Concrete Implementation of the Pricing Policy. 
 */
public class PricingPolicyFixedAmount extends AbstractPricingPolicy implements IPricingPolicy{
	
	/**
	 * Hour Price 
	 */
	private Double hourPrice; 
	
	/**
	 * Fixed Amount 
	 */
	private Double fixedAmount;
	
	public PricingPolicyFixedAmount(Double hourPrice, Double fixedAmount) {
		this.hourPrice = hourPrice;
		this.fixedAmount = fixedAmount;
	}
	
	/**
	 * Using this Policy the Toll Fees is calculated as
	 * Fixed amount + each hour spent in the parking (fixed amount + nb hours * hour price) 
	 */
	@Override
	public Double calculateTollFees(Car car) {
		long hours = this.calculateTimeDifferecne(car.getArrivalTime());
		Double result =  new Double(hours) *this.hourPrice+ this.fixedAmount;
		return result;
	}

	public Double getHourPrice() {
		return hourPrice;
	}

	public Double getFixedAmount() {
		return fixedAmount;
	}
}
