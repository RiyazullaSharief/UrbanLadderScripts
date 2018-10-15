package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
public class WelcomePage
{
	int i=1;
	public WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'Close')]")
	WebElement close;
	
	public WelcomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void closePopup()
	{
		close.click();
	}
	
	public void verifyAppOpened(String expectedTitle)
	{
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		if(i<=1)
		{
			Reporter.log("Welcome to www.urbanladder.com",true);
			i++;
		}
		else if(i>=2)
		{
			Reporter.log("Logged in successfully...!!",true);
		}
	}
}
