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

public class Forgot_Password2 extends Home {
    public Forgot_Password2(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    @Test
    public void ForgotPasswordTest2() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Verify Forgot Password");
        test.assignCategory("Regression");
        loginFactory L = new loginFactory(this.driver);
        WebDriverWait waitForToast = new WebDriverWait(driver,25);

        //TC2042


        L.EmailAddress.sendKeys("abc@abc.com");
        Log.addLog("Valid email address has been entered");
        test.log(Status.INFO, "Valid email address has been entered");

        SendEmailButton();

        waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
        WebElement toastMessage = (WebElement) driver.findElement(By.xpath("/hierarchy/android.widget.Toast"));
        Assert.assertEquals(toastMessage.getText(),"Reset link has been sent on your email, please follow it and set new password!");

        Log.addLog("Success toast message has been displayed");
        test.log(Status.INFO, "Success toast message has been displayed");

        if(isScreenShot()) {
            captureScreenShot();
        }




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

    public void SendEmailButton() {
        loginFactory L = new loginFactory(this.driver);
        if (L.SendEmail != null) {
            L.SendEmail.click();
            Log.addLog("Send email button is clicked");
            test.log(Status.INFO, "Send email button is clicked");
        } else {
            Log.addLog("Send email button is not visible");
            test.log(Status.FAIL, "Send email button is not visible");
        }
    }


    public static void captureScreenShot(){
        String screenShotPath = Screenshot("Image");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
