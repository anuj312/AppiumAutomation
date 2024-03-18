package base;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class baseClass {

    public static AndroidDriver driver;
    public static WebDriverWait waits;
    private static AppiumDriverLocalService appiumService;
    String path = "C://Appium//AppiumServer//Appium-Server-GUI-windows-1.22.3-4//resources//app//node_modules//appium//build//lib//main.js";
    String Appium_Node_Path="C://Program Files//nodejs//node.exe";
    String systemPath = System.getProperty("user.dir");

    @BeforeClass
    public void setup() throws IOException, InterruptedException {

      /*  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./test-outputs/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);*/

        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(Appium_Node_Path)).withAppiumJS(new File(path))
                .withIPAddress("127.0.0.1")
                .withArgument(GeneralServerFlag.BASEPATH,"wd/hub/")
                .usingPort(4723));

        appiumService.start();
        Thread.sleep(10000);
        String batCommand = "cmd /c start "+systemPath+"//src//main//resources//emulator//emulator.bat";
        Runtime.getRuntime().exec(batCommand);
        Thread.sleep(10000);
        LaunchAppiumServer();

    }


    public void LaunchAppiumServer() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // //
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
       // capabilities.setCapability("no",true);
        capabilities.setCapability("newCommandTimeout", 100000);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

      //  capabilities.setCapability("chromeOptions", ImmutableMap.of("w3c",false));

        URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub/");


        driver = new AndroidDriver(appiumServerURL, capabilities);
        waits = new WebDriverWait(driver,Duration.ofSeconds(50));

        boolean isAppInstalled = driver.isAppInstalled("com.wsandroid.suite");



        if(isAppInstalled){
            driver.startActivity(new Activity("com.wsandroid.suite","com.android.mcafee.ui.framework.BaseActivity"));
        }
        else{
            driver.installApp(systemPath+"//src//main//resources//apks//QAm.apk");
            try {
                driver.startActivity(new Activity("com.wsandroid.suite","com.android.mcafee.ui.framework.BaseActivity"));
            }
            catch(Exception e){
            }

        }

      /*  boolean isAppInstalled = driver.isAppInstalled("com.android.chrome");

        if(isAppInstalled){
            driver.startActivity(new Activity("com.android.chrome","com.google.android.apps.chrome.Main"));
        }
        else{
            driver.installApp(systemPath+"//src//main//resources//apks//QA.apk");
            try {
                driver.startActivity(new Activity("com.android.chrome","com.google.android.apps.chrome.Main"));
            }
            catch(Exception e){
            }

       } */
    }


    @AfterClass
    public void tearDown() {
       // driver.removeApp("com.wsandroid.suite");
        if (appiumService != null) {
            appiumService.stop();
        }

    }
    protected void captureScreenshot(String testName) {
        if (driver != null) {
            try {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = "./screenshots/" + testName + ".png";
                FileHandler.copy(screenshotFile, new File(screenshotPath));
                System.out.println("Screenshot captured: " + screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver is null. Cannot capture screenshot.");
        }
    }


   /* @Test
    public void desiredCap() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "fc7b6632");
        capabilities.setCapability("appPackage", "com.wsandroid.suite");
        capabilities.setCapability("appActivity", "com.android.mcafee.ui.framework.BaseActivity");
        capabilities.setCapability("automationName", "UiAutomator2");

        URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub/"); // Appium server address
        AndroidDriver driver = new AndroidDriver(serverUrl, capabilities);
    }*/
}
