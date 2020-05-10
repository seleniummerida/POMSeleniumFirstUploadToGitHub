package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerPage extends base{
	
	public registerPage(WebDriver driver) {
		super(driver);
	}
	
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
	
	By userNameLocator = By.id("email");
	By passLocator = By.name("password");
	By confrimPassLocator = By.cssSelector("input[name='confirmPassword']");
	
	By registerBtnLocator = By.name("register");
	
	By registeredMessage = By.tagName("font");
	
	public void registerUser() throws InterruptedException {
		click(registerLinkLocator);
		Thread.sleep(2000);
		if(isDisplayed(registerPageLocator)) {
			type("merida2020", userNameLocator);
			type("merida2020", passLocator);
			type("merida2020", confrimPassLocator);
			
			click(registerBtnLocator);
		}
		else {
			System.out.println("Register Page was not found");
		}
			
	}
	
	public String registeredMessage() {
		List<WebElement> fonts = findElements(registeredMessage);
		return getText(fonts.get(5));		
	}
	
}
