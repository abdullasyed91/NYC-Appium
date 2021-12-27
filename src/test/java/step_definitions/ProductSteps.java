package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.Login;
import page_objects.Product;

public class ProductSteps {
    AppiumDriver driver = Hooks.driver;

    @Given("^the user in on the product page upon successful login$")
    public void theUserInOnTheProductPageUponSuccessfulLogin() {
        new Login(driver)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton();
    }

    @Then("^validate the product is listed with title \"(.+?)\" and price \"(.+?)\"$")
    public void validateTheProductIsListedWithTitleAndPrice(String title, String price) {
        new Product(driver)
                .validateProductInfo(title)
                .validateProductPrice(price);
    }

    @Given("^the user is on the product page upon successful login$")
    public void theUserIsOnTheProductPageUponSuccessfulLogin() {
        new Login(driver)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton();
    }

    @When("^user clicks on the product title \"(.+?)\"$")
    public void userClicksOnTheProductTitle(String title) {
        new Product(driver)
                .navigateToBackpack();
    }

    @Then("^user should be on product details page with title \"(.+?)\", price \"(.+?)\" and \"(.+?)\"$")
    public void userShouldBeOnProductDetailsPageWithTitlePriceAnd(String title, String price, String description) {
        new Product(driver)
                .validatePackPrice(price)
                .validateBackpackDescription(description);
    }
}
