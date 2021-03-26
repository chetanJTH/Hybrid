package Case_ParentalControl;

import Test_ParentalControl.Check_PieChart;
import io.appium.java_client.android.AndroidDriver;

public class Check_PieChartCase {
    public Check_PieChartCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void CheckPieChartTestCase() {

        Check_PieChart P = new Check_PieChart(driver);

        try {
            P.CheckPieChartTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
