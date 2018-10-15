package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage
{
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='search']")
	private WebElement searchbox;
	
	@FindBy(xpath="//button[@id='search_button']")
	private WebElement searchbutton;
	
	@FindBy(xpath="(//span[.='Walton Leatherette Sofa '])[1]")
	WebElement firstSofa;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void search(String search)
	{
		searchbox.sendKeys(search);
		searchbutton.click();
	}
}
