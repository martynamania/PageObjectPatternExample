package pl.coderslab.pageobjectpatternexample.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyStoreNewAddress {
    private WebDriver driver;

    @FindBy(name = "firstname")
    private WebElement inputName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "address1")
    private WebElement address;

    @FindBy(name = "postcode")
    private WebElement postcode;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "id_country")
    private WebElement country;

    @FindBy(css=  ".address-form form button[type=submit]")
    private WebElement saveButton;

    public MyStoreNewAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String firstName, String lastName, String address, String postcode, String city) {
        this.inputName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.postcode.sendKeys(postcode);
        this.city.sendKeys(city);
        List<WebElement> ExpectationOptions = this.country.findElements(By.tagName("option"));
        for (int i = 0; i < ExpectationOptions.size(); i++) {
            if (ExpectationOptions.get(i).getAttribute("value").equals("17")) {
                ExpectationOptions.get(i).click();
            }
        }

        saveButton.click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.cssSelector("article[data-alert=success]")).getText();
    }

}