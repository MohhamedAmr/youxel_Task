package test_base;

import com.beust.jcommander.Parameter;
import constants.SiteConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import web_ui.HomePage;

import java.time.Duration;

public class WebTestBase {
    public static WebDriver webDriver;

    @BeforeTest
    @Parameter(names = "browserName")
    public void startDriver(@Optional("chrome") String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }

        webDriver.manage().window().maximize();
        webDriver.navigate().to(SiteConstants.baseUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        new HomePage(webDriver).dismissInitialPopups();
    }

    @AfterSuite
    public void endDriver() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();

    }
}





