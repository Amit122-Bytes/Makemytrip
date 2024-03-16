package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing {

WebDriver localdriver;
	
	public Landing(WebDriver remotedriver)
	{
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath="//input[@id='fromCity']")
	WebElement fromcity;
	
	@FindBy(xpath="//div[contains(text(),'CCU')]")
	WebElement citycode;
	
	
	public void entefromcity(String city)
	{
		fromcity.click();
		fromcity.sendKeys(city);
		citycode.click();
	}
}
