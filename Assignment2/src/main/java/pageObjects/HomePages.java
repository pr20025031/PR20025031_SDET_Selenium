package pageObjects;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.Base;

public class HomePages extends Base {
	
	@Test // (dataProvider= "getUrl_Uk")
	public void goToHomePage_Uk(String uk_url) throws IOException {
		driver = initializedDriver();
		driver.get(uk_url);

		HomePage_UK hp = new HomePage_UK(driver);
		hp.clickonRegister().click();
	}
	
	@Test //(dataProvider= "getUrl_Germany")
	public void goToHomePage_Germany(String germany_url) throws IOException {
		driver = initializedDriver();
		driver.get(germany_url);

		HomePage_Germany hp = new HomePage_Germany(driver);
		hp.clickonRegister().click();
	}
	
	@Test //(dataProvider= "getUrl_Germany")
	public void goToHomePage_Spain(String spain_url) throws IOException {
		driver = initializedDriver();
		driver.get(spain_url);

		HomePage_Spain hp = new HomePage_Spain(driver);
		hp.clickonRegister().click();
	}
	

}
