package exceloperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.ConfigReader;

public class TestSeleniumFirefox {
	
	ConfigReader config;
	@BeforeTest
	public void setup()
	{
		config=new ConfigReader();
		System.setProperty("webdriver.gecko.driver", config.getFirefoxPath());
	}
	@Test
	public void testFirefox()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get(config.getApplicationUrl());
		driver.quit();
	}

}
