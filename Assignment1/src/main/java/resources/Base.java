package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	
	public Properties prop;
	
	public WebDriver initializedDriver() throws IOException
	{
		
		prop = new Properties();
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\HP1\\PR20025031_Prasad_Ram_Sarode_Selenium_Assignment\\Assignment1\\src\\main\\java\\resources\\data.properties");
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\HP1\\PR20025031_Prasad_Ram_Sarode_Selenium_Assignment_New\\Assignment1\\src\\main\\java\\resources\\datanew.properties");
		prop.load(fis1);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP1\\PR20025031_Prasad_Ram_Sarode_Selenium_Assignment_New\\Assignment1\\src\\main\\java\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
	 
}
