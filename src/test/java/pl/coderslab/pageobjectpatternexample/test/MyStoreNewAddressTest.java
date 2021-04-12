package pl.coderslab.pageobjectpatternexample.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pageobjectpatternexample.pageobject.MyStoreNewAddress;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MyStoreNewAddressTest {
    private WebDriver driver;
    private MyStoreNewAddress myStoreNewAddress;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
        this.myStoreNewAddress = new MyStoreNewAddress(this.driver);
    }

    @Test
    public void shouldAddNewAddress() {
        this.myStoreNewAddress.fillForm("Martyna", "Mania", "Nowa 15", "60000", "Poznań");
        assertEquals("Address successfully added!", this.myStoreNewAddress.getSuccessMessage());
    }
}
