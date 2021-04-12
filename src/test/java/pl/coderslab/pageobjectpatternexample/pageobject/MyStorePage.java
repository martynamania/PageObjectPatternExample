package pl.coderslab.pageobjectpatternexample.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyStorePage {
    private WebDriver driver;

    @FindBy(name = "s")
    private WebElement inputSearchCatalog;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchCatalog(String searchQuery) {
        this.inputSearchCatalog.click();
        this.inputSearchCatalog.clear();
        this.inputSearchCatalog.sendKeys(searchQuery);
        this.inputSearchCatalog.submit();
    }

    public List<String> getDisplayedProductsNames() {
        List<WebElement> elems = this.driver.findElements(By.cssSelector("div.product-description a"));

        List<String> result = new ArrayList<>();

        for(WebElement we : elems){
            result.add(we.getText());
        }

        return result;

//        return elems.stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
    }
}
