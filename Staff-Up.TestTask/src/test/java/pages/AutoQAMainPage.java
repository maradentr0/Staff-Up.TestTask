package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutoQAMainPage {
    WebDriver driver;
    By username = By.xpath("//*[@id=\"header\"]/div[2]/ul/li/a/div/div[2]/span[1]");
    By products = By.xpath("//*[@id=\"aside\"]/div/div/nav/ul/li[1]/a/i");

    public AutoQAMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return driver.findElement(username).getText();
    }

    public void clickProducts() {
        driver.findElement(products).click();
    }
}
