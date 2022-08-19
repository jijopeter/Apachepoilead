package exceloperations;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.ExcelDataConfig;

public class WordpressLoginExcel {
  WebDriver driver;
	@Test(dataProvider="wordpressdata")
	public void loginwordpress(String username,String password) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\eclipse-workspace\\ApachePOI\\server\\geckodriver.exe");
	 	driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
		driver.findElement(By.xpath("//input[@id='usernameOrEmail']")).sendKeys(username);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		//System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("My Home"),"invalid credentials");
		System.out.println("user is able to login successfully");
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@DataProvider(name="wordpressdata")
	public Object[][] passdata()
	{
		ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\Admin\\eclipse-workspace\\ApachePOI\\datafiles\\InputData.xlsx");
		int rows=config.getRowCount(0);
		Object[][] data=new Object[rows][2];
		for(int i=0;i<rows;i++)
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
		}
		return data;
	}

}
