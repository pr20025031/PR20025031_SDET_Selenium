package olay;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage_Germany;
import pageObjects.HomePage_UK;
import pageObjects.HomePages;
import pageObjects.RegisterPage_Germany;
import pageObjects.RegisterPage_Spain;
import pageObjects.RegisterPage_UK;
import resources.Base;

public class OlayTest extends Base {
	
	@Test(dataProvider= "getRegistartionData")
	public void registerUser(String email, String password, String date, String month, String year, String uk_url, String germany_url,String spain_url, String country, String StreetAndHouseNum, String postcode, String gender, String city, String phone_number ) throws InterruptedException, IOException
	{
		new HomePages().goToHomePage_Uk(uk_url);
		
		RegisterPage_UK rp_uk = new RegisterPage_UK(driver);
		
		rp_uk.Email().sendKeys(email);
		rp_uk.Password().sendKeys(password);
		rp_uk.confirmPassword().sendKeys(password);
		rp_uk.selectDate(date);
		rp_uk.selectMonth(month);
		rp_uk.selectYear(year);
		//Thread.sleep(3000L);
		rp_uk.acceptCookies().click();
		//Thread.sleep(3000L);
		rp_uk.submit().click();
		
	
		new HomePages().goToHomePage_Germany(germany_url);
		
		RegisterPage_Germany rp_ge = new RegisterPage_Germany(driver);
		
		rp_ge.selectGender(gender).click();
		rp_ge.firstName().sendKeys("prasad");
		rp_ge.lastName().sendKeys("sarode");
		rp_ge.Email().sendKeys(email);
		rp_ge.Password().sendKeys(password);
		rp_ge.confirmPassword().sendKeys(password);
		rp_ge.selectDate(date);
		rp_ge.selectMonth(month);
		rp_ge.selectYear(year);
		rp_ge.selectCountry(country);
		rp_ge.selectStreetAndHouseNumber().sendKeys(StreetAndHouseNum);
	    rp_ge.selectPostCode().sendKeys(postcode);
	    rp_ge.selectORT().sendKeys(city);
	    rp_ge.acceptCookies().click();
	    rp_ge.checkBox().click();
	    rp_ge.submit().click();
		
	    
	    new HomePages().goToHomePage_Spain(spain_url);
	    
	    RegisterPage_Spain rp_sp = new RegisterPage_Spain(driver);
	    rp_sp.selectGender(gender).click();
	    rp_sp.firstName().sendKeys("prasad");
	    rp_sp.lastName().sendKeys("sarode");
	    rp_sp.middleName().sendKeys("Ram");
	    rp_sp.Email().sendKeys(email);
	    rp_sp.Password().sendKeys(password);
		rp_sp.confirmPassword().sendKeys(password);
		rp_sp.selectDate(date);
		rp_sp.selectMonth(month);
		rp_sp.selectYear(year);
		rp_sp.phoneNumber().sendKeys(phone_number);
	    rp_sp.acceptCookies().click();
		rp_sp.checkBox().click();
		rp_sp.submit().click();
	    
	    
	    
		
	
	}
	
	
	

		

	
	
	
	
//	@Test(dataProvider= "getData")
//	public void validateInvalidPassword(String email, int password, String date, String month)
//	{
//		RegisterPage rp = new RegisterPage(driver);
//		
//		rp.Email().sendKeys(email);
//		rp.Password().sendKeys(Integer.toString(password));
//		rp.confirmPassword().sendKeys(Integer.toString(password));
//		rp.selectDate(date);
//	
//	}
	
	@DataProvider
	public Object[][] getRegistartionData()
	{
		Random randomGen = new Random();
		
		int randomIntinMail = randomGen.nextInt();
		//int randomIntinPassword = randomGen.nextInt();
		
		Object[][] data =  new Object[1][14];
		
		data[0][0] = "username"+ randomIntinMail +"@gmail.com"; //email
		data[0][1] = "pRASAd@2512";   //password
		data[0][2] = "28";  //date
		data[0][3] = "11";  //month
		data[0][4] = "1995"; //year
		data[0][5] = "https://www.olay.co.uk/en-gb";
		data[0][6] = "https://www.olaz.de/de-de";
		data[0][7] = "https://www.olay.es/es-es";
		data[0][8] = "Deutschland";//country
		data[0][9] = "House no 11, Street 11"; //Street and house number
		data[0][10] = "14199"; //postcode
		data[0][11]= "Male";//gender
		data[0][12]="Berlin"; //ORT city
		data[0][13] ="+34912345678";//phone number 
		
		
		
		return data;
		
		//paulwalker2512@gmail.com
		//pRASAd@2512
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Random randomGen = new Random();
		
		int randomIntinMail = randomGen.nextInt();
		int randomIntinPassword = randomGen.nextInt();
		
		Object[][] data =  new Object[1][4];
		
		data[0][0] = "username"+ randomIntinMail +"@gmail.com";
		data[0][1] = randomIntinPassword;
		data[0][2] = "25";
		data[0][3] = "12";
		
		return data;
		
	}
	
	@DataProvider
	public Object[][] getUrl_Uk()
	{
		Object[][] data= new Object[1][1];
		data[0][0]= "https://www.olay.co.uk/en-gb";
		return 	data;
	}
	
	@DataProvider
	public Object[][] getUrl_Germany()
	{
		Object[][] data= new Object[1][1];
		data[0][0]= "https://www.olaz.de/de-de";
		return 	data;
	}
	
	

}
