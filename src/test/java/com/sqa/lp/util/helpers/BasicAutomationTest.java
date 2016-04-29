package com.sqa.lp.util.helpers;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class BasicAutomationTest {

	private String baseURL = "http://www.ebay.com/";
	private Properties devProps;
	private String devPropsLocation = "src/main/resources/dev.properties";
	private Properties sharedMapUI;
	private String sharedMapUILocation = "src/main/resources/shared-map-ui.properties";

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void loadProperties() {
		this.sharedMapUI = ConProperties.loadProperties(this.devPropsLocation);
		this.devProps = ConProperties.loadProperties(this.devPropsLocation);
	}

	@Test(priority = 1)
	public void setUpTest() {
		System.out.println("Set up Test");

		WebDriver driver = new FirefoxDriver();
		driver.get(this.baseURL);
	}

	@Test(dataProvider = "dp", priority = 50)
	public void test(Integer n, String s) {
		System.out.println("Test: " + n);

	}
}
