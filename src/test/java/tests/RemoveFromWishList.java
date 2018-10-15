package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.RemoveFromWishListPage;
import pages.WelcomePage;

public class RemoveFromWishList extends BaseClass
{
	@Test
	public void loginLogout() throws InterruptedException
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
		
		RemoveFromWishListPage rfwl=new RemoveFromWishListPage(driver);
		rfwl.removeFromWishList();
		Thread.sleep(3000);
		rfwl.logout();
		Thread.sleep(3000);
	}
}
