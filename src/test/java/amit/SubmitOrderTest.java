package amit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import amit.AbstractComponents.AbstractComponents;
import amit.TestComponents.BaseTest;
import amit.pageObjects.CartCatalogue;
import amit.pageObjects.ConfirmationPage;
import amit.pageObjects.LandingPage;
import amit.pageObjects.OrderCatalogue;
import amit.pageObjects.OrderPage;
import amit.pageObjects.ProductCatalogue;
import junit.framework.Assert;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	String countryName = "India";

	@Test(dataProvider="getData", groups= {"Purchase"})

	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		//String email, String password, String productName)
		String email = input.get("email");
		String password = input.get("password");
		String productName = input.get("product");

		ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);
		Thread.sleep(1000);

		List<WebElement> products = productCatalogue.getProductList();

		WebElement prod = productCatalogue.getProductByName(productName, products);
		productCatalogue.addProductToCart(prod);

		CartCatalogue cartCatalogue = productCatalogue.goToCart();

		boolean matched = cartCatalogue.matchCartProduct(productName);

		Assert.assertTrue(matched);

		OrderCatalogue orderCatalogue = cartCatalogue.checkOut();

		orderCatalogue.selectCountry(countryName);
		ConfirmationPage cp = orderCatalogue.placeOrder();
		String text = cp.confirmText();

		Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));

	}
	
	//To verify ZARA COAT £ is displaying in orders page
	
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("amitrakib@gmail.com", "Amit1120@");
		OrderPage orderPage = productCatalogue.goToOrdersPage();
	Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}


	
	//Extends Reports
	
	//DataProvider 
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "amitrakib@gmail.com");
//		map.put("password", "Amit1120@");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "anshika@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("product", "ADIDAS ORIGINAL");
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//amit//Data//PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		//return new Object[][] {{"amitrakib@gmail.com", "Amit1120@", "ZARA COAT 3"}, {"anshika@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}};
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
