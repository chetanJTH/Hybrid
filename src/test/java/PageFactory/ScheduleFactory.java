package PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ScheduleFactory {

    public ScheduleFactory(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/title")
    public WebElement NewSchedule;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_edit_save_schedule")
    public WebElement SaveSchedule;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/schedule_title_edt")
    public WebElement ScheduleTitle;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/schedule_type_everyday_btn")
    public WebElement TypeEveryday;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/schedule_type_weekdays_btn")
    public WebElement TypeWeekdays;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/schedule_type_weekends_btn")
    public WebElement TypeWeekends;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/schedule_type_custom_btn")
    public WebElement TypeCustom;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/custom_sunday_btn")
    public WebElement Sunday;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/custom_monday_btn")
    public WebElement Monday;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/custom_tuesday_btn")
    public WebElement Tuesday;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/custom_wednesday_btn")
    public WebElement Wednesday;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/custom_thursday_btn")
    public WebElement Thursday;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/custom_friday_btn")
    public WebElement Friday;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/custom_saturday_btn")
    public WebElement Saturday;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_add_perform_scenes_or_devices")
    public WebElement AddDevice;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/check_delay_container")
    public WebElement DelayContainer;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/button_add_actions_to_automators")
    public WebElement AddSchedule;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/dragAndDropHandleIv")
    public WebElement DragandDrop;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/delay_value_tracker_container")
    public WebElement TrackerContainer;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/touch_outside")
    public WebElement TouchOut;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/schedule_time_tv")
    public WebElement SetTime;

    @AndroidFindBy(id = "android:id/toggle_mode")
    public WebElement ToggleMode;

    @AndroidFindBy(id = "android:id/input_hour")
    public WebElement Hour;

    @AndroidFindBy(id = "android:id/input_minute")
    public WebElement Minute;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/check_scene_container")
    public WebElement Scene;

    @AndroidFindBy(xpath = "//*[@text='Edit schedule']")
    public WebElement BottomEdit;

    @AndroidFindBy(xpath = "//*[@text='Delete schedule']")
    public WebElement BottomDelete;

    @AndroidFindBy(xpath = "//*[@text='Test1']")
    public WebElement Test1Button;

}
