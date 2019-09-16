package com.coding.assignment;

import java.util.HashMap;
import java.util.Map;

import com.coding.assignment.model.CarType;
import com.coding.assignment.pricing.IPricingPolicy;

/**
 * This Class is used to do the Configuration of our Parking Lot. 
 */
public class TollParkingConfiguration {
	
	// To Store the Car Type and No. of Slots for the Type.
	private final Map<CarType, Integer> carSlots;
	
	// To Store the Car Type and Pricing Policy each Car Type can have his own Policy.
	private final Map<CarType, IPricingPolicy>  pricingPolicy;
	
	// Static Method to create the Configuration Object
	public static TollParkingConfiguration config() {
		return new TollParkingConfiguration();
	}
	
	
	public TollParkingConfiguration() {
		this.carSlots 		= new HashMap<CarType, Integer>();
		this.pricingPolicy  = new HashMap<CarType, IPricingPolicy>();
	}

	/**
	 * Method to add the Car Type and No.of Slots
	 * @param carType
	 * @param slot
	 */
	public void addCarSlot(CarType carType, Integer slot) {
		carSlots.put(carType, slot);
	}
	
	/**
	 * Method to return all CarType and Slots.
	 * @return
	 */
	public Map<CarType, Integer> getCarSlot() {
		return this.carSlots;
	}
	
	/**
	 * Method to get the Pricing Policy for the Car Type.
	 * @param carType
	 * @return
	 */
	public IPricingPolicy getPricingPolicy(CarType carType) {
		return this.pricingPolicy.get(carType);
	}

	/**
	 * Method to set the Pricing Policy for the Car Type.
	 * @param carType
	 * @param pricingPolicy
	 */
	public void setPricingPolicy(CarType carType, IPricingPolicy pricingPolicy) {
		this.pricingPolicy.put(carType, pricingPolicy);
	}

}
