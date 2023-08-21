package RahualShettyAcademy.SeleniumFrameworkDesign;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standaloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String productName= "IPHONE 13 PRO";
		
		
		LandingPage landingpage= new LandingPage(driver);
		
		
	
		landingpage.goTo();
		landingpage.maximizeWindow();
		
		landingpage.loginPage("atakawale57@gmail.com", "Bingo#321");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ProductCatlogaue  productCatlogaue = new ProductCatlogaue(driver);
		productCatlogaue.addProductToCart(productName);
		productCatlogaue.goToCartPage();
		System.out.println("Check1");
		
		CartPage cartPage = new CartPage(driver);
		
		Boolean match =cartPage.productMatch(productName);
		System.out.println("Check");
		Assert.assertTrue(match);
		cartPage.checkoutPage();
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
