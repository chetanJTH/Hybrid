package Test_Login;

import PageFactory.loginFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Unregister_Email extends Home {
    public Unregister_Email(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;


    @Test
    public void UnregEmailTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Login, case 5");
        test.assignCategory("Regression");
        loginFactory L = new loginFactory(this.driver);
        WebDriverWait waitForToast = new WebDriverWait(driver,25);


        //TC2056

        //     HomePageLogin();

        EmailAddress();

        EnterPassword();

        L.ShowPassword.click();

        LoginButton();

        if(isScreenShot()) {
            captureScreenShot();
        }

        waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
        WebElement toastMessage = (WebElement) driver.findElement(By.xpath("/hierarchy/android.widget.Toast"));
        Assert.assertEquals(toastMessage.getText(),"Incorrect password");


//        WebElement result = (WebElement) driver.findElement(By.id("xunison.com.smarthomeapp:id/textinput_error"));
//        Assert.assertEquals(result.getText(),"Invalid email");

        Log.addLog("Error displayed");
        test.log(Status.INFO, "Error Displayed");


    }





    public void HomePageLogin() {
        loginFactory L = new loginFactory(this.driver);
        if (L.LoginButton != null) {
            L.LoginButton.click();
            Log.addLog("Login button is clicked");
            test.log(Status.INFO, "Login button is clicked");
        } else {
            Log.addLog("Login button is not visible");
            test.log(Status.FAIL, "Login button is not visible");
        }
    }

    public void EmailAddress() {
        loginFactory L = new loginFactory(this.driver);
        if (L.EmailAddress != null) {
            L.EmailAddress.sendKeys("testing.demo@yahoo.com");
            Log.addLog("InValid email address has been entered");
            test.log(Status.INFO, "InValid email address has been entered");
        } else {
            Log.addLog("Email address field not visible");
            test.log(Status.FAIL, "Email address field not visible");
        }
    }

    public void EnterPassword() {
        loginFactory L = new loginFactory(this.driver);
        if (L.Password != null) {
            L.Password.sendKeys("demo1234");
            Log.addLog("Valid password has been entered");
            test.log(Status.INFO, "Valid password has been entered");
        } else {
            Log.addLog("Password field not visible");
            test.log(Status.FAIL, "Password field not visible");
        }
    }

    public void LoginButton() {
        loginFactory L = new loginFactory(this.driver);
        if (L.LoginButton != null) {
            L.LoginButton.click();
            Log.addLog("Login button is clicked");
            test.log(Status.INFO, "Login button is clicked");
        } else {
            Log.addLog("Login button is not visible");
            test.log(Status.FAIL, "Login button is not visible");
        }
    }

    public static void captureScreenShot(){
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
