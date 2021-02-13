package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoQACreateProductPage {
    WebDriver driver;
    By activeCondition = By.xpath("//*[@id=\"content\"]/div[1]/ul/li[3]");
    By backToList = By.xpath("//*[@id=\"w0\"]/div[1]/div/div[1]/a");

    By productTitle = By.id("productcreateform-title");
    By productCategory = By.id("productcreateform-category_id");
    By productVendorCode = By.id("productcreateform-vendor_code");
    By productShortDescription = By.id("productcreateform-short_description");
    By productDescription = By.id("productcreateform-description");
    By productQuantityUnits = By.id("productcreateform-quantity_units");
    By productPrice = By.id("productcreateform-price");
    By productUploadImage = By.id("productcreateform-uploaded_images");

    By save = By.xpath("//*[@id=\"w0\"]/div[3]/div/button");
    By products = By.xpath("//*[@id=\"aside\"]/div/div/nav/ul/li[1]/a/i");

    public AutoQACreateProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getActiveCondition() {
        return driver.findElement(activeCondition).getText();
    }

    public void clickBackToList() {driver.findElement(backToList).click();}

    public void setProductTitle(String strProductTitle){
        driver.findElement(productTitle).sendKeys(strProductTitle);
    }

    public void setProductCategory(String value) throws InterruptedException {
        driver.findElement(productCategory).click();
        Select productCategorySelect = new Select(driver.findElement(productCategory));
        productCategorySelect.selectByValue(value);
    }

    public void setProductVendorCode(String strProductVendorCode){
        driver.findElement(productVendorCode).sendKeys(strProductVendorCode);
    }

    public void setProductShortDescription(String strProductShortDescription){
        driver.findElement(productShortDescription).sendKeys(strProductShortDescription);
    }

    public void setProductDescription(String strProductDescription){
        driver.findElement(productDescription).sendKeys(strProductDescription);
    }

    public void setProductQuantityUnits(String value) {
        driver.findElement(productQuantityUnits).click();
        Select productQuantityUnitsSelect = new Select(driver.findElement(productQuantityUnits));
        productQuantityUnitsSelect.selectByValue(value);
    }

    public void setProductPrice(String strProductPrice){
        driver.findElement(productPrice).sendKeys(strProductPrice);
    }

    public void setProductUploadImage(String strProductUploadImage){
        driver.findElement(productUploadImage).sendKeys(strProductUploadImage);
    }

    public void clickSave(){
        driver.findElement(save).click();
    }

    public void clickProducts() {driver.findElement(products).click();}

    public void createProductToAutoQA (String strProductTitle, String strProductCategory, String strProductVendorCode,
                                       String strProductShortDescription, String strProductDescription,
                                       String strProductQuantityUnits, String strProductPrice, String strProductUploadImage) throws InterruptedException {
        this.setProductTitle(strProductTitle);
        this.setProductCategory(strProductCategory);
        this.setProductVendorCode(strProductVendorCode);
        this.setProductShortDescription(strProductShortDescription);
        this.setProductDescription(strProductDescription);
        this.setProductQuantityUnits(strProductQuantityUnits);
        this.setProductPrice(strProductPrice);
        this.setProductUploadImage(strProductUploadImage);
        this.clickSave();
    }
}
