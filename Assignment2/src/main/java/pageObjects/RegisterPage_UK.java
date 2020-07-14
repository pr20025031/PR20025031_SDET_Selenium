package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage_UK {
	
	public WebDriver driver;
	
	public RegisterPage_UK(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement Email()
	{
		return driver.findElement(By.cssSelector("input[data-key='emailAddress']"));
	}
	
	public WebElement Password()
	{
		return driver.findElement(By.cssSelector("input[data-key='newPassword']"));
	}
	
	public WebElement confirmPassword()
	{
		return driver.findElement(By.cssSelector("input[validationregexerror='Password and Confirm Password values must match. Please try again.']"));
	}
	
	
	public void selectDate(String date) 
	{
		Select s = new Select(driver.findElement(By.id("phdesktopbody_0_grs_consumer[birthdate][day]")));
		
		s.selectByVisibleText(date);
	}
	
	public void selectMonth(String month)
	{
		Select s = new Select(driver.findElement(By.id("phdesktopbody_0_grs_consumer[birthdate][month]")));
		
		s.selectByVisibleText(month);
	}
	
	public void selectYear(String year)
	{
		Select s = new Select(driver.findElement(By.id("phdesktopbody_0_grs_consumer[birthdate][year]")));
		
		s.selectByVisibleText(year);
	}
	
	public WebElement acceptCookies()
	{
		return driver.findElement(By.id("onetrust-accept-btn-handler"));
	}
	
	public WebElement submit()
	{
		return driver.findElement(By.id("phdesktopbody_0_submit"));
	}
	

}
