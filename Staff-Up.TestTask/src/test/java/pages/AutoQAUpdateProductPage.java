package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoQAUpdateProductPage {
    WebDriver driver;
    By activeCondition = By.xpath("//*[@id=\"content\"]/div[1]/ul/li[3]");
    By backToList = By.xpath("//*[@id=\"w0\"]/div[1]/div/div[1]/a[1]");
    By createNewProduct = By.xpath("//*[@id=\"w0\"]/div[1]/div/div[1]/a[2]");

    By productTitle = By.id("producteditform-title");
    By productCategory = By.id("producteditform-category_id");
    By productVendorCode = By.id("producteditform-vendor_code");
    By productShortDescription = By.id("producteditform-short_description");
    By productDescription = By.id("producteditform-description");
    By productQuantityUnits = By.id("producteditform-quantity_units");
    By productPrice = By.id("producteditform-price");
    By productUploadImage = By.id("producteditform-uploaded_images");

    By save = By.xpath("//*[@id=\"w0\"]/div[3]/div/button");
    By products = By.xpath("//*[@id=\"aside\"]/div/div/nav/ul/li[1]/a/i");
    By successUpdatingAlert = By.xpath("//*[@id=\"w1\"]");

    public AutoQAUpdateProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getActiveCondition() {
        return driver.findElement(activeCondition).getText();
    }

    public void clickBackToList() {driver.findElement(backToList).click();}

    public void clickCreateNewProduct() {driver.findElement(createNewProduct).click();}

    public void setProductTitle(String strProductTitle){
        driver.findElement(productTitle).clear();
        driver.findElement(productTitle).sendKeys(strProductTitle);
    }

    public void setProductCategory(String value) throws InterruptedException {
        driver.findElement(productCategory).click();
        Select productCategorySelect = new Select(driver.findElement(productCategory));
        productCategorySelect.selectByValue(value);
    }

    public void setProductVendorCode(String strProductVendorCode){
        driver.findElement(productVendorCode).clear();
        driver.findElement(productVendorCode).sendKeys(strProductVendorCode);
    }

    public void setProductShortDescription(String strProductShortDescription){
        driver.findElement(productShortDescription).clear();
        driver.findElement(productShortDescription).sendKeys(strProductShortDescription);
    }

    public void setProductDescription(String strProductDescription){
        driver.findElement(productDescription).clear();
        driver.findElement(productDescription).sendKeys(strProductDescription);
    }

    public void setProductQuantityUnits(String value) {
        driver.findElement(productQuantityUnits).click();
        Select productQuantityUnitsSelect = new Select(driver.findElement(productQuantityUnits));
        productQuantityUnitsSelect.selectByValue(value);
    }

    public void setProductPrice(String strProductPrice){
        driver.findElement(productPrice).clear();
        driver.findElement(productPrice).sendKeys(strProductPrice);
    }

    public void setProductUploadImage(String strProductUploadImage){
        driver.findElement(productUploadImage).clear();
        driver.findElement(productUploadImage).sendKeys(strProductUploadImage);
    }

    public void clickSave(){
        driver.findElement(save).click();
    }

    public void clickProducts() {driver.findElement(products).click();}

    public String getSuccessUpdatingAlert() {
        return driver.findElement(successUpdatingAlert).getText();
    }

}
