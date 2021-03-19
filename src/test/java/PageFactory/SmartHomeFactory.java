package PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SmartHomeFactory {
    public SmartHomeFactory(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/add_toolbar_icon")
    public WebElement AddTool;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/energy_management_container")
    public WebElement EnergyManagement;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/router_container")
    public WebElement Router;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/parental_control_container")
    public WebElement ParentalControl;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/cyber_security_container")
    public WebElement Security;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/settings_container")
    public WebElement Settings;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/smart_home_container")
    public WebElement SmartHome;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/home")
    public WebElement HomeButton;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/scenes")
    public WebElement SceneButton;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/macros")
    public WebElement MacrosButton;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/schedules")
    public WebElement SchedulesButton;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/devices")
    public WebElement DevicesButton;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/scan_qr_button")
    public WebElement QRcode;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/gateway_edit_icon")
    public WebElement EditGateway;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/gateway_name_edit_text")
    public WebElement EditGatewayName;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/save_changes_button")
    public WebElement SaveChanges;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/autologin_check_box")
    public WebElement AutoLogin;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/gateway_name_text_view")
    public WebElement GatewayName;


}
