package demo;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class Ryanair_Demo {
	demo.driver driver = new demo.driver();
	Reporter reporter = new Reporter();
	
	
	// Load driver
	
	@Parameters ({"udid","deviceModel","platformVersion","platformName", "ip", "port"})
	
	
	@BeforeMethod
	public void beforeTest (String udid, String deviceModel, String platformVersion, String platformName, String ip, String port) throws MalformedURLException, InterruptedException {
			
		System.out.println("-------|||||-------");
		System.out.println("-- Closed Inspection Flow - " + deviceModel + "(" + udid +")" + "--");
		System.out.println("-------|||||-------");
		driver.initDriver(udid, deviceModel, platformVersion, platformName, ip, port);
		//Thread.sleep(20000);
	
	}
	
	
	public void launchApplication () throws InterruptedException, IOException {
	
		
		System.out.println("////////////////////");
		System.out.println("-- Booking a flight -- ");
		driver.bookFlight();
		
		System.out.println("////////////////////");
		System.out.println("-- Selecting 'One Way' option -- ");
		driver.oneWay();
		
		System.out.println("////////////////////");
		System.out.println("-- Chosing places -- ");
		driver.places();
		
		System.out.println("////////////////////");
		System.out.println("-- Chosing dates -- ");
		driver.dates();
		
		System.out.println("////////////////////");
		System.out.println("-- Flight Details -- ");
		driver.flight_details();
		
		System.out.println("////////////////////");
		System.out.println("-- Passenger Details -- ");
		driver.passenger_details();
		
		/*System.out.println("////////////////////");
		System.out.println("-- Selecting cabin bag -- ");
		driver.select_cabin_bag();*/
		
		System.out.println("////////////////////");
		System.out.println("-- Chosing a seat -- ");
		driver.select_seats();			
		
		System.out.println("////////////////////");
		System.out.println("-- Login -- ");
		driver.login();
		
		System.out.println("////////////////////");
		System.out.println("-- Payment Info-- ");
		driver.payment();
			
	}
	
	
	
	// From @Test 
	
	@AfterMethod
		public void afterTest() throws MalformedURLException, InterruptedException {
		driver.driver.quit();		
	}
	
}