package appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.Log;

import java.io.File;




public class AppiumServer {

    private static AppiumDriverLocalService appiumService;
    private static AppiumServiceBuilder builder;


    public static AppiumDriverLocalService startServer() {


     //       String Appium_Node_Path="C:/Users/HP/AppData/Roaming/npm/appium.cmd";
          // String appiumJSPath = "C:Users/HP/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
           String appiumJSPath = "/Users/HP/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
//             String appiumJSPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";

        builder = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumJSPath))
       //         .usingDriverExecutable(new File(Appium_Node_Path))
                .withIPAddress("0.0.0.0")
                .usingAnyFreePort()
        //        .withLogFile(new File("src/test/java/extentreports/appium.txt"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        appiumService = builder.build();
        appiumService.start();

        Log.println("[Appium] started on " + appiumService.getUrl());

        return appiumService;
    }

    public static void stopServer() {

        if (appiumService != null) {
            appiumService.stop();
            appiumService = null;
            Log.println("[Appium] stopped");
        }
    }

}
