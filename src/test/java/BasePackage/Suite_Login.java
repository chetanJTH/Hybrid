package BasePackage;

import org.testng.annotations.Test;

public class Suite_Login extends BaseTest {

    @Test(priority = 1)
    void Welcome_Page() { welcome_pageCase.LoginPageTestCase(); }

    @Test(priority = 2)
    void Login_Page() { login_pageCase.LoginPageTestCase(); }

    @Test(priority = 3)
    void Login_Field() { login_fieldCase.LoginFieldTestCase(); }

    @Test(priority = 4)
    void Blank_Field() { blank_filedCase.BothBlankFiledTestCase(); }

//    @Test(priority = 5)
//    void Blank_Email() { blank_emailCase.BlankEmailTestCase(); }
//
//    @Test(priority = 6)
//    void Invalid_Email_01() { invalid_emailCase1.InvalidEmailTestCase1(); }
//
//    @Test(priority = 7)
//    void Invalid_Email_02() { invalid_emailCase2.InvalidEmailTestCase2(); }
//
//    @Test(priority = 8)
//    void Unregistration_Email() { unregister_emailCase.UnregEmailTestCase(); }
//
//    @Test(priority = 9)
//    void Inactive_Email() { inactive_credentialCase.InactiveCredTestCase(); }
//
//    @Test(priority = 10)
//    void Invalid_Credential() { invalid_credentialCase.InvalidCredTestCase(); }
//
//    @Test(priority = 11)
//    void Invalid_Password() { invalid_passwordCase.InvalidPasswordTestCase(); }
//
//    @Test(priority = 12)
//    void Blank_Password() { blank_passwordCase.BlankPasswordTestCase(); }
//
//    @Test(priority = 13)
//    void Valid_Login() { valid_loginCase.ValidLoginTestCase(); }
//
//    @Test(priority = 14)
//    void Home_Page() { home_pageCase.HomePageTestCase(); }
//
//    @Test(priority = 15)
//    void Browser_Back() { browser_backCase.BrowserBackTestCase(); }
//
//    @Test(priority = 16)
//    void Log_Out() { log_outCase.LogOutTestCase(); }
//
//    @Test(priority = 17)
//    void Verify_Logout() { verify_logoutCase.VerifyLogoutTestCase(); }
//
//    @Test(priority = 18)
//    void Browser_Back_Logout() { browser_back_logoutCase.BrowserBackLogoutTestCase(); }
//
//    @Test(priority = 19)
//    void Forgot_Password_01() { forgot_passwordCase1.ForgotPasswordTestCase(); }
//
//    @Test(priority = 20)
//    void Forgot_Password_02() { forgot_passwordCase2.ForgotPasswordTestCase(); }
//
//    @Test(priority = 21, enabled = false)
//    void WifiOff() { wifi_offCase.WifiOffTestCase(); }
//
//    @Test(priority = 22, enabled = false)
//    void ConfirmRegistration() { confirm_registrationCase.ConfirmRegistrationTestCase(); }







}
