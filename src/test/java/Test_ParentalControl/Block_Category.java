package Test_ParentalControl;

import PageFactory.ParentalFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stcHomeApp.Home;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;

import static actions.MobileActions.Screenshot;
import static actions.MobileActions.isScreenShot;

public class Block_Category extends Home {
    public Block_Category(AndroidDriver driver) {
        super(driver);
    }
    static ExtentTest test;

    //TC0232

    @Test
    public void BlockCategoryTest() throws InterruptedException, NoSuchElementException {
        test = ExtentReport.shared().getExtentTest("Block category");
        test.assignCategory("Regression");
        ParentalFactory P = new ParentalFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        String id = "xunison.com.smarthomeapp:id/scroll_view";
        String className = "android.widget.FrameLayout";
        String text = "Add category";


        driver.findElementByXPath("//android.widget.TextView[@text='realme-C11']").click();
        Log.addLog("Device selected");
        test.log(Status.INFO, "Device selected");

        wait.until(ExpectedConditions.elementToBeClickable(P.InternetAccess));

        findElement(id,className,text);

        if(isScreenShot()) {
            captureScreenShot();
        }

        BlockListCategoryButton();

        if(isScreenShot()) {
            captureScreenShot();
        }

        driver.findElementByXPath("//android.widget.TextView[@text='Gambling']").click();
        Log.addLog("Gambling category has been selected");

        AddCategoryButton();

        AddBlockCatButton();

    }

    private void findElement (String id, String className, String text) {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"" + id + "\")).getChildByText("
                            + "new UiSelector().className(\"" + className + "\"), \"" + text + "\")")).click();

            Log.addLog("Add category button found");
        } catch (Exception e) {
            Log.addLog("Add category button not found");
        }

    }

    public void BlockListCategoryButton() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.BlockListCat != null) {
            P.BlockListCat.click();
            Log.addLog("Add Block category button clicked");
            test.log(Status.INFO, "Add Block category button clicked");
        } else {
            Log.addLog("Add Block category button not visible");
            test.log(Status.FAIL, "Add Block category button not visible");
        }
    }

    public void AddCategoryButton() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.AddCategory != null) {
            P.AddCategory.click();
            Log.addLog("Add category button clicked");
            test.log(Status.INFO, "Add category button clicked");
        } else {
            Log.addLog("Add category button not visible");
            test.log(Status.FAIL, "Add category button not visible");
        }
    }

    public void AddBlockCatButton() {
        ParentalFactory P = new ParentalFactory(driver);
        if (P.AddBlockCat != null) {
            P.AddBlockCat.click();
            Log.addLog("Block category button clicked");
            test.log(Status.INFO, "Block category button clicked");
        } else {
            Log.addLog("Block category button not visible");
            test.log(Status.FAIL, "Block category button not visible");
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
