package Test_Login;

import PageFactory.loginFactory;
import com.aventstack.extentreports.ExtentTest;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.util.NoSuchElementException;
import java.util.Set;

public class Confirm_Registration extends Home{
    public Confirm_Registration(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    @Test
    public void ConfirmRegistrationTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Confirm Registration");
        test.assignCategory("Regression");
        loginFactory L = new loginFactory(driver);



        L.RegisterButton.click();

        L.FirstName.sendKeys("john");

        L.LastName.sendKeys("Doe");

        L.EmailAddress.sendKeys("abc14@gmail.com");

        L.Password.sendKeys("abc123456");

        L.ConfirmPassword.sendKeys("abc123456");

        L.ConfirmRegistration.click();

        driver.navigate().back();


//       try {
//            if (L.AutoSave.isDisplayed()) {
//                driver.findElementById("android:id/autofill_save_yes").click();
//                Log.addLog("autosave");
//                test.log(Status.INFO, "autosave"); }
//            else {  driver.navigate().back();
//                    Log.addLog("redirect to email");
//                    test.log(Status.FAIL, "redirect to email"); }
//         } catch (Exception e) {
//           e.printStackTrace();
//       }



        Set contextNames = driver.getContextHandles();
        Log.addLog(" name " + contextNames);

        driver.context("WEBVIEW_chrome");

        driver.get("http://gmail.com");

        driver.switchTo();

        }



}
