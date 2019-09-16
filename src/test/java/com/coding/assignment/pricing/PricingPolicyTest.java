package com.coding.assignment.pricing;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.coding.assignment.model.Car;
import com.coding.assignment.model.CarType;

public class PricingPolicyTest {

	IPricingPolicy byHours;
	
	IPricingPolicy byFixedAmount;

	@Before
	public void setUp() {
		 byHours =  new PricingPolicyByHours(2.0);
		 byFixedAmount = new PricingPolicyFixedAmount(2.0, 3.0);
	}
	
	@Test
	public void testPricingPolicyByHours() {
		Car bmw = new Car(CarType.GASOLINE, LocalDateTime.now(), "1233");
		assertEquals(new Double(2.0), byHours.calculateTollFees(bmw));
	}
	
	@Test
	public void testPricingPolicyByFixedAmount() {
		Car audi = new Car(CarType.ELECTRIC_20KW, LocalDateTime.now(), "12453");
		assertEquals(new Double(5.0), byFixedAmount.calculateTollFees(audi));
	}

}
