package amit.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amit.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}

	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	
	//PageFactory
	// new way of writing 
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public  ProductCatalogue loginApplication(String email, String pass)
	{
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;

	}
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
	    return errorMessage.getText();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");

	}
	
	

}
