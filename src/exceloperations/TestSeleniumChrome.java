package exceloperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.ConfigReader;

public class TestSeleniumChrome {
	
	ConfigReader config;
	@BeforeTest
	public void setup()
	{
		config=new ConfigReader();
		System.setProperty("webdriver.chrome.driver",config.getChromePath());
	}
	
	@Test
	public void testChrome() 
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get(config.getApplicationUrl());
		driver.quit();
		
	}

}
