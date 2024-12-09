package amit;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import amit.TestComponents.BaseTest;
import amit.TestComponents.Retry;
import amit.pageObjects.CartCatalogue;
import amit.pageObjects.ProductCatalogue;

public class ErrorValidations extends BaseTest{

         @Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
         
         public void LoginErrorValidation() throws IOException, InterruptedException {
	
		 landingPage.loginApplication("amitrakib@gmail.com", "Amit11720@");
		 AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		 
         
	}
         @Test
		  public void ProductErrorValidation() throws IOException, InterruptedException{
			String productName = "ZARA COAT 3";
		//	String countryName = "India";
			
			
			ProductCatalogue productCatalogue = landingPage.loginApplication("amitrakib@gmail.com", "Amit1120@");			 Thread.sleep(1000);


			List<WebElement> products = productCatalogue.getProductList();

			WebElement prod = productCatalogue.getProductByName(productName, products);
			productCatalogue.addProductToCart(prod);

			CartCatalogue cartCatalogue = productCatalogue.goToCart();

			boolean matched = cartCatalogue.matchCartProduct("ZARA COAT 33");
			AssertJUnit.assertFalse(matched);
		}
		

}
