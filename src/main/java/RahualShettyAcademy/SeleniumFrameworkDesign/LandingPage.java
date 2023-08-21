package RahualShettyAcademy.SeleniumFrameworkDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
		@FindBy(id="userEmail")
		WebElement UserEmail;
		
		@FindBy(id="userPassword")
		WebElement Password;
		
		@FindBy(id="login")
		WebElement Submit;

	

	public void loginPage(String userName, String PasswordT) 
	{
	
	UserEmail.sendKeys(userName);
	Password.sendKeys(PasswordT);
	Submit.click();
	
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
}



