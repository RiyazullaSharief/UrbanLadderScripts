package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
public class DeliveryDatePage
{
	public WebDriver driver;
	
	@FindBy(xpath="//img[@class='logo-img']")
	private WebElement homepage;
	
	@FindBy(xpath="//div[@class='delivery-date']")
	private WebElement deliveryDate;
	
	@FindBy(xpath="(//span[@class='header-icon'])[2]")
	private WebElement cart;
	
	@FindBy(xpath="//ul[@id='account-logged-in']/li[3]")
	private WebElement menu;
	
	@FindBy(xpath="//span[.='Logout']")
	private WebElement logoutLink;
	
	public DeliveryDatePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void cart() throws InterruptedException
	{
		homepage.click();
		Thread.sleep(5000);
		cart.click();
	}
	
	
	public void deliveryDate()
	{
		String dd=deliveryDate.getText();
		Reporter.log("Item will be delivered by: "+dd, true);
	}
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(menu).perform();
		logoutLink.click();
		System.out.println("Logged out successfully...!!");
	}
}
