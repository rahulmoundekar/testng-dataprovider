package com.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderArray {

	@DataProvider(name = "sentrifugo")
	public static Object[][] credentials() {
		return new Object[][] { { "EM01", "sentrifugo" }, { "EM02", "sentrifugo" } };
	}

	private static WebDriver driver;

	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.sentrifugo.com/index.php/");
	}

	@Test(dataProvider = "sentrifugo")
	public void login(String sUsername, String sPassword) {

		driver.findElement(By.id("username")).sendKeys(sUsername);

		driver.findElement(By.id("password")).sendKeys(sPassword);

		driver.findElement(By.id("loginsubmit")).click();

		driver.findElement(By.id("logoutbutton")).click();

		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
