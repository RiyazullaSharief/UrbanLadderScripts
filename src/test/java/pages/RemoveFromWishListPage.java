package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
public class RemoveFromWishListPage
{
	public WebDriver driver;
	
	@FindBy(xpath="(//span[@class='header-icon'])[1]")
	private WebElement wishListIcon;
	
	@FindBy(xpath="(//div[@class='wishproduct wishblock'])[1]")
	private WebElement removeIcon;
	
	@FindBy(xpath="//span[@class='header-icon-link user-profile-icon']")
	private WebElement menu;
	
	@FindBy(id="logout")
	private WebElement logoutLink;
	
	public RemoveFromWishListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void removeFromWishList()
	{
		wishListIcon.click();
		removeIcon.click();
		Reporter.log("Item removed from wishlist successfully...!!", true);
	}
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(menu).perform();
		logoutLink.click();
	}
}
