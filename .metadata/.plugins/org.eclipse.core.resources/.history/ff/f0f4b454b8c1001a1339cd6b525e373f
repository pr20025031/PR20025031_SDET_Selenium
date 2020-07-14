package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Droppable {
	
	public WebDriver driver;
	Actions a;
	
	public Droppable(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToDroppable(String droppableUrl) throws InterruptedException
	{
		driver.get(droppableUrl);
		
		/*This approach og navingating from homepage didn't work out
		driver.findElement(By.xpath("(//div[@class='category-cards']/div)[5]")).click();
		Thread.sleep(1000L);
		Actions a = new Actions(driver);
		WebElement toDroppable=driver.findElement(By.xpath("//div[@class='element-list collapse show'] //li[@id='item-3']"));
		
		a.moveToElement(toDroppable).click().build().perform();*/
	}
	

	
	public WebElement source()
	{
		return driver.findElement(By.id("draggable"));
	}
	
	public WebElement target()
	{
		return driver.findElement(By.id("droppable"));
	}
	
	public void dragAndDrop()
	{
		a=new Actions(driver);
		a.dragAndDrop(source(), target()).build().perform();
		String actualText = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
		
		Assert.assertEquals("Dropped!", actualText);
		System.out.println(actualText);
		
	}
	
	
	

}
