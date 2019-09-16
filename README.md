Toll Parking Library
About 

A Java API Containing following Criteria
A toll parking contains multiple parking slots of different types :
● the standard parking slots for sedan cars (gasoline-powered)
● parking slots with 20kw power supply for electric cars
● parking slots with 50kw power supply for electric cars

Build
The Project is Build in form of using Maven. 
First you need to clone the Project using 
1. git clone https://github.com/rkoffice21/toll-parking.git
After wards you will run the Maven Command
2. mvn clean install

How to Use it.
In the Test Class https://github.com/rkoffice21/toll-parking/blob/master/src/test/java/com/coding/assignment/TollParkingMain.java
1. First We Set up the the Toll Parking Configuration 
	TollParkingConfiguration config = new TollParkingConfiguration();
2. Then we add the Car Type and Pricing Policy
	IPricingPolicy pricingPolicy = new PricingPolicyFixedAmount(2.0,2.0);
	
	config.addCarSlot(CarType.GASOLINE, 2);
	config.setPricingPolicy(CarType.GASOLINE,pricingPolicy);
	
3. Then Create the TollParking Object
	TollParking tollParking = new TollParking(config);
	
4. Then we create the Car Object 
	Car bmw1 = new Car(CarType.GASOLINE, LocalDateTime.now(), "1233");		

5.	Then Play with the API to enter and exit. 	At the exit we will get the Bill Amount 
	tollParking.carExit(bmw2);
	Amount = tollParking.carEntry(bmw3);

6. We Can also implement Custom Pricing Policy like this
	// To implement Customs Pricing Policy
	class CustomPricingPolicy implements IPricingPolicy {

		@Override
		public Double calculateTollFees(Car car) {
			return 5.0; 
		}
		
	}

Unit Test and Test Coverage
There in all 7 Unit test with 88% Test Coverage.
All the Methods are very well Documented.

