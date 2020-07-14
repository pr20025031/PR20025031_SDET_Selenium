package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage_Germany {

public WebDriver driver;
	
	public HomePage_Germany(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement clickonRegister()
	{
		return driver.findElement(By.linkText("Registrieren"));
	}
}
