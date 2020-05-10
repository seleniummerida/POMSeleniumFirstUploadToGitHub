package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class signIn_Test {
	
	private WebDriver driver;
	signInPage signInPage;

	@Before
	public void setUp() throws Exception {
		signInPage = new signInPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.NavigateTo("http://newtours.demoaut.com/mercurywelcome.php");
	}

	@After
	public void tearDown() throws Exception {
	//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		signInPage.signIn();
		Thread.sleep(2000);	
		assertTrue(signInPage.isHomePageDisplayed());
	}

}
