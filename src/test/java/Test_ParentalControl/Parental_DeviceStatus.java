package Test_ParentalControl;

import PageFactory.SmartHomeFactory;
import PageFactory.loginFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Parental_DeviceStatus extends Home {
    public Parental_DeviceStatus(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0218

    @Test
    public void ParentalDeviceStatusTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check parental control page");
        test.assignCategory("Regression");
        SmartHomeFactory G = new SmartHomeFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);




        List <AndroidElement> device = driver.findElements(By.id("xunison.com.smarthomeapp:id/item_pc_device_name_tv"));
        List <AndroidElement> status = driver.findElements(By.id("xunison.com.smarthomeapp:id/item_pc_device_status_tv"));

        int i=0;
           for (AndroidElement androidDevice : device) {
            Log.addLog(device.get(i).getText()+"---"+ status.get(i).getText()) ;
            i++;
      }


        if(isScreenShot()) {
            captureScreenShot();
        }

    }







    public void EnterPassword() {
        loginFactory L = new loginFactory(this.driver);
        if (L.Password != null) {
            L.Password.sendKeys("demo1234");
            Log.addLog("Valid password address has been entered");
            test.log(Status.INFO, "Valid password address has been entered");
        } else {
            Log.addLog("Password field not visible");
            test.log(Status.FAIL, "Password field not visible");
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
