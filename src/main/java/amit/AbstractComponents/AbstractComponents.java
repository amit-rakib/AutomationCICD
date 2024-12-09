package amit.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amit.pageObjects.OrderPage;

public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement orderHeader;

    /**
     * Wait for an element to appear in the DOM and be visible.
     *
     * @param findBy The locator of the element to wait for.
     */
    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
    }

    /**
     * Wait for a WebElement to appear and be visible.
     *
     * @param element The WebElement to wait for.
     */
    public void waitForWebElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for an element to disappear from the DOM or become invisible.
     *
     * @param byAnime The locator of the element to wait for.
     */
    public void waitForElementToDisappear(WebElement byAnime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(byAnime));
    }

    /**
     * Wait for a WebElement to disappear from the DOM or become invisible.
     *
     * @param element The WebElement to wait for.
     */
    public void waitForWebElementToDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(element)); // Waits for WebElement to disappear
    }

    /**
     * Navigate to the orders page.
     *
     * @return An instance of the OrderPage object.
     */
    public OrderPage goToOrdersPage() {
        orderHeader.click();
        return new OrderPage(driver);
    }
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


