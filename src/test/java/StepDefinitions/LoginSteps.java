package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver = null;

    @Given("I navigate to the page {string}")
    public void i_navigate_to_the_page(String url) {

        //este bloque debería ser configurable Todo: crear componente
        System.getProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //step debe comenzar desde aquí
        driver.navigate().to(url);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("consent_cookies_title")));
    }

    @And("I close the modal by pressing the {string} element")
    public void i_close_the_modal_by_pressing_the_element(String locator) {

        /*debería llegar a traves de la definción del step : Todo: crer manera de parametrizar los webelements
        la idea es pasar por el step un string referente (locator) un objeto locator serializado en una lista para buscar
        hacer una comprobación para ver qué tipo de locator tiene (id, xpath...) para poder construir la función By.
        y finalmente devolver el valir del locatorl.
        ejempl yaml
                locator:
                     type: xpath
                     value: //button[@data-cookiebanner="accept_button"]
         Lo hardcodeo hasta que pueda construirlo
         */

        driver.findElement(By.xpath(locator)).click();
    }

    @Given("The login page has loaded")
    public void the_page_has_loaded() {
        driver.getTitle().contains("Facebook - Entrar o registrarse");
    }

    @Given("a registered user")
    public void aRegisteredUser() {
        System.out.println("??? - sin uso para este step");
    }

    @When("at endpoint {string}, into input field {string}, insert the value {string}")
    public void atEndpointIntoInputFieldInsertTheValue(String url, String elementLocator, String someText) {
        //driver.navigate().to(url);
        //driver.findElement(By.xpath("//button[@data-cookiebanner=\"accept_button\"]")).click();
        driver.findElement(By.id(elementLocator)).sendKeys(someText);
    }

    @And("at endpoint {string}, click on {string} button")
    public void atEndpointClickOnButton(String url, String locator) {
        driver.navigate().to(url);
        driver.findElement(By.xpath("//button[@data-cookiebanner=\"accept_button\"]")).click();
        driver.findElement(By.name(locator)).click();
    }

    @When("I fill in {string} with {string}")
    public void i_fill_in_with(String elementLocator, String someText) {
        driver.findElement(By.id(elementLocator)).sendKeys(someText);
    }

    @When("I click on {string} button")
    public void i_click_on_button(String locator) {
        driver.findElement(By.name(locator)).click();
    }

    @Then("the element {string} is visible")
    public void the_element_is_visible(String locator) {
        driver.findElement(By.xpath(locator)).isDisplayed();
    }

    @Then("at endpoint {string}, the element {string} is visible")
    public void atEndpointTheElementIsVisible(String url, String locator) {
        driver.navigate().to(url);
        driver.findElement(By.xpath("//button[@data-cookiebanner=\"accept_button\"]")).click();
        driver.findElement(By.xpath(locator)).isDisplayed();
    }

    @Then("the page contains the text {string}")
    public void thePageContainsTheText(String text) {
        driver.getPageSource().contains(text);

        // Todo: sacar estos comandos a un Hook
        driver.close();
        driver.quit();
    }




}
