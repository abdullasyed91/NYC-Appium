package page_objects;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class Product {
    private static final Logger LOGGER = LogManager.getLogger(Product.class);

    private static final String SauceLabsTshirt = "(//android.widget.TextView[@content-desc='test-Item title'])[3]";
    private static final String TShirtPrice = "(//android.widget.TextView[@content-desc='test-Price'])[3]";
    private static final String SauceLabsBackpack ="(//android.view.ViewGroup[@content-desc='test-Item'])[1]/android.view.ViewGroup/android.widget.ImageView";
    private static final String BackpackPrice = "test-Price";
    private static final String BackpackDescription = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[2]";

    private AppiumDriver driver;

    public Product(AppiumDriver driver) {
        this.driver = driver;
    }

    public Product validateProductInfo(String expectedText) {
        String actualText = driver.findElementByXPath(SauceLabsTshirt).getText();
        LOGGER.debug("Validating Sauce Labs T-Shirt text");
        Assert.assertEquals(expectedText, actualText);
        return this;
    }

    public Product validateProductPrice(String expectedPrice) {
        String actualPrice = driver.findElementByAccessibilityId(TShirtPrice).getText();
        LOGGER.debug("validate the tshirt price" + actualPrice);
        Assert.assertEquals(expectedPrice, actualPrice);
        return this;
    }

    public Product navigateToBackpack() {
        driver.findElementByXPath(SauceLabsBackpack).click();
        LOGGER.debug("Navigating to backpack description");
        return this;
    }

    public Product validatePackPrice(String expectedPrice) {
        String actualPrice = driver.findElementByAccessibilityId(BackpackPrice).getText();
        LOGGER.debug("Validating the backpack price" + actualPrice);
        Assert.assertEquals(expectedPrice, actualPrice);
        return this;
    }

    public Product validateBackpackDescription(String expectedText) {
        String actualText = driver.findElementByXPath(BackpackDescription).getText();
        LOGGER.debug("validating the backpack description" + actualText);
        Assert.assertEquals(expectedText, actualText);
        return this;
    }


}
