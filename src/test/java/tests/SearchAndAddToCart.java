package tests;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SearchAndAddToCartPage;
import pages.WelcomePage;
public class SearchAndAddToCart extends BaseClass
{
	@Test
	public void search() throws InterruptedException
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
		
		SearchAndAddToCartPage scp=new SearchAndAddToCartPage(driver);
		scp.search("sofas");
		Thread.sleep(5000);
		scp.firstSofa();
		Thread.sleep(5000);
		scp.addToCart();
		Thread.sleep(5000);
		scp.logout();
		Thread.sleep(2000);
	}
}
