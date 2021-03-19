package actions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;


public class MobileActions {

    private static AndroidDriver driver;
    private static String screenshotPath;
    private TouchAction _touchAction;
    private static boolean isScreenShot_ = false;


    private TouchAction touchAction() {
        if (_touchAction == null) {
            _touchAction = new TouchAction(driver);
        }
        return _touchAction;
    }

    public MobileActions(AndroidDriver driver) {
        this.driver = driver;
    }


    public AndroidElement elementByID(String id) {
        AndroidElement element = null;
        try {
            element = (AndroidElement) driver.findElementById(id);
            System.out.println("element has been initialized");
        } catch (Exception ex) {
            System.out.println("cannot initialize a element");
        } finally {
            return element;
        }
    }

   /* public AndroidElement findElementsByClassName(String id) {
        AndroidElement element = null;
        try {
            element = (AndroidElement) driver.findElementsByClassName(id);
            System.out.println("element has been initialized");
        }catch (Exception ex){
            System.out.println("cannot initialize a element");
        } finally {
            return element;
        }
    }*/

    public AndroidElement elementByXPATH(String xpath) {
        AndroidElement element = null;
        try {
            element = (AndroidElement) driver.findElementByXPath(xpath);
        } catch (Exception ex) {

        } finally {
            return element;
        }
    }

    public void clickElementByID(String id) {
        AndroidElement element = elementByID(id);
        clickOn(element);
    }

    public void clickElementByXPATH(String xpath) {
        AndroidElement element = elementByXPATH(xpath);
        clickOn(element);
    }

    public void clickOn(AndroidElement element) {

        if (element == null) {
            System.out.println("element is null -> return");
            return;
        }
        if (element.isEnabled()) {

            element.click();
            System.out.println("Click to element");
        } else {
            System.out.println("Wait to element enable...");
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.withMessage("Could not load element");
            element.click();
        }
    }

    /**
     * tapON will tap on screen at point of Element, it not care state of Element is Disable or Enable
     *
     * @param element
     */
    public void tapOn(AndroidElement element) {

        try {
            Point point = new Point(element.getCenter().getX(), element.getCenter().getY());
       //     System.out.println("[TAP] at" + point);
            PointOption pointOption = new PointOption().withCoordinates(point);
            touchAction().tap(pointOption).perform();

        } catch (Exception ex) {

        }
    }

    public void tapOn(AndroidElement element, double percent) {

        try {
            int screenWidth = driver.manage().window().getSize().width;
            int getX = (int) (screenWidth * (percent / 100));
            Point point = new Point(getX, element.getCenter().getY());
            System.out.println("[TAP] at" + point);
            PointOption pointOption = new PointOption().withCoordinates(point);
            touchAction().tap(pointOption).perform();

        } catch (Exception ex) {

        }
    }

    public boolean isSelected (AndroidElement element) {
        if (element.isSelected()) {
            Log.addLog("Time range is selected");
            return true;
        }else {
            Log.addLog("Time range is not selected");
            return false;
        }
    }

    public void Status (AndroidElement element) {
       String ExpectText = "ON";
       String ActText = element.getText();
       if (ExpectText.equals(ActText)){
           Assert.assertEquals(ExpectText,ActText);
           Log.addLog("Automation is on");
        }else {
            Log.addLog("Automation is off");
        }
    }



    public boolean colorSeekBarForward(AndroidElement seekBar, int perc) {
        if (seekBar != null) {

            int widthOfSeekBar = seekBar.getSize().getWidth();
            Log.addLog("widthOfSeekBar " + widthOfSeekBar);

            int startX = seekBar.getLocation().getX();
            Log.addLog("startX " + startX);
            int midY = seekBar.getLocation().getY();
            Log.addLog("midY " + midY);
            int endX = startX + seekBar.getSize().getWidth();
            Log.addLog("endX " + endX);
            int moveTo = (int) ((endX * (float) perc / 100));
            Log.addLog("moveTo " + moveTo);


            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(startX, midY)).moveTo(PointOption.point(moveTo, midY)).release().perform();
            //  action.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX,midY))).moveTo(PointOption.point(moveTo,midY)).perform().release();
            return true;
        } else {
            return false;

        }
    }

    public boolean shadowSeekBarForward(AndroidElement seekBar, int perc) {
        if (seekBar != null) {

            int widthOfSeekBar = seekBar.getSize().getWidth();
            Log.addLog("widthOfSeekBar " + widthOfSeekBar);

            int startX = seekBar.getLocation().getX();
            Log.addLog("startX " + startX);
            int midY = seekBar.getLocation().getY();
            Log.addLog("midY " + midY);
            int endX = startX + seekBar.getSize().getWidth();
            Log.addLog("endX " + endX);
            int moveTo = (int) ((endX * (float) perc / 100));
            Log.addLog("moveTo " + moveTo);


            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(startX, midY)).moveTo(PointOption.point(moveTo, midY)).release().perform();
            //  action.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX,midY))).moveTo(PointOption.point(moveTo,midY)).perform().release();
            return true;
        } else {
            return false;

        }
    }

    public boolean shadowSeekBarBack(AndroidElement seekBar, int perc) {
        if (seekBar != null) {
            int widthOfSeekBar = seekBar.getSize().getWidth();
            Log.addLog("widthOfSeekBar " + widthOfSeekBar);

            int startX = seekBar.getLocation().getX();
            Log.addLog("startX " + startX);
            int midY = seekBar.getLocation().getY();

            int endX = startX + seekBar.getSize().getWidth();
            Log.addLog("endX " + endX);
            int moveTo = (int) (endX - (widthOfSeekBar * (float) perc / 100));
            Log.addLog("moveTo " + moveTo);

            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(endX - 5, midY)).moveTo(PointOption.point(moveTo, midY)).release().perform();
            //  action.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX,midY))).moveTo(PointOption.point(moveTo,midY)).perform().release();
            return true;
        } else {
            return false;
        }
    }

    public void viewGroupForward(AndroidElement seekBar, int From, int To) {

        int widthOfSeekBar = seekBar.getSize().getWidth();


        int startX = seekBar.getLocation().getX();
        int startY = seekBar.getLocation().getY();

        int midY = seekBar.getLocation().getY();


        int endX = startX + seekBar.getSize().getWidth();
        int endY = startY + seekBar.getSize().getHeight();

        int moveFrom = (int) (endX * ((float) From / 100));
        int moveTo = (int) (endY * ((float) To / 100));

        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(moveFrom, moveTo)).release().perform();
        //  action.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX,midY))).moveTo(PointOption.point(moveTo,midY)).perform().release();

    }


    public void swipeElementByPercentage(AndroidElement element, Direction direction) {

        double endXPercen = 0.8;
        int startX, startY, endX, endY;

        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        switch (direction) {
            case TOP:
                startX = element.getCenter().getX();
                startY = element.getSize().getHeight();

                endX = startX;
                endY = screenHeight - (int) (screenHeight * endXPercen);
                break;
            case RIGHT:
                startX = element.getCenter().getX();
                startY = element.getCenter().getY();

                endX = (int) (screenWidth * endXPercen);
                endY = startY;
                break;
            case LEFT:
                startX = element.getSize().getWidth();
                startY = element.getCenter().getY();

                endX = screenWidth - (int) (screenWidth * endXPercen);
                endY = startY;
                break;

            default:
                startX = element.getCenter().getX();
                startY = element.getLocation().getY();

                endX = startX;
                endY = (int) (screenHeight * endXPercen);
                break;
        }

        Point startPoint = new Point(startX, startY);
        PointOption startPointOption = new PointOption().withCoordinates(startPoint);

        Point endPoint = new Point(endX, endY);
        PointOption endPointOption = new PointOption().withCoordinates(endPoint);

        WaitOptions waitOptions = new WaitOptions().withDuration(Duration.ofMillis(200));

        System.out.println("Start Point: " + startPoint + " and End point: " + endPoint);
        touchAction().tap(startPointOption).moveTo(endPointOption).waitAction().release().perform();

    }


    public void scrollAndClickElement(AndroidElement parent, String text) {


        while (!isDisplayed(text)) {
            swipeElementByPercentage(parent, Direction.LEFT);
        }

        driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"" + text + "\"]").click();
    }


    private boolean isDisplayed(String text) {
        try {
            AndroidElement element = (AndroidElement) driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"" + text + "\"]");
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    /**
     * @param element
     * @param direction
     * @param endXPercen Default is 0.9
     */
    public void swipeElementByPercentage(AndroidElement element, Direction direction, double endXPercen) {

        int startX, startY, endX, endY;

        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        switch (direction) {
            case TOP:
                startX = element.getCenter().getX();
                startY = element.getSize().getHeight();

                endX = startX;
                endY = screenHeight - (int) (screenHeight * endXPercen);
                break;
            case RIGHT:
                startX = element.getLocation().getX();
                startY = element.getLocation().getY();

                endX = (int) (screenWidth * endXPercen);
                endY = startY;
                break;
            case LEFT:
                startX = element.getSize().getWidth();
                startY = element.getCenter().getY();

                endX = screenWidth - (int) (screenWidth * endXPercen);
                endY = startY;
                break;

            default:
                startX = element.getCenter().getX();
                startY = element.getLocation().getY();

                endX = startX;
                endY = (int) (screenHeight * endXPercen);
                break;
        }

        Point startPoint = new Point(startX, startY);
        PointOption startPointOption = new PointOption().withCoordinates(startPoint);

        Point endPoint = new Point(endX, endY);
        PointOption endPointOption = new PointOption().withCoordinates(endPoint);

        WaitOptions waitOptions = new WaitOptions().withDuration(Duration.ofMillis(200));

        touchAction().press(startPointOption).waitAction(waitOptions).moveTo(endPointOption).waitAction().release().perform();

    }

    /**
     * @param fromPoint: input x and y
     * @param toPoint
     */
    public void swipeOnScreen(Point fromPoint, Point toPoint) {

        WaitOptions waitOptions = new WaitOptions().withDuration(Duration.ofMillis(3000));

        touchAction().press(new PointOption().withCoordinates(fromPoint)).waitAction(waitOptions).moveTo(new PointOption().withCoordinates(toPoint)).release().perform();
    }

    private static int CURRENT_PAGE = 0;
    private static final int MAX_PAGE = 10;

    public AndroidElement scrollTo(String id) {

        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        Point startPoint = new Point(screenWidth / 2, screenHeight);
        Point endPoint = new Point(screenWidth / 2, 0);

        while (isFoundElement(id) && CURRENT_PAGE < MAX_PAGE) {
            CURRENT_PAGE++;
            swipeOnScreen(startPoint, endPoint);
        }

        return (AndroidElement) driver.findElementById(id);
    }

    private boolean isFoundElement(String id) {

        try {

            AndroidElement element = (AndroidElement) driver.findElementsByClassName(id);
            if (element == null) {
                return false;
            }

            return element.isEnabled();

        } catch (Exception ex) {
            return false;
        }
    }
    //screen capture

    /**
     * @param
     * @return: AbsolutePath of Image. (Image will be saved at folder "Report/.../Images")
     */
//    public static String takeScreenshot(String imageName) {
//        String pathName = Utils.createDir(Utils.getReportDir() + "/Images"); //create folder
//
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // take a screenshot
//
//        File image = new File(pathName, imageName + ".png");
//        try {
//            FileUtils.copyFile(scrFile, image);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return image.getAbsolutePath();
//    }


    public static void setScreenShot(boolean isScreenShot){

        if(isScreenShot){
            isScreenShot_ = true;
        }else {
            isScreenShot_= false;
        }

    }

    public static boolean isScreenShot(){
        return isScreenShot_;
    }

    public static String Screenshot(String imageName)  {

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String pathName = Utils.createDir(Utils.getReportDir() + "/Images");
            File Dest = new File(pathName, System.currentTimeMillis() + ".png");
            FileUtils.copyFile(scrFile, Dest);
            String[] relativePath = Dest.toString().split("reports");
            screenshotPath = "../" + relativePath[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }

    public boolean swipeSeekbarForward(AndroidElement seekBar, int perc) {

        if (seekBar != null) {
            int widthOfSeekBar = seekBar.getSize().getWidth();
       //     Log.addLog("widthOfSeekBar " + widthOfSeekBar);

            int startX = seekBar.getLocation().getX();
       //     Log.addLog("startX " + startX);
            int midY = seekBar.getLocation().getY();
       //     Log.addLog("midY " + midY);
            int endX = startX + seekBar.getSize().getWidth();
       //     Log.addLog("endX " + endX);
            int moveTo = (int) ((endX * (float) perc / 100));
       //     Log.addLog("moveTo " + moveTo);
            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(startX, midY)).moveTo(PointOption.point(moveTo, midY)).release().perform();
            //  action.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX,midY))).moveTo(PointOption.point(moveTo,midY)).perform().release();
            return true;
        } else {
            return false;
        }
    }

    public boolean swipeSeekbarBack(AndroidElement seekBar, int perc) {

        if (seekBar != null) {
            int widthOfSeekBar = seekBar.getSize().getWidth();
       //     Log.addLog("widthOfSeekBar " + widthOfSeekBar);

            int startX = seekBar.getLocation().getX();
       //     Log.addLog("startX " + startX);
            int midY = seekBar.getLocation().getY();

            int endX = startX + seekBar.getSize().getWidth();
        //    Log.addLog("endX " + endX);
            int moveTo = (int) (endX - (widthOfSeekBar * (float) perc / 100));
       //     Log.addLog("moveTo " + moveTo);

            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(endX - 5, midY)).moveTo(PointOption.point(moveTo, midY)).release().perform();
            //  action.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX,midY))).moveTo(PointOption.point(moveTo,midY)).perform().release();
            return true;
        } else {
            return false;
        }
    }

    public static void captureLog(String testName)
            throws Exception {
        DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String logPath = Utils.createDir((Utils.getReportDir() + "adbLogs"));
        Log.addLog(driver.getSessionId() + ": Saving device log...");
        List<LogEntry> logEntries = driver.manage().logs().get("logcat").filter(Level.ALL);
        File logFile = new File(logPath, testName + ".txt");
        PrintWriter log_file_writer = new PrintWriter(logFile);
        log_file_writer.println(logEntries );
        log_file_writer.flush();
        Log.addLog(driver.getSessionId() + ": Saving device log - Done.");
    }

//    public boolean roundSeekbar(AndroidElement element, int degree) {
//        if (element != null) {
//            int centerofx = element.getCenter().getX();
//            Log.addLog("center x " + centerofx);
//            int startY = element.getLocation().getY();
//            Log.addLog("center y " + startY);
//        }
//
//
//    }




}
