package amit.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amit.AbstractComponents.AbstractComponents;

public class OrderCatalogue extends AbstractComponents{
	
	WebDriver driver;
	
	public OrderCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}

	//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
	
	//List<WebElement> country = driver.findElements(By.cssSelector(".ta-item"));
//WebElement count = country.stream().filter(
		//	c->c.findElement(By.tagName("span")).getText().equalsIgnoreCase("India")
	//		).findFirst().orElse(null);
//	count.click();
	
//	driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryInput;
	
	@FindBy(css=".ta-item")
	List<WebElement> country;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement order;
	
	public void selectCountry(String countryName) {
		countryInput.sendKeys("ind");
		
		WebElement count = country.stream().filter(
				c->c.findElement(By.tagName("span")).getText().equalsIgnoreCase(countryName)
				).findFirst().orElse(null);
		count.click();
	}
	
	public ConfirmationPage placeOrder() {
		order.click();
		ConfirmationPage cp = new ConfirmationPage(driver);
      return cp;
	}

}
