package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
public static WebDriver driver;
	
	public Properties prop;
	
	public WebDriver initializedDriver() throws IOException
	{
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HP1\\PR20025031_Prasad_Ram_Sarode_Selenium_Assignment_New\\Assignment2\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP1\\PR20025031_Prasad_Ram_Sarode_Selenium_Assignment_New\\Assignment2\\src\\main\\java\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}

}
