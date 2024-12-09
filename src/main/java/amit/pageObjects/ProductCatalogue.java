package amit.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import amit.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".card"));
	
	@FindBy(css=".card")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement byAnime;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	By findBy = By.cssSelector(".card");
	By byName = By.cssSelector("b");
	By byCart = By.cssSelector(".btn.w-10.rounded");
	By byToast = By.id("toast-container");
	
	
    public List<WebElement> getProductList()
    {
    	//Thread.sleep(2000);
    	waitForElementToAppear(findBy);
    	return products;
    }
    
    
    //WebElement prod = products.stream()
	//		.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)

	//		).findFirst().orElse(null);
    
    public WebElement getProductByName(String productName, List<WebElement> products)
    {
    	WebElement prod = products.stream()
    			.filter(product -> product.findElement(byName).getText()
    					.equals(productName)).findFirst().orElse(null);
    	
    	return prod;
    }
    
    //		prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
    //		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));


    
    public void addProductToCart( WebElement prod) 
    {
    	
    	
    	prod.findElement(byCart).click();
    	
    	
    	waitForElementToAppear(byToast);
    	waitForElementToDisappear(byAnime);
    	
    }
    //		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

    
    public CartCatalogue goToCart() {
    	cart.click();
		CartCatalogue cartCatalogue = new CartCatalogue(driver);
       return cartCatalogue;
    }
    
	
	

}
