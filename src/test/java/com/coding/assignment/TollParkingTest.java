package com.coding.assignment;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.coding.assignment.model.Car;
import com.coding.assignment.model.CarType;
import com.coding.assignment.pricing.IPricingPolicy;
import com.coding.assignment.pricing.PricingPolicyByHours;
import com.coding.assignment.pricing.PricingPolicyFixedAmount;

public class TollParkingTest {
	
	TollParking tollParking;
	
	TollParkingConfiguration config;
	
	Car audi3;
	
	@Before
	public void setUp() {
		IPricingPolicy pricingPolicy = new PricingPolicyFixedAmount(2.0,2.0);
		
		config = new TollParkingConfiguration();
		config.addCarSlot(CarType.GASOLINE, 2);
		config.setPricingPolicy(CarType.GASOLINE,pricingPolicy);
		
		config.addCarSlot(CarType.ELECTRIC_20KW, 3);
		config.setPricingPolicy(CarType.ELECTRIC_20KW, new PricingPolicyByHours(5.0));
		
		tollParking = new TollParking(config);
		//carslots.addCarSlot(CarType.GASOLINE, 5);
		
		Car bmw1 = new Car(CarType.GASOLINE, LocalDateTime.now(), "1233");
		Car bmw2 = new Car(CarType.GASOLINE, LocalDateTime.now(), "1234");
		Car bmw3 = new Car(CarType.GASOLINE, LocalDateTime.now(), "1235");
		
		Car audi1 = new Car(CarType.ELECTRIC_20KW, LocalDateTime.now(), "12378");
		Car audi2 = new Car(CarType.ELECTRIC_20KW, LocalDateTime.now(), "12378");
		
		audi3 = new Car(CarType.ELECTRIC_20KW, LocalDateTime.now(), "123756668");
		
		List<Car> carList = new ArrayList<Car>();
		
		carList.add(bmw1);
		carList.add(bmw2);
		carList.add(bmw3);
		carList.add(audi1);
		carList.add(audi2);
		
		for(Car car:carList) {
			//if(tollParking.isFree(car.getCarType())) {
				tollParking.carEntry(car);
			//} 
		}
	}
	
	@Test
	public void testIsFree() {
		assertEquals(tollParking.isFree(CarType.GASOLINE), false);
		assertEquals(tollParking.isFree(CarType.ELECTRIC_20KW), true);
	}
	
	@Test
	public void testCarEntry() {
		 
		tollParking.carEntry(audi3);
		assertEquals(tollParking.isFree(CarType.ELECTRIC_20KW), false);
		
	}
	
	@Test
	public void testCarExit() {
		Double amount = tollParking.carExit(audi3);
		assertEquals(tollParking.isFree(CarType.ELECTRIC_20KW), true);
		 assertEquals(new Double(5.0), amount);
	}

}
