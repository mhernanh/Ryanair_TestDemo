# Ryanair_TestDemo
Repository created for the techinical test for Ryanair job posisition. 

Requirements: 

- JRE installed. *
- ADB tool installed *
- Android API version downloaded equal to the one installed in the device

* The system path must contains the proper routes from this elements. 

Test environment: 

- Eclipse IDE (Oxygen 4.7.1.a) + TestNG plugin (6.13.1) 
- Appium v1.7.2
- Moto G5 Plus (Android Oreo 8.1.0)

This test has built on Java with the using of Maven for the dependencies. In order to execute the test is necessary to run the "testng_MotoG5Plus_demo.xml" file as "TestNG". 

That file contains the environment details. 
- "udid": you can get it from CMD with the command "adb -devices" when the device is connected.
- "devicemodel": field that identifies easily the device used
- "platformVersion": Android version running on the device
- "platformName": Android or iOS. 
- "ip": ip configured on Appium
- "port": port configured on Appium. 


For any doubt, please contact with me on "m.hernan89@hotmail.com" 
