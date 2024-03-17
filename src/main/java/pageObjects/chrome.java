package pageObjects;


import ElementUtils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


public class chrome {
    private AndroidDriver driver;
    private AppiumUtils eleUtil;
    WebElement e;

    // 1. const. of the page class
    public chrome(AndroidDriver driver) {
        this.driver = driver;
        eleUtil = new AppiumUtils(this.driver);
        //  PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
String homePage = "//android.widget.ImageButton[@content-desc=\"Open the home page\"]";
String searchBox = "//android.widget.EditText[@resource-id=\"com.android.chrome:id/search_box_text\"]";
String click =  "(//android.view.View[@resource-id=\"com.android.chrome:id/tile_view_icon_background\"])[1]";

String searchProducts = "//android.webkit.WebView[@text=\"Flipkart\"]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText";

String searchIcon = "//android.webkit.WebView[@text=\"Flipkart\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]";

String clickOnPhones = "//android.view.View[@content-desc=\"phone 5g phone 5g in Mobiles\"]/android.view.View";
public void launchChrome(){

    eleUtil.waitForElementVisibleByXpath(homePage, 70);
    eleUtil.doClickXpath(homePage);
    eleUtil.waitForElementVisibleByXpath(searchBox, 70);
    eleUtil.doSendTextXpath(searchBox,"flipkart.com");
    eleUtil.waitForElementVisibleByXpath(click, 70);
    eleUtil.doClickXpath(click);
    eleUtil.waitForElementVisibleByXpath(searchIcon, 70);
    eleUtil.doClickXpath(searchIcon);
    eleUtil.waitForElementVisibleByXpath(searchProducts, 70);
    eleUtil.doSendTextXpath(searchProducts,"phones");
    eleUtil.waitForElementVisibleByXpath(clickOnPhones, 70);
    eleUtil.doClickXpath(clickOnPhones);


}


}
