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
    String searchKeyword = "smartphone";
    String minPriceStr = "20000";
    String maxPriceStr = "85000";

    @Description("This test attempts to Search with keyword and combining filters such as price and brand")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void searchWithFilters() {
        homePage = new HomePage(webDriver);
        searchPage = new SearchPage(webDriver);
        homePage.clickDismissPopupButton();
        homePage.clickAcceptCookiesBtn();
        homePage.sendSearchText(searchKeyword);
        homePage.clickSearch();
        searchPage.clickBrandFilter();
        searchPage.selectAppleBrandFilter().click();
        searchPage.clickSaveFilterButton();
        searchPage.sendMinPrice(minPriceStr);
        searchPage.sendMaxPrice(maxPriceStr);
        searchPage.clickApplyPriceFilterButton();


    }

    @Description("This test attempts to Validating on Search keyword and combining filters Results as selected")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void validateOnSearchResults() {

        for (WebElement item : searchPage.getProductsResultList()) {
            WebElement nameElement = item.findElement(searchPage.getNameProductsList());
            String productName = nameElement.getText();

            WebElement priceElement = item.findElement(searchPage.getPriceProductsList());
            String priceText = priceElement.getText();
            String priceWithoutCurrency = priceText.replace("EGP ", "");
            double productPrice = Double.parseDouble(priceWithoutCurrency.replace(",", ""));
            int minPrice = Integer.parseInt(minPriceStr);
            int maxPrice = Integer.parseInt(maxPriceStr);
            System.out.println(productName);

            System.out.println(searchPage.selectAppleBrandFilter().getText()); //print all products name
            // Assert that the product brand matches the filter
            Assert.assertTrue(productName.contains(searchPage.selectAppleBrandFilter().getText()));

            System.out.println(productPrice); //print all products price
            // Assert that the product price is within the range
            Assert.assertTrue(productPrice >= minPrice && productPrice <= maxPrice);

        }
    }

}
