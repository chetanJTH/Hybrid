package Test_ParentalControl;

import PageFactory.ParentalFactory;
import com.aventstack.extentreports.ExtentTest;
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

public class Check_Device_SocialHistory extends Home {
    public Check_Device_SocialHistory(AndroidDriver driver) {
        super(driver);
    }

    static ExtentTest test;

    //TC0218

    @Test
    public void CheckDeviceSocialHistoryTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check device category");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        String scrollableList = "xunison.com.smarthomeapp:id/devices_rv";
        String elClassName = "android.widget.TextView";
        String el = "realme-C11";

        List<AndroidElement> Website = driver.findElements(By.id("xunison.com.smarthomeapp:id/item_sv_social_history_title_tv"));
        List<AndroidElement>  Time = driver.findElements(By.id("xunison.com.smarthomeapp:id/item_sv_social_history_time_tv"));


        findElement(scrollableList,el);

        driver.findElementByXPath("//android.widget.TextView[@text='realme-C11']").click();

        if(isScreenShot()) {
            captureScreenShot();
        }



        history(Website, Time);


    }

    public void history(List<AndroidElement> website, List<AndroidElement> time) {
        int i=0;
        for (AndroidElement androidElement : website) {
            Log.addLog(website.get(i).getText()+"---"+ time.get(i).getText());
            i++;
        }

    }

//    public String getList() {
//        List<AndroidElement> Website = driver.findElements(By.id("xunison.com.smarthomeapp:id/item_sv_social_history_title_tv"));
//        if (Website.isEmpty())
//            return null;
//        else
//            return Website.get(0).getText();
//    }


    private void findElement(String id, String text) {
        try {
//            driver.findElement(MobileBy.AndroidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\"" + id + "\")).getChildByText("
//                            + "new UiSelector().className(\"" + className + "\"), \"" + text + "\")")).click();

            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
                    + "resourceId(\"" + id + "\"))"
                    + ".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"" + text + "\"))");

            Log.addLog("Device list display");
        } catch (Exception e) {
            Log.addLog("Device does not display");
        }

    }


    public static void captureScreenShot() {
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
