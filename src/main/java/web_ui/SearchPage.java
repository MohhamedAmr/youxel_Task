package web_ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.wait.ExplicitDriverWait;

import java.util.List;

public class SearchPage extends WebPageBase {
    private final By brandFilter = By.xpath("//label[text()='Brand']");
    private final By priceFilter = By.xpath("//label[text()='Price']");
    private final By priceMinFilter = By.xpath("//input[@class='pi' and @name='min']");
    private final By priceMaxFilter = By.xpath("//input[@class='pi' and @name='max']");
    private final By saveButton = By.xpath("//button[text()='Save']");
    private final By applyPriceFilterButton = By.xpath("//button[text()='Apply']");
    private final By productsResultList = By.xpath("//div[@class='info']");
    private final By productsResultNameList = By.cssSelector("h3.name");
    private final By productsResultPriceList = By.cssSelector("div.prc");

    private final By brandFilterResults = By.xpath("//label[@class='lbl' and text()='Apple']");


    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement selectAppleBrandFilter() {
        //WebElement fifthCheckbox = checkboxes.get(5);
       return webDriver.findElement(brandFilterResults);
    }

    public void clickBrandFilter() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, brandFilter);
        webDriver.findElement(brandFilter).click();
    }

    public void clickPriceFilter() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, priceFilter);
        webDriver.findElement(priceFilter).click();
    }

    public void clickSaveFilterButton() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, saveButton);
        webDriver.findElement(saveButton).click();
    }

    public void sendMinPrice(String minPrice) {
        WebElement minPriceElement = webDriver.findElement(priceMinFilter);
        //clear the existing inputs
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].value = '';", minPriceElement);
        minPriceElement.sendKeys(minPrice);

    }

    public void sendMaxPrice(String maxPrice) {
        WebElement maxPriceElement = webDriver.findElement(priceMaxFilter);
        //clear the existing inputs
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].value = '';", maxPriceElement);
        maxPriceElement.sendKeys(maxPrice);
    }

    public void clickApplyPriceFilterButton() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, applyPriceFilterButton);
        webDriver.findElement(applyPriceFilterButton).click();
    }
    public List<WebElement> getProductsResultList() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, productsResultList);
        return webDriver.findElements(productsResultList);

    }
    public By getNameProductsList(){
        return productsResultNameList;
    }
    public By getPriceProductsList(){
        return productsResultPriceList;
    }
}
