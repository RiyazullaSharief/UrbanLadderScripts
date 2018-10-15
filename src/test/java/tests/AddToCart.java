package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.AddToCartPage;
import pages.WelcomePage;
public class AddToCart extends BaseClass
{
	@Test
	public void addTocart() throws InterruptedException
	{
		String un=xlib.getExceldata("Login", 1, 0);
		String pw=xlib.getExceldata("Login", 1, 1);
		WelcomePage wp=new WelcomePage(driver);
		wp.closePopup();
		wp.verifyAppOpened("Furniture Online: Buy Home Wooden Furniture in India @ 30% OFF - Urban Ladder");
		
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000);
		lp.loginLink();
		lp.login(un,pw);
		Thread.sleep(3000);
		wp.verifyAppOpened("Furniture Online: Buy Home Wooden Furniture in India @ 30% OFF - Urban Ladder");
		Thread.sleep(5000);
		
		AddToCartPage sp=new AddToCartPage(driver);
		sp.saleLinkSofas();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2200)");	//To scroll down
		//----To scroll Up----
		/*js.executeScript("window.scrollBy(0,-250)", "");
		OR,
		js.executeScript("scroll(0, -250);");*/			//----To scroll Up----
		Thread.sleep(5000);
		sp.firstItem();
		Thread.sleep(5000);
		sp.addToCart();
		Thread.sleep(5000);
		js.executeScript("scroll(0,-250);");
		Thread.sleep(2000);
		sp.logout();	
	}
}
