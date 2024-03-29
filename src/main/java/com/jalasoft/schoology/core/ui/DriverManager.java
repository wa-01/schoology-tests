package com.jalasoft.schoology.core.ui;

import java.util.concurrent.TimeUnit;

import com.jalasoft.schoology.core.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
	private static DriverManager ourInstance = new DriverManager();

	public static DriverManager getInstance() {
		return ourInstance;
	}

	private WebDriver driver;

	private WebDriverWait wait;

	private DriverManager() {
		String browser = Environment.getInstance().getValue("$['browser']");
		driver = DriverFactory.getDriver(browser);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);

		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}
}
