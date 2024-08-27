import hw1.AirportVan;

public class AirportVanTest {

	public static void main(String[] args) {

//		AirportVan v = new AirportVan(0, 0, 0, 0);
//		v.drive(20, 0);
//		System.out.println(v.getTotalMiles());
//		System.out.println("Expected 20");
//		System.out.println("");
//		
//		v = new AirportVan(0, 0, 0, 0);
//		v.drive(20, 60);
//		v.drive(10, 15);
//		System.out.println(v.getTotalMiles());
//		System.out.println("Expected 30");
//		System.out.println(v.getTotalTime());
//		System.out.println("Expected 75");
//		System.out.println("");
//		
//		v = new AirportVan(0, 0, 0, 3);
//		v.pickUp();
//		v.pickUp();
//		System.out.println(v.getRiderCount());
//		System.out.println("Expected 2");
//		v.pickUp();
//		System.out.println(v.getRiderCount());
//		System.out.println("Expected 3");
//		System.out.println("");
//		
//		v.pickUp(); // does nothing, can't go over max riders
//		System.out.println(v.getRiderCount());
//		System.out.println("Expected 3");
//		v.dropOff(0);
//		System.out.println(v.getRiderCount());
//		System.out.println("Expected 2");
//		v.dropOff(0);
//		System.out.println(v.getRiderCount());
//		System.out.println("Expected 1");
//		v.dropOff(0);
//		System.out.println(v.getRiderCount());
//		System.out.println("Expected 0");
//		v.dropOff(0); // does nothing, can't go below 0
//		System.out.println(v.getRiderCount());
//		System.out.println("Expected 0");
//		System.out.println("");
//		
//		v = new AirportVan(0, 0, 5, 3);
//		v.pickUp();
//		v.drive(0, 100);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 500");
//		v.drive(0, 50);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 750");
//		System.out.println("");
//		
//		v = new AirportVan(0, 0, 5, 3);
//		v.pickUp();
//		v.pickUp();
//		v.pickUp();
//		v.drive(0, 100);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 500");
//		v.drive(0, 50);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 750");
//		System.out.println("");
//		
//		v = new AirportVan(0, 0, 5, 3);
//		v.drive(0, 100);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 0");
//		v.drive(0, 50);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 0");
//		System.out.println("");
//		
//		v = new AirportVan(0, 10, 5, 3);
//		v.pickUp();
//		v.drive(2, 0);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 20");
//		v.drive(5, 0);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 70");
//		System.out.println("");
//		
//		v = new AirportVan(0, 10, 5, 3);
//		v.pickUp();
//		v.pickUp();
//		v.pickUp();
//		v.drive(2, 0);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 60");
//		v.drive(5, 0);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 210");
//		System.out.println("");
//		
//		v = new AirportVan(0, 10, 5, 3);
//		v.drive(2, 0);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 20");
//		v.drive(5, 0);
//		System.out.println(v.getTotalPoints());
//		System.out.println("Expected 70");
//		System.out.println("");
//		
//		v = new AirportVan(0, 10, 5, 3);
//		v.pickUp();
//		v.pickUp();
//		v.dropOff(5);
//		System.out.println(v.getTotalTips());
//		System.out.println("Expected 5");
//		v.dropOff(2);
//		System.out.println(v.getTotalTips());
//		System.out.println("Expected 7");
//		System.out.println("");
//		
//		v.dropOff(10);
//		System.out.println(v.getTotalTips());
//		System.out.println("Expected 7");
//		System.out.println("");
		
		AirportVan van = new AirportVan(12.0, 10, 5, 10);
		van.drive(8, 10);
		System.out.println(van.getTotalPoints());
		System.out.println("Expected 80");
		van.waitAround(5);
		System.out.println(van.getTotalPoints());
		System.out.println("Expected 80");
		van.pickUp();
		van.drive(25, 30);
		System.out.println(van.getTotalPoints());
		System.out.println("Expected 480");
		
		
	}

}
