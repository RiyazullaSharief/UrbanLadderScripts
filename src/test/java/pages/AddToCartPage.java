package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AddToCartPage
{
	public WebDriver driver;
	
	@FindBy(xpath="(//span[contains(text(),'Sale')])[1]")
	private WebElement sale;
	
	@FindBy(xpath="(//span[contains(text(),'Sofas')])[1]")
	private WebElement sofas;
	
	//@FindBy(xpath="//a[@title='Barnley Single Over Queen Storage Bunkbed ']/..") //Dependent element
	//@FindBy(xpath="(//a[@class='product-details'])[5]")
	@FindBy(xpath="(//a[@class='product-details' and @title='Barnley Single Over Queen Storage Bunkbed '])[1]")
	private WebElement firstItem;
	
	@FindBy(xpath="(//button[@id='add-to-cart-button'])[1]")
	private WebElement addToCart;
	
	@FindBy(xpath="//span[@class='header-icon-link user-profile-icon']")
	private WebElement menu;
	
	@FindBy(id="logout")
	private WebElement logoutLink;
	
	public AddToCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void saleLinkSofas() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(sale).perform();
		Thread.sleep(3000);
		sofas.click();
	}
	
	public void firstItem()
	{
		firstItem.click();
	}
	
	public void addToCart()
	{
		addToCart.click();
		System.out.println("Item added to cart");
	}
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(menu).perform();
		logoutLink.click();
		System.out.println("Logged out successfully...!!");
	}
}
