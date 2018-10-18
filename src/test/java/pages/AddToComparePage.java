package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
public class AddToComparePage
{
	public WebDriver driver;
	
	@FindBy(xpath="(//span[@class='topnav_itemname'])[2]")
	private WebElement living;
	
	@FindBy(xpath="//span[.='Coffee Tables']")
	private WebElement coffeeTable;
	
	//@FindBy(xpath="//span[.='Noguchi Table Replica ']/../../../a[@class='product-title-block']")
	@FindBy(xpath="//li[@class='product hovercard']/../li[1]")
	private WebElement item1;
	
	@FindBy(xpath="(//a[@class='button button-with-border add-to-compare'])[1]")
	private WebElement compare1;
	
	//@FindBy(xpath="//span[.='Kivaha 2-Seater Coffee Table Set ']/../../../a[@class='product-title-block']")
	@FindBy(xpath="//li[@class='product hovercard']/../li[2]")
	private WebElement item2;
	
	@FindBy(xpath="(//a[@class='button button-with-border add-to-compare'])[2]")
	private WebElement compare2;
	
	@FindBy(xpath="//button[@id='compare-cta']")
	private WebElement compareButton;
	
	@FindBy(xpath="(//div[@class='prop-value'])[1]")
	private WebElement price1;
	
	@FindBy(xpath="(//div[@class='prop-value'])[2]")
	private WebElement price2;
	
	@FindBy(xpath="(//button[@class='button buy-now'])[1]")
	private WebElement addToCart1;
	
	@FindBy(xpath="(//button[@class='button buy-now'])[2]")
	private WebElement addToCart2;
	
	@FindBy(xpath="//img[@class='logo-img']")
	private WebElement logo;
	
	@FindBy(xpath="//span[@class='header-icon-link user-profile-icon']")
	private WebElement menu;
	
	@FindBy(id="logout")
	private WebElement logoutLink;
	
	public AddToComparePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void coffeeTables() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(living).perform();
		Thread.sleep(3000);
		coffeeTable.click();
		Reporter.log("Coffee Tables Page is displayed...", true);
	}
	
	public void compare() throws InterruptedException
	{
		Actions act1=new Actions(driver);
		act1.moveToElement(item1).perform();
		compare1.click();
		Thread.sleep(3000);
		
		act1.moveToElement(item2).perform();
		compare2.click();
		Thread.sleep(3000);
		compareButton.click();
		Reporter.log("Compare page is displayed...", true);
	}
	
	public void compare_Price_addToCart() throws InterruptedException
	{
		String cmpPrice1=price1.getText().replaceAll("₹","").replaceAll(",","");
		double a=Double.parseDouble(cmpPrice1);
		System.out.println("Item 1 price is: ₹ "+a);
		
		String cmpPrice2=price2.getText().replaceAll("₹","").replaceAll(",", "");
		double b=Double.parseDouble(cmpPrice2);
		System.out.println("Item 2 price is: ₹ "+b);
		
		if(a<b)
		{
			Reporter.log("Item 1 is smaller...!!",true);
			addToCart1.click();
			Reporter.log("Item 1 added to cart successfully...!!",true);
		}
		else if(b<a)
		{
			Reporter.log("Item 2 is smaller...!!",true);
			addToCart2.click();
			Reporter.log("Item 2 added to cart successfully...!!",true);
		}
		else
			Reporter.log("Both the Items are having same price...!!",true);
	}

	public void logout()
	{
		logo.click();
		Actions act=new Actions(driver);
		act.moveToElement(menu).perform();
		logoutLink.click();
		Reporter.log("Logged out successfully...!!", true);
	}
}
