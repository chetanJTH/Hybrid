package PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class loginFactory {

    public loginFactory(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/login_button")
    public WebElement LoginButton;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_register")
    public WebElement RegisterButton;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/email_edit_text")
    public WebElement EmailAddress;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/password_edit_text")
    public WebElement Password;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/my_homes_tv")
    public WebElement HomePage;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/log_out_button")
    public WebElement Logout;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/confirm_button")
    public WebElement Confirm;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/decline_button")
    public WebElement Decline;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/forgot_pass_text_view")
    public WebElement ForgotPassword;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_restore")
    public WebElement SendEmail;

    @AndroidFindBy(xpath = "//*[@content-desc='Show password']")
    public WebElement ShowPassword;

    @AndroidFindBy(xpath = "//*[@text='Original (1080 × 1350)']")
    public WebElement Original;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/dont_have_acc_text_view")
    public WebElement Account;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/textView4")
    public WebElement CreateAccount;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/first_name_edit_text")
    public WebElement FirstName;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/last_name_edit_text")
    public WebElement LastName;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/confirm_pass_edit_text")
    public WebElement ConfirmPassword;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/register_button")
    public WebElement ConfirmRegistration;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/waiting_email_button")
    public WebElement EmailWait;

    @AndroidFindBy(id = "android:id/autofill_save_title")
    public WebElement AutoSave;

}
