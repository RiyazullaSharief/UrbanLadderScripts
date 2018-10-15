package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class RemoveFromCartPage
{
	public WebDriver driver;
		
	@FindBy(xpath="(//span[@class='header-icon'])[2]")
	private WebElement cart;
	
	@FindBy(xpath="(//div[@class='icofont-cross_thin'])[2]")
	private WebElement removeItem;
	
	@FindBy(xpath="//ul[@id='account-logged-in']/li[3]")
	private WebElement opt;
	
	@FindBy(xpath="//span[.='Logout']")
	private WebElement logoutLink;
	
	public RemoveFromCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void removeFromCart()
	{
		cart.click();
		removeItem.click();
		Reporter.log("Item removed from cart...!!", true);
	}
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(opt).perform();
		logoutLink.click();
		System.out.println("Logged out successfully...!!");
	}
}
