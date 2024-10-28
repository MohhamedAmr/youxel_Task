package test_runner;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.WebTestBase;
import web_ui.HomePage;

public class SuggestionSearchTest extends WebTestBase {
    HomePage homePage;

    String searchKeyword = "smart";

    public void assertOnSuggestionsTextList() {
        for (WebElement result : homePage.getSuggestionList()) {
            String resultText = result.getText().toLowerCase();
            System.out.println("Validating result text: " + resultText);
            Assert.assertTrue(result.isDisplayed(), "The results not displayed: " + result);
            Assert.assertTrue(resultText.contains(searchKeyword),
                    "The result text does not contain the keyword: " + searchKeyword);
        }
    }

    @Description("This test attempts to validate on as_you_type_suggestion Texts")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void verifyAsYouTypeSuggestionFunc() {
        homePage = new HomePage(webDriver);
        homePage.sendSearchText(searchKeyword);
        assertOnSuggestionsTextList();
        homePage.clickDismissSearchBarButton();


    }
}
