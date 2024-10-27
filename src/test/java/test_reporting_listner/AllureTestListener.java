package test_reporting_listner;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import web_ui.WebPageBase;

import java.io.ByteArrayInputStream;

public class AllureTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        if (WebPageBase.webDriver != null) {
            byte[] screenshot = ((TakesScreenshot) WebPageBase.webDriver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot on Success", "image/png", new ByteArrayInputStream(screenshot), "png");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (WebPageBase.webDriver != null) {
            byte[] screenshot = ((TakesScreenshot) WebPageBase.webDriver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot on Success", "image/png", new ByteArrayInputStream(screenshot), "png");

        }
    }
}



