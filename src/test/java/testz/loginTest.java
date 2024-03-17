package testz;

import ElementUtils.ExtentReportListener;
import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.chrome;
import pageObjects.login;

@Listeners(ExtentReportListener.class)
public class loginTest extends baseClass {

    private login log;
    private chrome ch;


    @BeforeClass(alwaysRun = true)
    public void LoginM1A(){
        log = new login(driver);
        ch = new chrome(driver);
    }

    @Test(priority = 1)
    public void verifyWifiScan(){

        log.checkWifiIsSafe();
    }

    @Test(priority = 2)
    public void verifyAntivirusScan() throws InterruptedException {

        log.verifyAntivirusScan();
    }

    @Test(priority = 3)
    public void verifyIncorrectLogin() throws InterruptedException {

        log.verifyInvalidCredentials();
      //  ch.launchChrome();
    }

    @Test(priority = 4)
    public void verifyFailure() throws InterruptedException {

        Assert.fail();
    }






}
