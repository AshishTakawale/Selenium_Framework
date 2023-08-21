package RahualShettyAcademy.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standaloneTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String productName= "IPHONE 13 PRO";
		
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		driver.findElement(By.id("userEmail")).sendKeys("atakawale57@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Bingo#321");
		driver.findElement(By.id("login")).click();
		
		List <WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-child")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner")));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//li/button[@type='button']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
