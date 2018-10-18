package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
public class SearchAndAddToCartPage
{
	int i=1;
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='search']")
	private WebElement searchbox;
	
	@FindBy(xpath="//button[@id='search_button']")
	private WebElement searchbutton;
	
	@FindBy(xpath="(//span[.='Walton Leatherette Sofa '])[1]/..//span[contains(text(),'(Cappuccino)')]")
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
	public void verifyPageOpened(String expectedTitle)
	{
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		if(i==1)
		{
			Reporter.log("Sofas Page displayed successfully...!!",true);
			i++;
		}
		else if(i==2)
		{
			Reporter.log("Walton Leatherette Sofa (Cappuccino) sofa clicked successfully...!!",true);
			i++;
		}
		else if(i==3)
		{
			Reporter.log("Walton Leatherette Sofa (Cappuccino) page displayed successfully...!!", true);
			i++;
		}
		else if(i==4)
		{
			Reporter.log("Add to cart page displayed successfully...!!", true);
		}
	}
}
