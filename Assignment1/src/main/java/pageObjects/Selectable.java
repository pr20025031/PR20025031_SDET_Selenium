package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Selectable {
	
	public WebDriver driver;
	
	
	public Selectable(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void navigateToSelectable(String selectableUrl) throws InterruptedException
	{
		driver.get(selectableUrl);
		//I tried below approach of going from homepage >> intractions>> selectable. But it is not working
//		driver.findElement(By.xpath("(//div[@class='category-cards']/div)[5]")).click();
//		Thread.sleep(2000L);
		//driver.findElement(By.xpath("//li[@class='btn btn-light '] //span[text()='Selectable']")).click();
		
	}
	
	public void clickAndGetTextofList()
	{
		//driver.findElement(By.linkText("Selectable")).click();
		List<WebElement> itemList = driver.findElements(By.xpath("//li[@class='mt-2 list-group-item list-group-item-action']"));
		
		int numOfListitems=0;
		for(int i=0; i<itemList.size(); i++)
		{
			itemList.get(i).click();
			System.out.println(itemList.get(i).getText());
			numOfListitems++;
		}
		System.out.println(numOfListitems);
		Assert.assertEquals(4, numOfListitems);
	}
	
	public void clickAndGetTextofGrid()
	{
		driver.findElement(By.id("demo-tab-grid")).click();
		List<WebElement> itemGrid = driver.findElements(By.xpath("//li[@class='list-group-item list-group-item-action']"));
		
		for(int i=0; i<itemGrid.size(); i++)
		{
			itemGrid.get(i).click();
			System.out.println(itemGrid.get(i).getText());
		}
	}
	
	
	
	
	
	

}
