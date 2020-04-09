package com.afs.tas.steps;

import com.afs.tas.devices.DeviceFactory;
import com.afs.tas.utilities.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class MySample {
    Logger log = Logger.getLogger(MySample.class);
    long timeOut = (long) 5.0;

    By automationPracticeTitle = By.id("header_logo");
    By automationPracticeWomens = By.xpath("//a[@title=\"Women\"]");
    By automationPracticeWomensTshirts = By.xpath("//a[@title=\"T-shirts\"]");
    By automationPracticeWomensTshirtsHover = By.className("cat-name");

    WebDriver driver;
    WebDriverWait wait;
    private Scenario scenario;

    public MySample(){
        driver = DeviceFactory.getDevice("Chrome");
    }

    @Given("^I visit automationpractice\\.com$")
    public void iVisitAutomationPracticeCom() {
        driver.get("http://automationpractice.com/index.php");
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(automationPracticeTitle));
    }

    @When("^I shop for Women's clothing$")
    public void iShopForWomensClothing() {
        WebElement womensTab = driver.findElement(automationPracticeWomens);
        wait.until(ExpectedConditions.presenceOfElementLocated(automationPracticeWomens));
        log.info("Womens tab displayed: " + (womensTab.isDisplayed() ? "True" : "False"));
        log.info("Womens tab enabled: " + (womensTab.isEnabled() ? "True" : "False"));
        log.info("Womens tab selected: " + (womensTab.isSelected() ? "True" : "False"));
        log.info("Womens tab size: " + womensTab.getSize());
        log.info("Womens tab text: " + womensTab.getText());
        womensTab.click();
        WebElement search_query_top = driver.findElement(By.id("search_query_top"));
        search_query_top.sendKeys("This sequence.");

        log.info("Search query top type: " + search_query_top.getTagName());
        wait.until(ExpectedConditions.presenceOfElementLocated(automationPracticeWomensTshirts));
        WebElement tshirtButton = driver.findElement(automationPracticeWomensTshirts);
        Actions action = new Actions(driver);
        action.moveToElement(tshirtButton).click();
    }

    @Then("^I can select Tshirts$")
    public void iCanSelectTshirts() {
        wait.until(ExpectedConditions.presenceOfElementLocated(automationPracticeWomensTshirtsHover));
        WebElement tshirtHover = driver.findElement(automationPracticeWomensTshirtsHover);
        Assert.assertEquals(tshirtHover.getText(), "T-SHIRTS ");
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Screenshot.embedScreenshot(scenario, driver);
        }
        driver.quit();
    }
}
