package com.coding.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.coding.assignment.model.CarType;
import com.coding.assignment.pricing.IPricingPolicy;
import com.coding.assignment.pricing.PricingPolicyByHours;
import com.coding.assignment.pricing.PricingPolicyFixedAmount;

public class TollParkingConfigurationTest {

	TollParkingConfiguration config;
	
	IPricingPolicy pricingPolicy;
	
	@Before
	public void setUp() {
		 config = new TollParkingConfiguration();
		 config.addCarSlot(CarType.GASOLINE, 2);
		 config.addCarSlot(CarType.ELECTRIC_20KW, 2);
		 pricingPolicy = new PricingPolicyByHours(2.0);
		 
	}
	
	@Test
	public void testgetCarSlotCnfig() {
		assertEquals(config.getCarSlot().entrySet().size(), 2);
		assertNotNull(pricingPolicy);
		boolean result  = (pricingPolicy instanceof PricingPolicyByHours) ;
		assertEquals(result,true);
	}
	
	@Test
	public void testPricingPolicy() { 
		 pricingPolicy = new PricingPolicyFixedAmount(2.0, 3.0);
		 boolean result  = (pricingPolicy instanceof PricingPolicyFixedAmount) ;
		 assertEquals(result,true);
		 
	}
}
