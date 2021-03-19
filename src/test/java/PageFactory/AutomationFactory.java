package PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AutomationFactory {
    public AutomationFactory(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/macros")
    public WebElement Automation;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/title")
    public WebElement NewAutomation;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/macro_title_edit_text")
    public WebElement AutomationTitle;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_save_macro")
    public WebElement SaveAutomation;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_add_trigger")
    public WebElement AddTriggerDevice;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_add_device")
    public WebElement AddtoAutomation;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_add_perform")
    public WebElement AddPerformDevice;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/comparison_container")
    public WebElement ComparisonButton;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/comparison_value_text_view")
    public WebElement ComparisonTextButton;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/less_or_equal_sign")
    public WebElement LessorEqual;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/less_sign")
    public WebElement Less;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/not_equal_sign")
    public WebElement NotEqual;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/equals_sign")
    public WebElement Equal;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/greater_sign")
    public WebElement Greater;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/greater_or_equal_sign")
    public WebElement GreaterEqual;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/value_tracker_container")
    public WebElement ValueContainer;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/touch_outside")
    public WebElement TouchOut;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_add_actions_to_automators")
    public WebElement AddAction;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/start_time_container")
    public WebElement StartTime;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/time_range_cb")
    public WebElement CheckBox;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/end_time_container")
    public WebElement EndTime;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/start_time_tv")
    public WebElement StartTimeText;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/end_time_tv")
    public WebElement EndTimeText;
}
