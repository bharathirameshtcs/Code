package com.voctoria.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Configuration {

	public static Properties properties = new Properties(); // Here we imported
															// Java.util

	public static String filepath;
	public static FileInputStream in;
	public static String URL;

	public static String Browser;
	public static WebDriver driver;
	public static String username;
	public static String password;

	public static WebDriver browser() {
		Reporter.log("in browser loop", true);

		if (Browser.equalsIgnoreCase("firefox")) {
			if (driver == null) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else
				return driver;

		}

		else if (Browser.equalsIgnoreCase("ie")) {
			if (driver == null) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else
				return driver;

		} else if (Browser.equalsIgnoreCase("chrome")) {
			if (driver == null) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else
				return driver;
		} else if (Browser.equalsIgnoreCase("safari")) {
			if (driver == null)
				driver = new SafariDriver();
			return driver;
		}
		return driver;

	}

	static {
		try {
			{
				filepath = "src/test/resources/QA-environment.properties";
				in = new FileInputStream(System.getProperty("user.dir") + "/" + filepath);
				properties.load(in);
				Reporter.log("in properties qa loop", true);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		URL = properties.getProperty("url");

		Browser = properties.getProperty("Browser");

	}

	

}
