package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticeForm {
	
	public WebDriver driver;

	public AutomationPracticeForm(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void navigateToAutomationPracticeForm() {
		 driver.findElement(By.xpath("(//div[@class='category-cards']/div)[2]")).click();
		 driver.findElement(By.xpath("//li[@class='btn btn-light '] //span[text()='Practice Form']")).click();
		
	}
	
	public WebElement firstName()
	{
		
		return driver.findElement(By.id("firstName")) ;
	}
	
	public WebElement lastName()
	{
		return driver.findElement(By.id("lastName")) ;
	}
	
	public WebElement emailId()
	{
		return driver.findElement(By.id("userEmail"));
	}
	
	public WebElement selectGender(String reqGender)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		if(reqGender.equals("Male"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gender-radio-1']")));
			return driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		}
		else if(reqGender.equals("Female"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gender-radio-2']")));
			return driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gender-radio-3']")));
			return driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
		}
		
	}
	
	public WebElement mobileNumber()
	{
		return driver.findElement(By.cssSelector("[placeholder='Mobile Number']"));
	}
	
	public void enterBirthDate(String Year, String Month, String date)
	{
		driver.findElement(By.id("dateOfBirthInput")).click();
		
		WebElement selectYear= driver.findElement(By.cssSelector("[class='react-datepicker__year-select']"));
		
		Select sYear= new Select(selectYear);
		sYear.selectByValue(Year);;
		
		WebElement selectMonth= driver.findElement(By.cssSelector("[class='react-datepicker__month-select']"));
		
		Select sMonth = new Select(selectMonth);
		sMonth.selectByVisibleText(Month);
		
		driver.findElement(By.xpath("//div[text()='"+date+"']")).click();
		
	}
	
	public void selectSubjects() throws InterruptedException
	{
		Actions a = new Actions(driver);
		WebElement subjects= driver.findElement(By.id("subjectsContainer"));
		a.moveToElement(subjects).click().sendKeys("Maths").sendKeys(Keys.ENTER).build().perform();
		
//		Alternative approach
//		WebElement subjects1= driver.findElement(By.id("subjectsContainer"));
//		subjects1.sendKeys("Maths");
//		//subjects.sendKeys(Keys.ARROW_DOWN);
//		subjects1.sendKeys(Keys.ENTER);
		
	}
	
	public void selectHobbies()
	{
		List<WebElement> hobbies = driver.findElements(By.xpath("//div[@class='custom-control custom-checkbox custom-control-inline']"));
		
		for(int i=0; i<hobbies.size(); i++)
		{
			hobbies.get(i).click();
		}
	}
	
	public WebElement currentAddress()
	{
		return driver.findElement(By.id("currentAddress"));
	}
	
	public void selectState(String state)
	{
		Actions a = new Actions(driver);
		WebElement selectState = driver.findElement(By.xpath("//div[@id='state']/div/div[1]"));
		a.moveToElement(selectState).click().sendKeys(Keys.ARROW_DOWN.ENTER).build().perform();
		
	}
	

	

	
	
}
