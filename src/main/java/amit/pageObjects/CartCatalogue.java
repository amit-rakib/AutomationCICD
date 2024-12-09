package amit.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amit.AbstractComponents.AbstractComponents;

public class CartCatalogue extends AbstractComponents{
	
	WebDriver driver;
	
	public CartCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}

	//List<WebElement> cartProducts = driver.findElements(By.xpath("(//div[@class='cartSection'])/h3"));
	//boolean matched = cartProducts.stream().allMatch(p -> p.getText().equalsIgnoreCase(productName));

	//Assert.assertTrue(matched);
    
	//driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
	
	
	@FindBy(xpath="(//div[@class='cartSection'])/h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement checkout;
	
	
	public  boolean matchCartProduct(String productName) {
		boolean matched = cartProducts.stream().allMatch(p -> p.getText().equalsIgnoreCase(productName));
        return matched;
	}

	
	public OrderCatalogue checkOut() {
		checkout.click();
		OrderCatalogue orderCatalogue = new OrderCatalogue(driver);
      return orderCatalogue;
	}
	
	
	
	

}
