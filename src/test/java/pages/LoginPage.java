package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage
{
	int i=1;
	public WebDriver driver;
	
	@FindBy(xpath="//span[@class='header-icon-link user-profile-icon']")
	private WebElement menu;
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	private WebElement loginLink;
	
	@FindBy(xpath="(//input[@id='spree_user_email'])[2]")
	private WebElement uname;
	
	@FindBy(xpath="(//input[@id='spree_user_password'])[3]")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@class='button primary']")
	private WebElement loginButton;
	
	@FindBy(id="logout")
	private WebElement logoutLink;
	
	@FindBy(xpath="//div[.='The email or password you entered is incorrect. Please try again.']")
	private WebElement errmsg;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void login(String un,String pw)
	{
		uname.sendKeys(un);
		pwd.sendKeys(pw);
		loginButton.click();	
	}
	
	public void loginLink()
	{
		Actions act=new Actions(driver);
		act.moveToElement(menu).perform();
		loginLink.click();
	}
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(menu).perform();
		logoutLink.click();
		Reporter.log("Logged out successfully...!!", true);
	}
	
	public void error(String expectedTitle)
	{
		String actualTitle=errmsg.getText();
		Assert.assertEquals(actualTitle,expectedTitle);
		Reporter.log(actualTitle,true);
	}
}
