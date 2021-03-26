package Test_ParentalControl;

import PageFactory.ParentalFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;
import static utils.Log.println;

public class Block_URL extends Home {
    public Block_URL(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0232

    @Test
    public void BlockURLTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Block website");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        TouchAction t = new TouchAction(driver);


        selectUrl(2);


        if(isScreenShot()) {
            captureScreenShot();
        }

        BlockWebsiteButton();

        if(isScreenShot()) {
            captureScreenShot();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
        WebElement toastMessage = (WebElement) driver.findElement(By.xpath("/hierarchy/android.widget.Toast"));
        Assert.assertEquals(toastMessage.getText(),"Website blocked successfully");


    }



    public void BlockWebsiteButton() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.BlockSite != null) {
            P.BlockSite.click();
            Log.addLog("Block website button clicked");
            test.log(Status.INFO, "Block website button clicked");
        } else {
            Log.addLog("Block website button not visible");
            test.log(Status.FAIL, "Block website button not visible");
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

    int currentIndex = 0;
    public static String storeUrl = "";
    private void selectUrl(int _index) {
        TouchAction t = new TouchAction(driver);

        int index = _index;
        String id = "xunison.com.smarthomeapp:id/item_sv_web_history_site_tv";
        List<MobileElement> listItems = driver.findElementsById(id);

        AndroidElement firstElement = (AndroidElement) listItems.get(0);
        AndroidElement lastElement = (AndroidElement) listItems.get(listItems.size() - 1);


        Point fromPoint = lastElement.getCenter();
        Point endPoint = firstElement.getCenter();
        while (index > listItems.size()) {
            println("scroll");

            actions.ScrollOnScreen(fromPoint, endPoint);
            index -= listItems.size();
        }
        AndroidElement selectedItem = (AndroidElement) listItems.get(index);
        Log.addLog("selected url " + selectedItem.getText().toString());
        storeUrl = selectedItem.getText().toString();
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(selectedItem)).withDuration(Duration.ofMillis(1500))).release().perform();

    }
}
