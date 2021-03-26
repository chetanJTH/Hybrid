package BasePackage;


import Case_ParentalControl.*;

import actions.MobileActions;
import com.aventstack.extentreports.ExtentReports;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.Apps;
import utils.Devices;
import utils.Log;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import static actions.MobileActions.setScreenShot;


public class BaseTest {


    protected AndroidDriver driver;
    protected MobileActions actions;
    protected ExtentReports extent;
    protected TestManager loginAndroid;

    //   Login Module



    // Parental Control Module

    protected Parental_ControlPageCase parental_controlPageCase;
    protected Parental_DeviceStatusCase parental_deviceStatusCase;
    protected Check_InternetAccessCase check_internetAccessCase;
    protected Block_WebsiteCase block_websiteCase;
    protected Access_BlockWebsiteCase access_blockWebsiteCase;
    protected Unblock_WebsiteCase unblock_websiteCase;
    protected Access_UnblockWebsiteCase access_unblockWebsiteCase;
    protected Block_MultipleURLCase block_multipleURLCase;
    protected Search_TwitterCase search_twitterCase;
    protected Block_ResentSearchCase block_resentSearchCase;
    protected Block_CategoryCase block_categoryCase;
    protected Access_BlockCategoryCase access_blockCategoryCase;
    protected Unblock_CategoryCase unblock_categoryCase;
    protected Access_UnblockCategoryCase access_unblockCategoryCase;
    protected Check_SupervisionPageCase check_supervisionPageCase;
    protected Check_Web_SupervisionCase check_web_supervisionCase;
    protected Today_Web_SupervisionCase today_web_supervisionCase;
    protected Today_Device_Web_SupervisionCase today_device_web_supervisionCase;
    protected Week_Web_SupervisionCase week_web_supervisionCase;
    protected Week_Device_Web_SupervisionCase week_device_web_supervisionCase;
    protected Fourteen_Web_SupervisionCase fourteen_web_supervisionCase;
    protected Fourteen_Device_Web_SupervisionCase fourteen_device_web_supervisionCase;
    protected Thirty_Web_SupervisionCase thirty_web_supervisionCase;
    protected Thirty_Device_Web_SupervisionCase thirty_device_web_supervisionCase;
    protected Check_DeviceCategoryCase check_deviceCategoryCase;
    protected Check_WebHistoryCase check_webHistoryCase;
    protected Block_URLCase block_urlCase;
    protected Access_BlockedURLCase access_blockedURLCase;
    protected Unblock_URLCase unblock_urlCase;
    protected Allowed_WebsiteCase allowed_websiteCase;
    protected Failed_AttemptCase failed_attemptCase;
    protected Check_Social_SupervisionCase check_social_supervisionCase;
    protected Check_PieChartCase check_pieChartCase;
    protected Check_SocialHistoryCase check_socialHistoryCase;
    protected Check_Device_SocialHistoryCase check_device_socialHistoryCase;
    protected Week_Social_SupervisionCase week_social_supervisionCase;
    protected Week_Device_Social_SupervisionCase week_device_social_supervisionCase;
    protected Fourteen_Social_SupervisionCase fourteen_social_supervisionCase;
    protected Fourteen_Device_Social_SupervisionCase fourteen_device_social_supervisionCase;
    protected Thirty_Social_SupervisionCase thirty_social_supervisionCase;
    protected Thirty_Device_Social_SupervisionCase thirty_device_social_supervisionCase;



    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentReport.shared().getExtent();
        setScreenShot(false);
    }



    @BeforeClass
    void setupDriver() throws InterruptedException {


        //1 times
        Devices device = Devices.Realme;
        loginAndroid = TestManager.testAndroid(device, Apps.stcDebug);




        // Parental Module

        parental_controlPageCase= new Parental_ControlPageCase(loginAndroid.getDriverAndroid());
        parental_deviceStatusCase = new Parental_DeviceStatusCase(loginAndroid.getDriverAndroid());
        check_internetAccessCase = new Check_InternetAccessCase(loginAndroid.getDriverAndroid());
        block_websiteCase = new Block_WebsiteCase(loginAndroid.getDriverAndroid());
        access_blockWebsiteCase = new Access_BlockWebsiteCase(loginAndroid.getDriverAndroid());
        unblock_websiteCase = new Unblock_WebsiteCase(loginAndroid.getDriverAndroid());
        access_unblockWebsiteCase = new Access_UnblockWebsiteCase(loginAndroid.getDriverAndroid());
        block_multipleURLCase = new Block_MultipleURLCase(loginAndroid.getDriverAndroid());
        search_twitterCase = new Search_TwitterCase(loginAndroid.getDriverAndroid());
        block_resentSearchCase = new Block_ResentSearchCase(loginAndroid.getDriverAndroid());
        block_categoryCase = new Block_CategoryCase(loginAndroid.getDriverAndroid());
        access_blockCategoryCase = new Access_BlockCategoryCase(loginAndroid.getDriverAndroid());
        unblock_categoryCase = new Unblock_CategoryCase(loginAndroid.getDriverAndroid());
        access_unblockCategoryCase = new Access_UnblockCategoryCase(loginAndroid.getDriverAndroid());
        check_supervisionPageCase = new Check_SupervisionPageCase(loginAndroid.getDriverAndroid());
        check_web_supervisionCase = new Check_Web_SupervisionCase(loginAndroid.getDriverAndroid());
        today_web_supervisionCase = new Today_Web_SupervisionCase(loginAndroid.getDriverAndroid());
        today_device_web_supervisionCase = new Today_Device_Web_SupervisionCase(loginAndroid.getDriverAndroid());
        week_web_supervisionCase = new Week_Web_SupervisionCase(loginAndroid.getDriverAndroid());
        week_device_web_supervisionCase = new Week_Device_Web_SupervisionCase(loginAndroid.getDriverAndroid());
        fourteen_web_supervisionCase = new Fourteen_Web_SupervisionCase(loginAndroid.getDriverAndroid());
        fourteen_device_web_supervisionCase = new Fourteen_Device_Web_SupervisionCase(loginAndroid.getDriverAndroid());
        thirty_web_supervisionCase = new Thirty_Web_SupervisionCase(loginAndroid.getDriverAndroid());
        thirty_device_web_supervisionCase = new Thirty_Device_Web_SupervisionCase(loginAndroid.getDriverAndroid());
        check_deviceCategoryCase = new Check_DeviceCategoryCase(loginAndroid.getDriverAndroid());
        check_webHistoryCase = new Check_WebHistoryCase(loginAndroid.getDriverAndroid());
        block_urlCase = new Block_URLCase(loginAndroid.getDriverAndroid());
        access_blockedURLCase = new Access_BlockedURLCase(loginAndroid.getDriverAndroid());
        unblock_urlCase = new Unblock_URLCase(loginAndroid.getDriverAndroid());
        allowed_websiteCase = new Allowed_WebsiteCase(loginAndroid.getDriverAndroid());
        failed_attemptCase = new Failed_AttemptCase(loginAndroid.getDriverAndroid());
        check_social_supervisionCase = new Check_Social_SupervisionCase(loginAndroid.getDriverAndroid());
        check_pieChartCase = new Check_PieChartCase(loginAndroid.getDriverAndroid());
        check_socialHistoryCase = new Check_SocialHistoryCase(loginAndroid.getDriverAndroid());
        check_device_socialHistoryCase = new Check_Device_SocialHistoryCase(loginAndroid.getDriverAndroid());
        week_social_supervisionCase = new Week_Social_SupervisionCase(loginAndroid.getDriverAndroid());
        week_device_social_supervisionCase = new Week_Device_Social_SupervisionCase(loginAndroid.getDriverAndroid());
        fourteen_social_supervisionCase = new Fourteen_Social_SupervisionCase(loginAndroid.getDriverAndroid());
        fourteen_device_social_supervisionCase = new Fourteen_Device_Social_SupervisionCase(loginAndroid.getDriverAndroid());
        thirty_social_supervisionCase = new Thirty_Social_SupervisionCase(loginAndroid.getDriverAndroid());
        thirty_device_social_supervisionCase = new Thirty_Device_Social_SupervisionCase(loginAndroid.getDriverAndroid());

    }



    @AfterTest
    void endTest() throws Exception {
        MobileActions.captureLog("adbLog");

        loginAndroid.quitTest();
    }


    @AfterSuite
    void flushReport(){
        extent.flush();
    }


}