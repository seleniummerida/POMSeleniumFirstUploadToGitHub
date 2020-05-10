package com.project.pom;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInPage extends base{

	public signInPage(WebDriver driver) {
		super(driver);
	}
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By SignBtnLocator = By.name("login");
	
	By homePageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

	public void signIn() throws InterruptedException {
		
		if (isDisplayed(userLocator)) {
			type("merida2020", userLocator);
			type("merida2020", passLocator);			
			click(SignBtnLocator);
			Thread.sleep(2000);			
		}
		else {
			System.out.println("Sign In Page was not found");
		}
		
	}
	
	public Boolean isHomePageDisplayed() {
		return isDisplayed(homePageLocator);
	}
}
