package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Datepicker {
	public WebDriver driver;

	public Datepicker(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToDatepicker(String datepickerUrl) throws InterruptedException
	{
		driver.get(datepickerUrl);//navigating to datepicker
	}

	public void selectDate() throws InterruptedException {
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		
		 while ((driver.findElement(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']")).
				 getText().equalsIgnoreCase("December 2019"))==false)
		 {
			driver.findElement(By.xpath("//button[text()='Previous Month']")).click();			
		}
		 driver.findElement(By.xpath("//*[text()='25']")).click();
		 Thread.sleep(2000L);
		 String dateActual= driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value");
		 Assert.assertEquals("12/25/2019", dateActual);
		 System.out.println(dateActual);
		}
	
	public void selectDateAndTime()
	{
		driver.findElement(By.id("dateAndTimePickerInput")).click();
		
		while ((driver.findElement(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']")).
				 getText().equalsIgnoreCase("December 2019"))==false)
		{
			driver.findElement(By.cssSelector("button[aria-label='Previous Month']")).click();
		}
		driver.findElement(By.xpath("//*[text()='21']")).click();
		
		
	}
	
	

}
