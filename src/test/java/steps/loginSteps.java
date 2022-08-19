package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginSteps {

    WebDriver driver;
    @Given("user is navigated to the specified url")
        public void user_is_navigated_to_specified_url() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        }

//    @When("user enters a valid username and password")
//    public void user_enters_a_valid_username_and_password() {
//        WebElement usernameTextField = driver.findElement(By.id("txtUsername"));
//        usernameTextField.sendKeys("admin");
//        WebElement passwordTextField = driver.findElement(By.id("txtPassword"));
//        passwordTextField.sendKeys("Hum@nhrm123");
//
//    }

    @When("user enters a valid {string} and {string}")
    public void user_enters_a_valid_and(String username, String password) {
        WebElement usernameTextField = driver.findElement(By.id("txtUsername"));
        usernameTextField.sendKeys(username);
        WebElement passwordTextField = driver.findElement(By.id("txtPassword"));
        passwordTextField.sendKeys(password);

    }

    @When("click on login button")
    public void click_on_login_button() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        Thread.sleep(2000);
    }
    @Then("the user is able to see the message Welcome Admin")
    public void the_user_is_able_to_see_the_message_welcome_admin() {
        WebElement welcome = driver.findElement(By.id("welcome"));
        String actualText = welcome.getText();
        String expectedText ="Welcome Admin";

        Assert.assertEquals(actualText,expectedText);

    }


    @When("user enters different {string} and {string} and verify the {string}")
    public void user_enters_different_and_and_verify_the(String username, String password, String expectedError) {
        WebElement usernameTextField = driver.findElement(By.id("txtUsername"));
        usernameTextField.sendKeys(username);
        WebElement passwordTextField = driver.findElement(By.id("txtPassword"));
        passwordTextField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement errorMsg = driver.findElement(By.id("spanMessage"));
        String actualError = errorMsg.getText();
        Assert.assertEquals(actualError,expectedError);
    }



}

