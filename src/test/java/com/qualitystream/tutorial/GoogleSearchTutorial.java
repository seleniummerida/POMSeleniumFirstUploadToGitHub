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

public class GoogleSearchTutorial {
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();		
	}
	
	@Test
	public void launchGoogle() {
		WebElement google = driver.findElement(By.name("q"));
		
		google.sendKeys("sat");
		
		google.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String first = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/a/h3")).getText();
		//System.out.println(first);
		assertEquals("SAT: Portal de trámites y servicios", first.trim());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
