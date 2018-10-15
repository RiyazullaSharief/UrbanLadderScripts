package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddToWishListPage
{
	public WebDriver driver;
		
	@FindBy(xpath="//input[@id='search']")
	private WebElement searchbox;
	
	@FindBy(xpath="//button[@id='search_button']")
	private WebElement searchbutton;
	
	@FindBy(xpath="(//div[@class='wishproduct wishblock'])[1]")
	private WebElement wishlst;
	
	public AddToWishListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void search(String search)
	{
		searchbox.sendKeys(search);
		searchbutton.click();
	}
	
	public void wishlist()
	{
		wishlst.click();
		Reporter.log("Item Added to wishlist successfully...!!", true);
	}
}
