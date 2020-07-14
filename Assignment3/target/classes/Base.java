package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initialiseDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\HP1\\PR20025031_Prasad_Ram_Sarode_Selenium_Assignment\\Assignment3\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP1\\PR20025031_Prasad_Ram_Sarode_Selenium_Assignment_New\\Assignment3\\src\\main\\java\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP1\\PR20025031_Prasad_Ram_Sarode_Selenium_Assignment\\Assignment3\\src\\main\\java\\Drivers\\geckodriver.exe");
		}
		
		return driver;
	}

}
