package amit.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amit.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	
	public  boolean VerifyOrderDisplay(String productName) {
		boolean matched = productNames.stream().allMatch(p -> p.getText().equalsIgnoreCase(productName));
        return matched;
	}

	

	
	
	
	

}
