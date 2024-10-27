package web_ui;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.wait.ExplicitDriverWait;

import java.util.List;

public class HomePage extends WebPageBase {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By dismissPopupButton = By.className("cls");
    private final By searchBar = By.id("fi-q");

    private final By dismissSearchBarButton = By.className("rst");

    private final By searchButton = By.xpath("//button[text()='Search']");
    private final By searchBarSuggestions = By.cssSelector("section.sec a.itm");

    private final By acceptCookiesBtn = By.xpath("//button[text()='Accept cookies']");


    public void clickSearch() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, searchBar);
        webDriver.findElement(searchButton).click();
    }

    public void sendSearchText(String keyWord) {
        webDriver.findElement(searchBar).sendKeys(keyWord);
    }

    public List<WebElement> getSuggestionList() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, searchBarSuggestions);
        return webDriver.findElements(searchBarSuggestions);

    }


    public void clickDismissPopupButton() {
        try {
            new ExplicitDriverWait(webDriver).waitUntilElementAppear(2, dismissPopupButton);
            if (webDriver.findElement(dismissPopupButton).isDisplayed()) {
                webDriver.findElement(dismissPopupButton).click();
            }
        } catch (TimeoutException e) {
            System.out.println("Popup Didn't appear");

        }
    }

    public void clickAcceptCookiesBtn() {
        try {
            new ExplicitDriverWait(webDriver).waitUntilElementAppear(1, acceptCookiesBtn);
            if (webDriver.findElement(acceptCookiesBtn).isDisplayed()) {
                webDriver.findElement(acceptCookiesBtn).click();
            }
        } catch (TimeoutException e) {
            System.out.println("Accept Cookies Button didn't appear");

        }
    }
    public void clickDismissSearchBarButton() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, dismissSearchBarButton);
        webDriver.findElement(dismissSearchBarButton).click();
    }

}
