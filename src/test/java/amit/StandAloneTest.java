package amit;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amit.pageObjects.LandingPage;
import junit.framework.Assert;

public class StandAloneTest  {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
         driver.manage().window().maximize();
		String productName = "ZARA COAT 3";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://rahulshettyacademy.com/client/");
		

		//driver.findElement(By.id("userEmail")).sendKeys("amitrakib@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Amit1120@");
		//driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card")));
		Thread.sleep(1000);
		List<WebElement> products = driver.findElements(By.cssSelector(".card"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)

				).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();

		// Explecitwait

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ng-animating")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.xpath("(//div[@class='cartSection'])/h3"));
		boolean matched = cartProducts.stream().allMatch(p -> p.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(matched);
        
		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		
		List<WebElement> country = driver.findElements(By.cssSelector(".ta-item"));
	WebElement count = country.stream().filter(
				c->c.findElement(By.tagName("span")).getText().equalsIgnoreCase("India")
				).findFirst().orElse(null);
		count.click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
				
		String text = driver.findElement(By.cssSelector("td[align='center'] h1")).getText();
		
		System.out.println(text);
		
		Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();
		
	}

}












