package web_ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebPageBase {
    public static WebDriver webDriver;

    public WebPageBase(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        WebPageBase.webDriver = webDriver;
    }

}
