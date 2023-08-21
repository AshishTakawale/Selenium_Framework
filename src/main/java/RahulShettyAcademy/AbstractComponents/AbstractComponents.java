package RahulShettyAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	public WebDriver driver;
	

	
	@FindBy (xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;

	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}


	public void waitForElementToAppear(By findBy) 
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	 
	public void waitForElementToDisappear(By findBy) throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(11));
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy)); 
	
		
	 }
	public void waitForElementToBeClicable(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(11));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	
	public void goToCartPage()
	{
		cartButton.click();
	}
	
	
	

}
