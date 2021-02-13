package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutoQALoginPage {
    WebDriver driver;
    By email = By.id("loginform-email");
    By password = By.id("loginform-password");
    By login = By.xpath("//*[@id=\"w0\"]/button");

    public AutoQALoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail (String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }

    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickLogin(){
        driver.findElement(login).click();
    }

    public void loginToAutoQA (String strUserName, String strPassword) {
        this.setEmail(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();
    }
}
