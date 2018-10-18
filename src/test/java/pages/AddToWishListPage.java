package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddToWishListPage
{
	int i=1;
	public WebDriver driver;
		
	@FindBy(xpath="//input[@id='search']")
	private WebElement searchbox;
	
	@FindBy(xpath="//button[@id='search_button']")
	private WebElement searchbutton;
	
	@FindBy(xpath="(//div[@class='wishproduct wishblock'])[1]")
	private WebElement wishlst;
	
	@FindBy(xpath="//span[@class='header-icon-link user-profile-icon']")
	private WebElement menu;
	
	@FindBy(id="logout")
	private WebElement logoutLink;
	
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
	}
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(menu).perform();
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
			Reporter.log("Item Added to wishlist successfully...!!",true);
			i++;
		}
	}
}
