package runnerClass;



import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import baseHelperClass.BaseClass;
import io.cucumber.junit.CucumberOptions;
import utilities.ConfigManage;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/features",
glue= {"stepDefinitionPackage"},
monochrome=true,
plugin={"pretty","junit:target/JunitReports/report.xml"},
tags="@SmokeTest")

public class CoinMarketCapRunner {
	public static WebDriver driver;
	@BeforeClass
	public static void setup() throws IOException {
		 String browserNames = ConfigManage.getInstance().getCrInstance().getBrowser();
		driver = BaseClass.browserLaunch(browserNames);
	}
	@AfterClass
	public static void teardown() {
		driver.close();
	}
}

