package BasePackage;



import Case_Login.*;

import actions.MobileActions;
import com.aventstack.extentreports.ExtentReports;
import extentreports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.Apps;
import utils.Devices;

import java.net.MalformedURLException;

import static actions.MobileActions.setScreenShot;


public class BaseTest {


    protected AndroidDriver driver;
    protected MobileActions actions;
    protected ExtentReports extent;
    protected TestManager loginAndroid;

    //   Login Module

    protected Welcome_PageCase welcome_pageCase;
    protected Login_PageCase login_pageCase;
    protected Login_FieldCase login_fieldCase;
    protected Blank_FiledCase blank_filedCase;
    protected Blank_EmailCase blank_emailCase;
    protected Invalid_EmailCase1 invalid_emailCase1;
    protected Invalid_EmailCase2 invalid_emailCase2;
    protected Unregister_EmailCase unregister_emailCase;
    protected Inactive_CredentialCase inactive_credentialCase;
    protected Invalid_CredentialCase invalid_credentialCase;
    protected Invalid_PasswordCase invalid_passwordCase;
    protected Blank_PasswordCase blank_passwordCase;
    protected Valid_LoginCase valid_loginCase;
    protected Home_PageCase home_pageCase;
    protected Browser_BackCase browser_backCase;
    protected Log_OutCase log_outCase;
    protected Verify_LogoutCase verify_logoutCase;
    protected Browser_Back_LogoutCase browser_back_logoutCase;
    protected Forgot_PasswordCase1 forgot_passwordCase1;
    protected Forgot_PasswordCase2 forgot_passwordCase2;
    protected Wifi_OffCase wifi_offCase;
    protected Confirm_RegistrationCase confirm_registrationCase;







    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentReport.shared().getExtent();
        setScreenShot(false);
    }



    @BeforeClass
    void setupDriver() throws InterruptedException, MalformedURLException {


        //1 times
        Devices device = Devices.Realme;
        loginAndroid = TestManager.testAndroid(device, Apps.stcDebug);



        // Login Module

        welcome_pageCase = new Welcome_PageCase(loginAndroid.getDriverAndroid());
        login_pageCase = new Login_PageCase(loginAndroid.getDriverAndroid());
        login_fieldCase = new Login_FieldCase(loginAndroid.getDriverAndroid());
        blank_filedCase = new Blank_FiledCase(loginAndroid.getDriverAndroid());
        blank_emailCase = new Blank_EmailCase(loginAndroid.getDriverAndroid());
        invalid_emailCase1 = new Invalid_EmailCase1(loginAndroid.getDriverAndroid());
        invalid_emailCase2 = new Invalid_EmailCase2(loginAndroid.getDriverAndroid());
        unregister_emailCase = new Unregister_EmailCase(loginAndroid.getDriverAndroid());
        inactive_credentialCase = new Inactive_CredentialCase(loginAndroid.getDriverAndroid());
        invalid_credentialCase = new Invalid_CredentialCase(loginAndroid.getDriverAndroid());
        invalid_passwordCase = new Invalid_PasswordCase(loginAndroid.getDriverAndroid());
        blank_passwordCase = new Blank_PasswordCase(loginAndroid.getDriverAndroid());
        valid_loginCase = new Valid_LoginCase(loginAndroid.getDriverAndroid());
        home_pageCase = new Home_PageCase(loginAndroid.getDriverAndroid());
        browser_backCase = new Browser_BackCase(loginAndroid.getDriverAndroid());
        log_outCase = new Log_OutCase(loginAndroid.getDriverAndroid());
        verify_logoutCase = new Verify_LogoutCase(loginAndroid.getDriverAndroid());
        browser_back_logoutCase = new Browser_Back_LogoutCase(loginAndroid.getDriverAndroid());
        forgot_passwordCase1 = new Forgot_PasswordCase1(loginAndroid.getDriverAndroid());
        forgot_passwordCase2 = new Forgot_PasswordCase2(loginAndroid.getDriverAndroid());
        wifi_offCase = new Wifi_OffCase(loginAndroid.getDriverAndroid());
        confirm_registrationCase = new Confirm_RegistrationCase(loginAndroid.getDriverAndroid());








    }



    @AfterTest
    void endTest() {
        loginAndroid.quitTest();
    }


    @AfterSuite
    void flushReport(){
        extent.flush();
    }


}