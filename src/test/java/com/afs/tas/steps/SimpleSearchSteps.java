package com.afs.tas.steps;

import com.afs.tas.devices.DeviceFactory;
import com.afs.tas.utilities.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.util.List;

public class SimpleSearchSteps {

    Logger log = Logger.getLogger(SimpleSearchSteps.class);
    long timeOut = (long) 5.0;

    By googleIconBy = By.id("hplogo");
    By searchGoogleBy = By.name("q");
    By submitGoogleBy = By.name("btnK");
    By googleLogoBy = By.id("logo");
    By googlePagesBy = By.xpath("//a[@aria-label=\"Page 2\"]");

    By bingIconBy = By.id("b_logo");
    By searchBingBy = By.id("sb_form_q");
    By submitBingBy = By.className("search");
    By bingLogoBy = By.className("b_logoArea");
    By bingPagesBy = By.className("b_pag");
    By automationPracticeTitle = By.id("header_logo");
    By automationPracticeWomens = By.xpath("//a[@title=\"Women\"]");
    By automationPracticeWomensTshirts = By.xpath("//a[@title=\"T-shirts\"]");
    By automationPracticeWomensTshirtsHover = By.className("cat-name");

    WebDriver driver;
    WebDriverWait wait;
    private Scenario scenario;


    public SimpleSearchSteps() {
        log.debug("Creating Chrome Browser.");
        driver = DeviceFactory.getDevice("Chrome");
        wait = new WebDriverWait(driver, timeOut);
    }

    @Before
    public void setup(Scenario scenario){
        this.scenario = scenario;

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Screenshot.embedScreenshot(scenario, driver);
        }
        driver.quit();
    }

    @Given("^I visit google\\.com$")
    public void i_visit_google_com() {
        driver.get("https://www.google.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(googleIconBy));
    }

    @When("^I search google for (.*)$")
    public void i_search_for(String term) {
        WebElement searchField = driver.findElement(searchGoogleBy);
        searchField.sendKeys(term);
        WebElement submitButton = driver.findElement(submitGoogleBy);
        submitButton.isDisplayed();
        submitButton.click();
    }

    @Then("^google retrieves more than one page of (.*)$")
    public void google_retrieves_more_than_one_page_of(String term) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(googleLogoBy));
        List<WebElement> elements = driver.findElements(googlePagesBy);

        log.debug("There are " + elements.size() + " (hopefully 1) elements matching page 2");
        Assert.assertTrue(elements.size() == 1);
    }

    @Given("^I visit bing\\.com$")
    public void i_visit_bing_com() {
        driver.get("https://www.bing.com");
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(bingIconBy));

    }

    @When("^I search bing for (.*)$")
    public void i_search_bing_for(String term) {
        WebElement searchField = driver.findElement(searchBingBy);
        searchField.sendKeys(term);
        WebElement submitButton = driver.findElement(submitBingBy);
        submitButton.isDisplayed();
        submitButton.click();

    }

    @Then("^bing retrieves more than one page of (.*)$")
    public void bing_retrieves_more_than_one_page_of(String term) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(bingLogoBy));
        List<WebElement> elements = driver.findElements(bingPagesBy);
        log.debug("There are " + elements.size() + " (hopefully 1) elements matching page 2");
        Assert.assertTrue(elements.size() == 1);
    }
}
