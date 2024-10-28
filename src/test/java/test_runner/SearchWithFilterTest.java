package test_runner;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.WebTestBase;
import web_ui.HomePage;
import web_ui.SearchPage;

public class SearchWithFilterTest extends WebTestBase {
    HomePage homePage;
    SearchPage searchPage;

    WebElement nameElement;

    String productName;
    String searchKeyword = "smartphone";
    int minPrice = 20000;
    int maxPrice = 85000;


    @Description("This test attempts to Search with keyword and filter 'brand' ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void searchWithFilters() {
        searchPage = new SearchPage(webDriver);
        homePage = new HomePage(webDriver);
        homePage.sendSearchText(searchKeyword);
        homePage.clickSearch();
        searchPage.clickBrandFilter();
        searchPage.selectAppleBrandFilter().click();
        searchPage.clickSaveFilterButton();
        for (WebElement item : searchPage.getProductsResultList()) {
            nameElement = item.findElement(searchPage.getNameProductsList());
            productName = nameElement.getText();
            //Assert That All Elements Name Appears and Matches Selected Brand's Filter
            Assert.assertTrue(nameElement.isDisplayed());
            Assert.assertTrue(productName.contains(searchPage.selectAppleBrandFilter().getAttribute("innerText")));
        }


    }

    @Description("This test attempts to Validating on combining filters Results as selected")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void combiningFiltersResult() {

        searchPage.sendMinPrice(String.valueOf(minPrice));
        searchPage.sendMaxPrice(String.valueOf(maxPrice));
        searchPage.clickApplyPriceFilterButton();
        for (WebElement item : searchPage.getProductsResultList()) {
            nameElement = item.findElement(searchPage.getNameProductsList());
            productName = nameElement.getText();

            WebElement priceElement = item.findElement(searchPage.getPriceProductsList());
            String priceText = priceElement.getText();
            String priceWithoutCurrency = priceText.replace("EGP ", "");
            double productPrice = Double.parseDouble(priceWithoutCurrency.replace(",", ""));

            //print all products name
            System.out.println(productName);
            //Assert that all Products name's is displayed
            Assert.assertTrue(nameElement.isDisplayed());
            // Assert that the product brand matches the filter
            Assert.assertTrue(productName.contains(searchPage.selectAppleBrandFilter().getAttribute("innerText")));

            //print all products price
            System.out.println(productPrice);
            //Assert that all Product's price is displayed
            Assert.assertTrue(priceElement.isDisplayed());
            // Assert that the product price is within the range
            Assert.assertTrue(productPrice >= minPrice && productPrice <= maxPrice);

        }
    }

}
