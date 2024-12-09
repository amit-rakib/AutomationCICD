package amit.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amit.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}

	//String text = driver.findElement(By.cssSelector("td[align='center'] h1")).getText();
    @FindBy(css="td[align='center'] h1")
    WebElement text;
    
    public String confirmText() {
    String	message = text.getText();
    	return message;
    }
	
	
	
	

}
