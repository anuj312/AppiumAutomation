package pageObjects;


import ElementUtils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;



public class login {

    private AndroidDriver driver;
    private AppiumUtils eleUtil;
    WebElement e;

    // 1. const. of the page class
    public login(AndroidDriver driver) {
        this.driver = driver;
        eleUtil = new AppiumUtils(this.driver);
        //  PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    // 2. private By locators:


    String accept = "com.wsandroid.suite:id/btn_accept";
    String acceptAndContinueBtnn = "com.wsandroid.suite:id/btn_accept";

    String may = "//androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View[1]/android.widget.Button";

    String closeId = "com.wsandroid.suite:id/closeIcon";

    String SignInXpath = "//android.widget.TextView[@resource-id=\"dashboard_activation_signin\"]";
    String btnSignInId = "com.wsandroid.suite:id/btnSignIn";
    String emailXpath = "//android.widget.EditText[@resource-id=\"email\"]";
    String passwordXpath = "//android.widget.EditText[@resource-id=\"password\"]";
    String SignInButtonXpath = "//android.widget.Button[@resource-id=\"sign-in-button\"]";

    String tryAgain = "//android.widget.Button[@resource-id=\"com.wsandroid.suite:id/btnTryAgain\"]";
/*________________________________________________________________________________________________________*/

    //check if your wifi is scure
    String turnOnLocationWhileUsingApp = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]";
String checkWifiSecure ="//android.view.View[@resource-id=\"dashboard_FeatureCard_WIFI1\"]";
String scanNow = "//android.widget.Button[@resource-id=\"com.wsandroid.suite:id/scan_now_btn\"]";

String turnOnLoc = "//android.widget.Button[@resource-id=\"com.wsandroid.suite:id/btn_continue\"]";
String openAppSetting = "//android.widget.Button[@resource-id=\"com.wsandroid.suite:id/go_to_setting_btn\"]";
String permissions = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.android.settings:id/recycler_view\"]/android.widget.LinearLayout[3]/android.widget.RelativeLayout";

String locationAllowed = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.android.permissioncontroller:id/recycler_view\"]/android.widget.LinearLayout[3]/android.widget.RelativeLayout";
String locationAllowAllTheTime = "//android.widget.RadioButton[@resource-id=\"com.android.permissioncontroller:id/allow_always_radio_button\"]";

String goBack = "//android.widget.ImageButton[@content-desc=\"Back\"]";

String maybeLater = "//android.widget.Button[@resource-id=\"com.wsandroid.suite:id/maybe_later_btn\"]";

String email = "//android.webkit.WebView[@text=\"McAfee Unified Authentication\"]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText";
String password = "//android.webkit.WebView[@text=\"McAfee Unified Authentication\"]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText";

    String signIn = "//android.widget.Button[@text=\"Sign in\"]";

    String incorrectCreds = "//android.widget.TextView[@text=\"We couldn’t sign you with this email and password. Try again, \"]";



    public void verifyInvalidCredentials() throws InterruptedException {

        try {
            eleUtil.waitForElementVisibleById(acceptAndContinueBtnn, 70);
            eleUtil.doClickId(acceptAndContinueBtnn, 70);

            if(eleUtil.isElementVisible(may,50)) {
                eleUtil.waitForElementVisibleByXpath(may, 70);
                eleUtil.doClickXpath(may);
                eleUtil.waitForElementVisibleById(closeId, 50);
                eleUtil.doClickId(closeId, 10);
            }

        }
        catch (Exception e){
            System.out.println("Exception found");
        }
        eleUtil.waitForElementVisibleByXpath(SignInXpath, 50);
        eleUtil.doClickXpath(SignInXpath);
        eleUtil.waitForElementVisibleById(btnSignInId,50);
        eleUtil.doClickId(btnSignInId,10);
        eleUtil.waitForElementVisibleByXpath(email,50);
        eleUtil.doSendTextXpath(email,"anuj@gmail.com");
        eleUtil.waitForElementVisibleByXpath(password,50);
        eleUtil.doSendTextXpath(password,"anuj@gmail.com");

        eleUtil.doClickXpath(signIn);

        if(!eleUtil.waitForElementInVisible(incorrectCreds,100)){
            System.out.println("Passedmm");
        }
        Thread.sleep(10000);

    }

    public void checkWifiIsSafe(){


       // eleUtil.IsElementVisible(acceptAndContinueBtnn, 70);

        try
        {
            eleUtil.waitForElementVisibleById(acceptAndContinueBtnn, 70);
            eleUtil.doClickId(acceptAndContinueBtnn, 70);
            if(eleUtil.isElementVisible(may,50)) {
                eleUtil.doClickXpath(may);
                eleUtil.waitForElementVisibleById(closeId, 50);
                eleUtil.doClickId(closeId, 10);
            }
        }
        catch (NoSuchElementException e){
            System.out.println("Not Found");
        }
        catch (TimeoutException e){
            System.out.println("Not Found timeOut");
        }
        eleUtil.waitForElementVisibleByXpath(checkWifiSecure, 70);
        eleUtil.doClickXpath(checkWifiSecure);
        eleUtil.waitForElementVisibleByXpath(scanNow, 70);
        eleUtil.doClickXpath(scanNow);
        eleUtil.waitForElementVisibleByXpath(turnOnLoc, 70);
        eleUtil.doClickXpath(turnOnLoc);
        eleUtil.waitForElementVisibleByXpath(turnOnLocationWhileUsingApp, 70);
        eleUtil.doClickXpath(turnOnLocationWhileUsingApp);
        eleUtil.waitForElementVisibleByXpath(turnOnLoc, 70);
        eleUtil.doClickXpath(turnOnLoc);
        eleUtil.waitForElementVisibleByXpath(openAppSetting, 70);
        eleUtil.doClickXpath(openAppSetting);
        eleUtil.waitForElementVisibleByXpath(permissions, 70);
        eleUtil.doClickXpath(permissions);
        eleUtil.waitForElementVisibleByXpath(locationAllowed, 70);
        eleUtil.doClickXpath(locationAllowed);
        eleUtil.waitForElementVisibleByXpath(locationAllowAllTheTime, 70);
        eleUtil.doClickXpath(locationAllowAllTheTime);
        eleUtil.waitForElementVisibleByXpath(goBack, 70);
        eleUtil.doClickXpath(goBack);
        eleUtil.waitForElementVisibleByXpath(goBack, 70);
        eleUtil.doClickXpath(goBack);
        eleUtil.waitForElementVisibleByXpath(goBack, 70);
        eleUtil.doClickXpath(goBack);
        eleUtil.waitForElementVisibleByXpath(maybeLater, 70);
        eleUtil.doClickXpath(maybeLater);

    }


    // RUN ANTIVIRUS SCAN

    String runScan = "//android.view.View[@resource-id=\"dashboard_FeatureCard_AV3\"]";
    String scan = "//android.widget.TextView[@resource-id=\"com.wsandroid.suite:id/startScanView\"]";
    String updatePermissions = "//android.widget.Button[@resource-id=\"com.wsandroid.suite:id/primaryButton\"]";

    String grantPermission = "//android.widget.Button[@resource-id=\"com.wsandroid.suite:id/btnSetupPermission\"]";

    String allowAccess = "//android.widget.Switch[@resource-id=\"android:id/switch_widget\"]";

    String maybeLaterr = "//android.widget.Button[@resource-id=\"com.wsandroid.suite:id/btn_vsm_subscription_secondary_action\"]";

    String stopScan = "//android.widget.Button[@resource-id=\"com.wsandroid.suite:id/btnStopScan\"]";


    public void verifyAntivirusScan(){

        eleUtil.waitForElementVisibleByXpath(runScan, 70);
    eleUtil.doClickXpath(runScan);
    eleUtil.waitForElementVisibleByXpath(scan, 70);
    eleUtil.doClickXpath(scan);
    try {
    eleUtil.waitForElementVisibleByXpath(updatePermissions, 70);
    eleUtil.doClickXpath(updatePermissions);
    eleUtil.waitForElementVisibleByXpath(grantPermission, 70);
    eleUtil.doClickXpath(grantPermission);
    eleUtil.waitForElementVisibleByXpath(allowAccess, 70);
    eleUtil.doClickXpath(allowAccess);
    eleUtil.waitForElementVisibleByXpath(goBack, 70);
    eleUtil.doClickXpath(goBack);
}
catch (Exception e){
    System.out.println("Exception found");
}
        eleUtil.waitForElementInVisible(stopScan,500);
        eleUtil.waitForElementVisibleByXpath(maybeLaterr, 70);
        eleUtil.doClickXpath(maybeLaterr);

    }

        /*________________________________________________________________________________________________________________________________*/
        //  $(acceptAndContinueBtn).shouldBe(Condition.visible, Duration.ofSeconds(50)).click();
        //  SelenideAppium.$(cls).shouldBe(Condition.appear).click();

        // eleUtil.waitForElementVisible(acceptAndContinueBtn, 60);
        // acceptAndContinueBtn.click();
        //  driver.findElement(AppiumBy.id("com.wsandroid.suite:id/btn_accept")).click();


       /* eleUtil.waitForElementVisible(cls, 45);
        eleUtil.doClick(cls,10);

        eleUtil.waitForElementVisible(closeIcon, 45);
        eleUtil.doClick(closeIcon,10);

        eleUtil.waitForElementVisible(FirstsignIn, 45);
        eleUtil.doClick(FirstsignIn,10);

        eleUtil.waitForElementVisible(SecondSignIN, 45);
        eleUtil.doClick(SecondSignIN,10);

        eleUtil.waitForElementVisible(email, 45);
        eleUtil.doSendKeys(email, "A@GMAIL.COM");

        eleUtil.waitForElementVisible(password, 45);
        eleUtil.doSendKeys(password, "A@GMAIL.COM");

        eleUtil.waitForElementVisible(signIN, 45);
        eleUtil.doClick(signIN,10);*/







   /* @AndroidFindBy(xpath="//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")
    private By cls;

    // private By acceptAndContinueBtn = AppiumBy.id("com.wsandroid.suite:id/btn_accept");
    //  private By cls = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");

    private By closeIcon = AppiumBy.id("com.wsandroid.suite:id/closeIcon");

    private By FirstsignIn = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"dashboard_activation_signin\"]");

    private By SecondSignIN = AppiumBy.id("com.wsandroid.suite:id/btnSignIn");

    private By email = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"email\"]");

    private By password = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]");

    private By signIN = AppiumBy.xpath("com.wsandroid.suite:id/btnSignIn");

    @AndroidFindBy(id="com.wsandroid.suite:id/btn_accept")
    private WebElement acceptAndContinueBtn;*/




}
