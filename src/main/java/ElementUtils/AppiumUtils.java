package ElementUtils;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumUtils {

    private AndroidDriver driver;
   // private JavaScriptUtil jsUtil;


    public AppiumUtils(AndroidDriver driver) {
        this.driver = driver;
       // jsUtil = new JavaScriptUtil(this.driver);
    }

    public void doClickID(String loc) {

        driver.findElement(AppiumBy.id(loc)).click();
    }



    public WebElement waitForElementVisibleById( String loc, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
    }

    public WebElement waitForElementVisibleByXpath( String loc, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
    }
    public  boolean isElementVisible(String loc, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public Boolean waitForElementInVisible(String loc, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loc)));
    }

    public WebElement IsElementVisible(String loc, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loc)));
    }



    public void doSendTextXpath( String loc, String txt) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc))).sendKeys(txt);
    }

    public void doClickXpath(String locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
    }

    public void doClickId(String locator, int timeOut) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locator))).click();
        //  return null;
    }






   /* public WebElement getElement(AppiumBy locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
            System.out.println("element is found with locator: " + locator);
        } catch (NoSuchElementException e) {
            System.out.println("Element is not found using this locator..." + locator);
            //  element = waitForElementVisible(locator, 70);
        }

        if(Boolean.parseBoolean(DriverFactory.highlightElement)) {
            jsUtil.flash(element);
        }
        return element;*/
    }


