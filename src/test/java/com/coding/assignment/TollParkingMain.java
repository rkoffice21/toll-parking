package com.coding.assignment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.coding.assignment.model.Car;
import com.coding.assignment.model.CarType;
import com.coding.assignment.pricing.IPricingPolicy;
import com.coding.assignment.pricing.PricingPolicyByHours;
import com.coding.assignment.pricing.PricingPolicyFixedAmount;

public class TollParkingMain {
	
	 private static final Logger LOGGER = Logger.getLogger(TollParkingMain.class);
	 
	public static void main(String args[]) {
	LOGGER.info("Starting Toll Parking Test");

		
		IPricingPolicy pricingPolicy = new PricingPolicyFixedAmount(2.0,2.0);
		TollParkingConfiguration config = new TollParkingConfiguration();
		config.addCarSlot(CarType.GASOLINE, 2);
		config.setPricingPolicy(CarType.GASOLINE,pricingPolicy);
		
		config.addCarSlot(CarType.ELECTRIC_20KW, 2);
		config.setPricingPolicy(CarType.ELECTRIC_20KW, new PricingPolicyByHours(1.0));
		
		TollParking tollParking = new TollParking(config);
		//carslots.addCarSlot(CarType.GASOLINE, 5);
		
		Car bmw1 = new Car(CarType.GASOLINE, LocalDateTime.now(), "1233");
		Car bmw2 = new Car(CarType.GASOLINE, LocalDateTime.now(), "1234");
		Car bmw3 = new Car(CarType.GASOLINE, LocalDateTime.now(), "1235");
		
		Car audi1 = new Car(CarType.ELECTRIC_20KW, LocalDateTime.now(), "12378");
		Car audi2 = new Car(CarType.ELECTRIC_20KW, LocalDateTime.now(), "12378");
		
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
		
		tollParking.carExit(bmw2);
		tollParking.carEntry(bmw3);
		
		tollParking.carExit(audi1);
		
		
		// To implement Customs Pricing Policy
		class CustomPricingPolicy implements IPricingPolicy {

			@Override
			public Double calculateTollFees(Car car) {
				return 5.0; 
			}
			
		}
		
		config.addCarSlot(CarType.ELECTRIC_50KW, 2);
		config.setPricingPolicy(CarType.ELECTRIC_50KW, new CustomPricingPolicy());
		
		Car bmw5 = new Car(CarType.ELECTRIC_50KW, LocalDateTime.now(), "1252235");
		tollParking.carEntry(bmw5);
		
		
	}

}
