package demo;

import org.openqa.selenium.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;

import org.testng.Reporter;


public class driver {
	public static AndroidDriver<MobileElement> driver; //It must be "Static" in order to allow the use of testng.xml

	public void initDriver(String udid, String deviceModel, String platformVersion, String platformName, String ip, String port) throws MalformedURLException, InterruptedException {
		System.out.println("Starting driver..."); 
		DesiredCapabilities capabilities = new DesiredCapabilities();		 
		 capabilities.setCapability("udid", udid);
		 capabilities.setCapability("deviceName", deviceModel);
		 capabilities.setCapability("platformVersion", platformVersion);
		 capabilities.setCapability("platformName", platformName);
		 		 
		 // Capabilites related with application
		 capabilities.setCapability("appPackage", "com.ryanair.cheapflights");
		 capabilities.setCapability("appActivity", "com.ryanair.cheapflights.ui.SplashScreenActivity");
		 capabilities.setCapability("autoGrantPermissions","true"); 
		 
		 // Manage driver configuration
		 driver = new AndroidDriver<MobileElement>(new URL("http://"+ip+":"+port+"/wd/hub"), capabilities);
		 driver.manage().timeouts().implicitlyWait(2400, TimeUnit.SECONDS);
		 System.out.println("Driver started properly");
			 
	} // from "initDriver" 
	
	// This function was created to solve the problem that appears when certain screens does not loaded properly. Doing a dropdown of status bar and pressing back.
	// With this the XML tree is loaded properly by Appium allowing it to capture elements. 
	private void solveProblem () throws InterruptedException {
		Thread.sleep(2000);
		// Open "Recent Apps" window
		driver.pressKeyCode(187);
		Thread.sleep(2000);
		// Go back in order to come back to the same App
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
	}
	
	
		
	
	public void bookFlight() {
		MobileElement bookFlight_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/tv_search");
		bookFlight_button.click();
	}
	
	
	
	public void oneWay () {
		MobileElement oneWay_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/plan_trip_btn_one_way");
		oneWay_button.click();
	}
	
	public void places () throws InterruptedException {
		// FROM: Selecting the source
		MobileElement destinationFrom_button = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout");
		destinationFrom_button.click();
		
		// Call to function that allows to avoid the problem in which Appium is not able to find elements. 
		solveProblem ();
		
		// FROM: Introducing city ("Madrid")
		MobileElement destination_text = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/view_search_edit_text");
		destination_text.sendKeys("Madrid");
		// FROM - Clicking on the result
		MobileElement destinationResult_button = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout");
		destinationResult_button.click();
		
		// TO: Selecting the source
		MobileElement destinationTo_button = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout");
		destinationTo_button.click();
		
		// Call to function that allows to avoid the problem in which Appium is not able to find elements. 
		solveProblem ();
		
		// TO: Introducing city ("Rome")
		destination_text.sendKeys("Rome");
		// TO: Clicking on the result
		destinationResult_button.click();
	}
	
	public void dates () throws InterruptedException {
		// Going into the calendar page
		MobileElement calendar_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/plan_trip_btn_trip_date_depart");
		calendar_button.click();
		// REVIEW
		Thread.sleep(10000);
		
		// Call to function that allows to avoid the problem in which Appium is not able to find elements. 
		solveProblem ();
		
		// Selecting one date (10th march)
		MobileElement date_button = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView[1]");
		date_button.click(); 
		
		// Tapping on next button in order to confirm the date
		MobileElement next_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/view_button_bar_next_btn");
		next_button.click();
		
		// Tapping on "Let's Go" button
		next_button.click();
	}
	
	public void flight_details () throws InterruptedException {
		// Call to function that allows to avoid the problem in which Appium is not able to find elements. 
		solveProblem ();
		// Taping on the price button
		MobileElement price_button = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ryanair.cheapflights.ui.availability.FRViewPager/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout");
		price_button.click();
		
		//Taping in the upper option
		MobileElement priceOption_button = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ryanair.cheapflights.ui.availability.FRViewPager/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[1]");
		priceOption_button.click();			
	}
	
	public void passenger_details () throws InterruptedException {
		// Call to function that allows to avoid the problem in which Appium is not able to find elements. 
		solveProblem ();
		// Tapping on Mr. 
		MobileElement mr_button = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.TextView");
		mr_button.click();
		
		// Introducing 'First Name' and 'Last Name' 
		MobileElement firstName_text = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/pax_first_name");
		firstName_text.sendKeys("Miguel");
		MobileElement lastName_text = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/pax_last_name");
		lastName_text.sendKeys("Hernan");
		
		// PENDING TO REVIEW. Maybe the "navigate.back" is not necessary
		driver.navigate().back();
		// Tapping on continue button
		MobileElement continue_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/price_breakdown_cta");
		continue_button.click();
	}
	
	public void select_cabin_bag () throws InterruptedException {
		// REVIEW
		Thread.sleep(10000);
		// Call to function that allows to avoid the problem in which Appium is not able to find elements. 
		solveProblem ();
		
		// Tapping on "Recommended" option
		MobileElement best_option = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/best_option");
		best_option.click();
		
		// Tapping on continue button
		MobileElement continue_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/price_breakdown_cta");
		continue_button.click();
	}
	
	public void select_seats () throws InterruptedException {
		
		Thread.sleep(1500);
		// Tapping on the proposal seat
		MobileElement proposal_seat = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/pick_proposal_button");
		proposal_seat.click();
				
		// Call to function that allows to avoid the problem in which Appium is not able to find elements. 
		solveProblem();
		
		// Tapping on continue button
		MobileElement continue_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/price_breakdown_cta");
		continue_button.click();		
	}
	
	public void login () throws InterruptedException {
		//Thread.sleep(3000);
		//System.out.println("Antes");
		
		// Tapping "Login" option
		MobileElement login_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/button_login");
		login_button.click();
				
		// Sending "User" text
		MobileElement username_field = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
		username_field.sendKeys("ryanairTestMHH@mailinator.com");
		
		// Sending "Password" text
		MobileElement password_field = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
		password_field.sendKeys("T3st1989");
		
		// Pressing "Back" button
		driver.navigate().back();
		
		// Tapping on "Login" button
		MobileElement login_button2 = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/login");
		login_button2.click();
	}
	
	public void payment () throws InterruptedException{
		// Call to function that allows to avoid the problem in which Appium is not able to find elements. 
		solveProblem ();
		
		//Introducing incorrect card number
		MobileElement card_number = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/credit_card_text");
		card_number.sendKeys("5555555555555555");
		
		// Introducing Name on card
		MobileElement card_name = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/fr_edit_text");
		card_name.sendKeys("TestRyanair MobileApp");
		
		// Pressing "Back" button in order to view all the screen. 
		driver.navigate().back();
		
		// Filling Street information
		MobileElement billing_address = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
		billing_address.sendKeys("Test_Street");
		
		// Pressing "Back" button in order to view all the screen. 
		driver.navigate().back();
		
		// Filling City information
		MobileElement city = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
		city.sendKeys("City");
		
		// Pressing "Back" button in order to view all the screen.
		driver.navigate().back();
		
		// Filling PostCode information
		MobileElement postcode = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
		postcode.sendKeys("00117");
		
		// Selecting country
		MobileElement country =(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
		country.click();
				
		// Call to function that allows to avoid the problem in which Appium is not able to find elements. 
		solveProblem ();
		
		// Searching and selecting the country
		MobileElement search_field = (MobileElement) driver.findElementById("android:id/search_src_text");
		search_field.sendKeys("Spain");
		MobileElement first_option = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.RelativeLayout");
		first_option.click();
		
		// Going back in order to quit the keyboard
		driver.navigate().back();
		
		Thread.sleep(1500);
		
		// Swipe the screen - REVIEW
		driver.swipe(664, 1597, 664, 1197, 2000);
		
		// Accepting "Terms & Conditons" 
		MobileElement conditions_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/payment_terms_and_conditions");
		conditions_button.click();
		
		// Clicking on "Pay Now" button
		MobileElement payNow_button = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/price_breakdown_cta");
		payNow_button.click();
		
		// Printing message over Number Credit Card
		MobileElement message = (MobileElement) driver.findElementById("com.ryanair.cheapflights:id/cc_title");
		//System.out.println(message.getText());
		System.out.println ("Message equal to:' " + message.getText() + " '");			
				
		
		Thread.sleep(2000);
		
	}

}