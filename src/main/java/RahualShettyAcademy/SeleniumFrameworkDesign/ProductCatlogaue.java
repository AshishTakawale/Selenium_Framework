package RahualShettyAcademy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class ProductCatlogaue extends AbstractComponents {
	WebDriver driver;
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-child");
	By productToast = By.id("toast-container");
	By animationScreen = By.xpath("//ngx-spinner");
	
	@FindBy (xpath="//ngx-spinner")
	WebElement spinner;
	
	@FindBy (xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	

	public ProductCatlogaue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(css=".col-lg-4")
		List <WebElement> Products;
		
		
		
		public List<WebElement> getProductList()

		{
			waitForElementToAppear(productBy);
			return Products;
		}
		
		public WebElement findProductByName(String productName)
		{
			WebElement prod = getProductList().stream().filter
			(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			return prod;
			
		}
		public void addProductToCart(String productName) throws InterruptedException
		{
			 WebElement prod = findProductByName(productName);
			 
			prod.findElement(addToCart).click();
			waitForElementToAppear(productToast);
			waitForElementToDisappear(animationScreen);
		}
		

		
			
		}
		
		
	




