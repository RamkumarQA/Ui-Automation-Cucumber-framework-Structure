package com.afw.StepDefinition;

import org.openqa.selenium.WebDriver;
import com.afw.PageObjects.LoginPage;
import com.afw.Web_Driver_Manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class Verify_UserName_Step_Def {
	private static final Logger LOGGER = LogManager.getLogger(Verify_UserName_Step_Def.class);
	
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get(DriverManager.getAppUrl());
        LOGGER.info("the user is on the login page");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        loginPage.enterUsername(username);
        LOGGER.info("Enters User Name");
        loginPage.enterPassword(password);
        LOGGER.info("Enters Password");
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.clickLoginButton();
        LOGGER.info("clicks on the Login Button");
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        String actualTitle = driver.getTitle();
        LOGGER.info("Actual Home Page Title: " + actualTitle);
        String expectedTitle = "Guru99 Bank Manager HomePage";
        Assert.assertEquals(expectedTitle, actualTitle);
        LOGGER.info("the user should be redirected to the home page");
    }

    @Then("the home page title should be {string}")
    public void the_home_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle());
        LOGGER.info("the home page title should be Guru99 Bank Manager HomePage");
    }
}