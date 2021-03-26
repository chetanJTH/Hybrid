package Test_ParentalControl;

import PageFactory.ParentalFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;
import static utils.Log.println;

public class Check_SocialHistory extends Home {
    public Check_SocialHistory(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0218

    @Test
    public void CheckSocialHistoryTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Check social history");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        List<AndroidElement> Website = driver.findElements(By.id("xunison.com.smarthomeapp:id/item_sv_social_history_title_tv"));
        List<AndroidElement>  Time = driver.findElements(By.id("xunison.com.smarthomeapp:id/item_sv_social_history_time_tv"));

        Thread.sleep(1500);

//        getHistory(25);

        history(Website,Time);

        if(isScreenShot()) {
            captureScreenShot();
        }



    }

    public static void history(List<AndroidElement> website, List<AndroidElement> time) {
        int i=0;
        for (AndroidElement androidDevice : website) {
            Log.addLog(website.get(i).getText()+"---"+ time.get(i).getText());
            i++;
        }

    }

    int currentIndex = 0;
    private void getHistory(int _index) {
        TouchAction t = new TouchAction(driver);

        int index = _index;
        String id = "xunison.com.smarthomeapp:id/device_rl_container";
        List<MobileElement> listItems = driver.findElementsById(id);

        AndroidElement firstElement = (AndroidElement) listItems.get(0);
        AndroidElement lastElement = (AndroidElement) listItems.get(listItems.size() - 2);


        Point fromPoint = lastElement.getCenter();
        Point endPoint = firstElement.getCenter();
        while (index > listItems.size()) {
            println("scroll");

            actions.ScrollOnScreen(fromPoint, endPoint);
            index -= listItems.size();

        }

        println("total: " + listItems.size());

    }

    public static void captureScreenShot(){
        String screenShotPath = Screenshot("");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void TodayHistory() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.Today != null) {
            P.Today.click();
            Log.addLog("Week button clicked");
            test.log(Status.INFO, "Week button clicked");
        } else {
            Log.addLog("Week button not found");
            test.log(Status.FAIL, "Week button not found");
        }
    }
}
