package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutoQAProductsPage {
    WebDriver driver;
    By createProduct = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div/a");
    By activeCondition = By.xpath("//*[@id=\"content\"]/div[1]/ul/li[2]");
    By vendorCodeArea = By.xpath("//*[@id=\"w0-filters\"]/td[4]/input");
    By vendorCodeValue = By.xpath("//*[@id=\"w0-container\"]/table/tbody/tr/td[4]");
    By updateProduct = By.xpath("//*[@id=\"w0-container\"]/table/tbody/tr/td[9]/a[1]/i");

    public AutoQAProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateProduct() throws InterruptedException {
        driver.findElement(createProduct).click();
    }

    public String getActiveCondition() {
        return driver.findElement(activeCondition).getText();
    }

    public void setVendorCode(String strVendorCode){
        driver.findElement(vendorCodeArea).sendKeys(strVendorCode);
    }

    public String getVendorCode() {
        return driver.findElement(vendorCodeValue).getText();
    }

    public void clickUpdateProduct() {
        driver.findElement(updateProduct).click();
    }
}
