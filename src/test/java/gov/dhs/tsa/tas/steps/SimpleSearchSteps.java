package gov.dhs.tsa.tas.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.dhs.tsa.tas.devices.DeviceFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SimpleSearchSteps {

    long timeOut = (long) 5.0;

    By googleIconBy = By.id("hplogo");
    By searchBy = By.name("q");
    By submitBy = By.name("btnK");
    By logoBy = By.id("logo");
    By pagesBy = By.xpath("//a[@aria-label=\"Page 2\"]");
    WebDriver driver;

    public SimpleSearchSteps() {
        driver = DeviceFactory.getDevice("Chrome");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^I visit google\\.com$")
    public void i_visit_google_com() {
        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(googleIconBy));

    }

    @When("^I search for (.*)$")
    public void i_search_for(String term){
        WebElement searchField = driver.findElement(searchBy);
        searchField.sendKeys(term);
        WebElement submitButton = driver.findElement(submitBy);
        submitButton.isDisplayed();
        submitButton.click();

    }

    @Then("^I can see more than one page of (.*)$")
    public void i_can_see_more_than_one_page_of(String term) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(logoBy));
        List<WebElement> elements = driver.findElements(pagesBy);
        System.out.println(" * * * * * * * * * " + elements.size());
        Assert.assertTrue(elements.size() == 1);
    }


}
