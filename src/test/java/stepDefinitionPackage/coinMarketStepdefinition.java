package stepDefinitionPackage;



import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.helper.PageObjectManagerclass;

import baseHelperClass.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import runnerClass.CoinMarketCapRunner;

public class coinMarketStepdefinition{
	public static WebDriver driver = CoinMarketCapRunner.driver ;
	PageObjectManagerclass pom = new PageObjectManagerclass(driver);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
	
	@When("user launch the Coin cap application")
	public void user_launch_the_Coin_cap_application() throws IOException {
		
		driver.get("https://coinmarketcap.com");
		pom.getInstancePomTwo().getokButton().click();
		pom.getInstancePomTwo().getmayBeLaterButton().click();
		pom.getInstancePomOne().getloginbutton().click();
		System.out.println("***Login button clicked***  ");
		
	}
	
	@When("user enters the valid {string} and valid {string}")
	public void user_enters_the_valid_and_valid(String string, String string2)  {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
	   wait.until(ExpectedConditions.visibilityOf(pom.getInstancePomOne().getUsername()));
	   	pom.getInstancePomOne().getUsername().sendKeys(string);
		pom.getInstancePomOne().getPassword().sendKeys(string2);
		System.out.println("***User Entered the valid credentails***  ");
	}
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		pom.getInstancePomOne().getLogin().click();
		System.out.println("***User clicked on Login Button***  ");
		
	}
	@When("user selecting the coins values")
	public void user_selecting_the_coins_values() {
		
		wait.until(ExpectedConditions.elementToBeClickable(pom.getInstancePomTwo().getselectNoOfRows()));
		pom.getInstancePomTwo().getselectNoOfRows().click();
	    System.out.println("Dropdown clicked");
		wait.until(ExpectedConditions.visibilityOf(pom.getInstancePomTwo().getselectOption()));
	    Actions a = new Actions(driver);
		a.moveToElement(pom.getInstancePomTwo().getselectOption()).perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",pom.getInstancePomTwo().getselectOption());
		
		}
	
@Then("user collects the coins before and after the filters and comparing the results using assert")
public void user_collects_the_coins_before_and_after_the_filters_and_comparing_the_results_using_assert() {
	//Fetching the 20 coins using show rows Dropdown.
			List <String> filteredTwentyCoins = new ArrayList<>();
			 for(int i=0;i<pom.getInstancePomTwo().getcoins().size();i++){
				
				 filteredTwentyCoins.add(pom.getInstancePomTwo().getfilteredCoins().get(i).getText());
			    	String text1 = pom.getInstancePomTwo().getfilteredCoins().get(i).getText();
			    	System.out.println(text1);
			 }
			 //Click on filter and algorithm Button
			 wait.until(ExpectedConditions.visibilityOf(pom.getInstancePomTwo().getfilterButton()));
			pom.getInstancePomTwo().getfilterButton().click();
			wait.until(ExpectedConditions.visibilityOf(pom.getInstancePomTwo().getalgorithmButton()));
			pom.getInstancePomTwo().getalgorithmButton().click();
			
			JavascriptExecutor jsOne = (JavascriptExecutor) driver;
			jsOne.executeScript("arguments[0].click();",pom.getInstancePomTwo().getpowButton());
			//Clicks on Add Filter Button
			pom.getInstancePomTwo().getaddFilterButton().click();
			wait.until(ExpectedConditions.visibilityOf(pom.getInstancePomTwo().getaddCurrenciesButton()));
			pom.getInstancePomTwo().getaddCurrenciesButton().click();
			pom.getInstancePomTwo().getaddCoinsOnlyButton().click();
			//Clicks on price Button
			pom.getInstancePomTwo().getpriceButton().click();
			wait.until(ExpectedConditions.visibilityOf(pom.getInstancePomTwo().getaddCurrenciesButton()));
			pom.getInstancePomTwo().getminTextBox().sendKeys("100");
			pom.getInstancePomTwo().getmaxTextBox().sendKeys("10000");
			//clicks on apply filter
			wait.until(ExpectedConditions.visibilityOf(pom.getInstancePomTwo().getapplyFilter()));
			pom.getInstancePomTwo().getapplyFilter().click();
			pom.getInstancePomTwo().getMineableButton().click();
			wait.until(ExpectedConditions.visibilityOf(pom.getInstancePomTwo().getshowResultsButton()));
			pom.getInstancePomTwo().getshowResultsButton().click();
			//Collects filtered coins and verify by Assertion
			List <String> filteredCoins = new ArrayList<>() ;
			 for(int i=0;i<pom.getInstancePomTwo().getfilteredCoins().size();i++){
				
				 filteredCoins.add(pom.getInstancePomTwo().getfilteredCoins().get(i).getText());
				 String text = pom.getInstancePomTwo().getfilteredCoins().get(i).getText();
				 System.out.println("Filtered coins");
				 System.out.println(text);
			 }
			 Assert.assertTrue(filteredCoins.containsAll(filteredTwentyCoins));
		
	System.out.println("***Comparison done***  ");
}
}