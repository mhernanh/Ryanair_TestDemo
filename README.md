# Ryanair_TestDemo
Repository created for the technical test for Ryanair job posisition. 

///////////////////

REQUIREMENTS: 

- JRE installed. *
- ADB tool installed *
- Android API version downloaded equal to the one installed in the device

 *The system path must contains the proper routes from this elements. 

///////////////////

TEST ENVIRONMENT: 

- Eclipse IDE (Oxygen 4.7.1.a) + TestNG plugin (6.13.1) 
- Appium v1.7.2
- Moto G5 Plus (Android Oreo 8.1.0)
- Ryanair App from Play Store

This test has built on Java with the using of Maven for the dependencies. In order to execute the test is necessary to run the "testng_MotoG5Plus_demo.xml" file as "TestNG". 

That file contains the environment details. 
- "udid": you can get it from CMD with the command "adb -devices" when the device is connected.
- "devicemodel": field that identifies easily the device used
- "platformVersion": Android version running on the device
- "platformName": Android or iOS. 
- "ip": ip configured on Appium
- "port": port configured on Appium. 


///////////////////

TEST DETAILS: 

This test is created in order to check the message when a wrong credit card is introduced during the payment. The steps done during the test are: 

- Launch App
- Book a flight (selecting places and dates)
- Introducing client information and travel options (like baggage and seat)
- Login into the application
- Filling the information to proceed to the payment. 

NOTES: 

I have found several difficulties during the test. The most relevant was that the XML tree is not always properly received by Appium. After several tries I found a "solution" ( *solveProblem* function). 
Other difficult was that, after certain day, the process is not as the day after and some options or fields changes, making disfunctional the test. 
The great majority of the elements on the screen are used by its XPATH. This makes less robust the execution. 

///////////////////

I have also send to your HR colleagues a video captured during the execution to show the steps and the result. 

For any doubt, please contact with me on "m.hernan89@hotmail.com" 
