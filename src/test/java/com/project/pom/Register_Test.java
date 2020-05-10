package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Register_Test {

	private WebDriver driver;
	registerPage registerPage;
	
	@Before
	public void setUp() throws Exception {
		registerPage = new registerPage(driver);
		driver = registerPage.chromeDriverConnection();
		registerPage.NavigateTo("http://newtours.demoaut.com/mercurywelcome.php");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		registerPage.registerUser();
		assertEquals("Note: Your user name is merida2020.", registerPage.registeredMessage());
	}

}
