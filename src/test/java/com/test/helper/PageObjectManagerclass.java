package com.test.helper;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.FetchingCoinPage;

public class PageObjectManagerclass {

public static WebDriver driver;
	
	private HomePage p1;
	private FetchingCoinPage p2;	
	

	public PageObjectManagerclass(WebDriver ldriver) {
		this.driver = ldriver;
		
	}
	
	

	public HomePage getInstancePomOne() {
		p1 = new HomePage(driver);
		return p1;
		
	}
	public FetchingCoinPage getInstancePomTwo() {
		p2 = new FetchingCoinPage(driver);
		return p2;
	}
		
		
		}

