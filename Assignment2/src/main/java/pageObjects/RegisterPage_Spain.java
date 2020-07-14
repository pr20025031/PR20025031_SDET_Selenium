package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage_Spain {

	public WebDriver driver;

	public RegisterPage_Spain(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("Male"))
		{
			return driver.findElement(By.id("phdesktopbody_0_imgmale"));
		}
		if(gender.equalsIgnoreCase("Female"))
		{
			return driver.findElement(By.id("phdesktopbody_0_imgfemale"));
		}
		return null;
	}
	
	public WebElement firstName()
	{
		return driver.findElement(By.id("phdesktopbody_0_grs_consumer[firstname]"));
	}
	
	public WebElement lastName()
	{
		return driver.findElement(By.id("phdesktopbody_0_grs_consumer[lastname]"));
	}
	
	public WebElement middleName()
	{
		return driver.findElement(By.id("phdesktopbody_0_labelgrs_consumer[secondary_lastname]"));
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
		return driver.findElement(By.id("phdesktopbody_0_grs_account[password][confirm]"));
	}
	
	public void selectDate(String date) 
	{
		Select s = new Select(driver.findElement(By.xpath("//select[@data-key='birthdate[dateselect_day]']")));
		
		s.selectByVisibleText(date);
	}
	
	public void selectMonth(String month)
	{
		Select s = new Select(driver.findElement(By.xpath("//select[@data-key='birthdate[dateselect_month]']")));
		
		s.selectByVisibleText(month);
	}
	
	public void selectYear(String year)
	{
		Select s = new Select(driver.findElement(By.xpath("//select[@data-key='birthdate[dateselect_year]']")));
		
		s.selectByVisibleText(year);
	}
	
	public WebElement phoneNumber()
	{
		return driver.findElement(By.cssSelector("input[data-key='phone']"));
		
	}
	
	public WebElement acceptCookies()
	{
		return driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
	}
	public WebElement checkBox()
	{
		return driver.findElement(By.id("phdesktopbody_0_ctl74"));
	}
	
	public WebElement submit()
	{
		return driver.findElement(By.id("phdesktopbody_0_submit"));
	}
	
}
