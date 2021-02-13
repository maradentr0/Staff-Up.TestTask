package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import properties.ConfProperties;

public class ChromeTest {
    public static WebDriver driver;

    AutoQALoginPage objLogin;
    AutoQAMainPage objMain;
    AutoQAProductsPage objProducts;
    AutoQACreateProductPage objCreateProduct;
    AutoQAUpdateProductPage objUpdateProduct;

    String strProductTitle = "ReallyGoodBoy5586";
    String strProductCategory = "162";
    String strProductVendorCode = "c45dsfs84532er2";
    String strProductShortDescription = "ReallyGoodBoy5586";
    String strProductDescription = "This dog is ReallyGoodBoy5586";
    String strProductQuantityUnits = "pieces";
    String strProductPrice = "100000";
    String strProductUploadImage = "C:\\Users\\marad\\IdeaProjects\\Staff-Up.TestTask\\src\\images\\img.jpg";

    String updateStrProductTitle = "";
    String updateStrProductCategory = "167";
    String updateStrProductVendorCode = "";
    String updateStrProductShortDescription = "";
    String updateStrProductDescription = "This dog is ReallyGoodBoy5586. It is true!";
    String updateStrProductQuantityUnits = "mass_kg";
    String updateStrProductPrice = "";
    String updateStrProductUploadImage = "";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("url"));
        objLogin = new AutoQALoginPage(driver);
        objMain = new AutoQAMainPage(driver);
        objProducts = new AutoQAProductsPage(driver);
        objCreateProduct = new AutoQACreateProductPage(driver);
        objUpdateProduct = new AutoQAUpdateProductPage(driver);
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        objLogin.loginToAutoQA(ConfProperties.getProperty("email"), ConfProperties.getProperty("password"));
        Thread.sleep(1000);
        Assert.assertTrue(objMain.getUsername().contains(ConfProperties.getProperty("email")));
    }


    @Test(priority = 2)
    public void goToCreateProductPageTest() throws InterruptedException {
        objMain.clickProducts();
        Thread.sleep(1000);
        objProducts.clickCreateProduct();
        Thread.sleep(1000);
        Assert.assertTrue(objCreateProduct.getActiveCondition().contains("Создание продукта"));
    }

    @Test(priority = 3)
    public void createNewProductTest() throws InterruptedException {
        objCreateProduct.createProductToAutoQA(strProductTitle, strProductCategory, strProductVendorCode, strProductShortDescription, strProductDescription, strProductQuantityUnits, strProductPrice, strProductUploadImage);
        Thread.sleep(1000);
        objCreateProduct.clickProducts();
        Thread.sleep(1000);
        objProducts.setVendorCode(strProductVendorCode + "\n");
        Thread.sleep(1000);
        Assert.assertTrue(objProducts.getVendorCode().contains(strProductVendorCode));
    }

    @Test(priority = 4)
    public void goToUpdateProductPageTest() throws InterruptedException {
        objProducts.clickUpdateProduct();
        Thread.sleep(1000);
        Assert.assertTrue(objUpdateProduct.getActiveCondition().contains("Изменение продукта"));
    }

    @Test(priority = 5)
    public void updateAnExistingProductTest() throws InterruptedException {
        objUpdateProduct.setProductCategory(updateStrProductCategory);
        objUpdateProduct.setProductDescription(updateStrProductDescription);
        objUpdateProduct.setProductQuantityUnits(updateStrProductQuantityUnits);
        objUpdateProduct.clickSave();
        Thread.sleep(1000);
        Assert.assertTrue(objUpdateProduct.getSuccessUpdatingAlert().contains("Успешно изменено!"));
    }

    @AfterClass
    public void closeUp() {
        driver.close();
    }
}
