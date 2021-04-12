package pl.coderslab.pageobjectpatternexample.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pageobjectpatternexample.pageobject.MyStorePage;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class SearchProductsSteps {
    private WebDriver driver;
    private MyStorePage myStorePage;

    @Given("^Landing page displayed$")
    public void ddd() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://prod-kurs.coderslab.pl/index.php");
        this.myStorePage = new MyStorePage(driver);
    }

    @When("^Search catalog for (.*)$")
    public void searchCatalogFor(String searchQuery) {
        this.myStorePage.searchCatalog(searchQuery);
    }

    @Then("^At least one product found$")
    public void atLeastOneProductFound() {
        List<String> displayedProductsNames = this.myStorePage.getDisplayedProductsNames();
        assertNotEquals(0, displayedProductsNames.size());
    }
}
