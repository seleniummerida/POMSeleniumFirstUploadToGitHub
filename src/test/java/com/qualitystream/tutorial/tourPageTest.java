package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tourPageTest {
private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");				
	}
	
	@Test
	public void signUpIn() {
		WebElement register = driver.findElement (By.xpath("//a[text()='REGISTER']"));//(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
		register.click();
		
		driver.findElement(By.id("email")).sendKeys("merida2020");
		driver.findElement(By.name("password")).sendKeys("merida2020");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("merida2020");
		driver.findElement(By.xpath("//input[@src='/images/forms/submit.gif']")).click();
		
		driver.findElement(By.linkText("Home")).click();
		
		driver.findElement(By.name("userName")).sendKeys("merida2020");
		driver.findElement(By.name("password")).sendKeys("merida2020");
		driver.findElement(By.name("login")).click();
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String success = driver.findElement(By.xpath("//font[text()[contains(.,'Use our Flight')]]")).getText();//(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText();
		System.out.println(success);
		assertEquals("Use our Flight Finder to search", success.trim().substring(0, 31));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
