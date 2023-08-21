package RahualShettyAcademy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	public WebDriver driver;
	

	public CartPage(WebDriver driver) {
		super(driver);
		driver = this.driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(css=".cartSection h3")
	List <WebElement> CartProducts;
	@FindBy (xpath="//li/button[@type='button']")
	WebElement checkOut;
	
	
	
	public  Boolean productMatch(String productName)
	{
		Boolean match = CartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	public void checkoutPage()
	{
		System.out.println("See");
		checkOut.click();
	}

}
