package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
public class SearchAndAddToCartPage
{
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='search']")
	private WebElement searchbox;
	
	@FindBy(xpath="//button[@id='search_button']")
	private WebElement searchbutton;
	
	@FindBy(xpath="(//span[.='Walton Leatherette Sofa '])[1]")
	WebElement firstSofa;
	
	@FindBy(xpath="//button[@id='add-to-cart-button']")
	private  WebElement addToCartButton;
	
	@FindBy(xpath="//ul[@id='account-logged-in']/li[3]")
	private WebElement opt;
	
	@FindBy(xpath="//span[.='Logout']")
	private WebElement logoutLink;
	
	public SearchAndAddToCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void search(String search)
	{
		searchbox.sendKeys(search);
		searchbutton.click();
	}
	
	public void firstSofa()
	{
		firstSofa.click();
	}
	
	public void addToCart()
	{
		addToCartButton.click();
		Reporter.log("Item added to cart successfully...!!", true);
	}
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(opt).perform();
		logoutLink.click();
		System.out.println("Logged out successfully...!!");
	}	
}
