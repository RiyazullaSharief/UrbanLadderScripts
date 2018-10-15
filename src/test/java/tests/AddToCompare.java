package tests;
import org.testng.annotations.Test;

import pages.AddToComparePage;
import pages.LoginPage;
import pages.WelcomePage;
public class AddToCompare extends BaseClass
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
		
		AddToComparePage atcp=new AddToComparePage(driver);
		atcp.coffeeTables();
		Thread.sleep(2000);
		atcp.compare();
		Thread.sleep(2000);
		atcp.compare_Price();
		Thread.sleep(2000);
		atcp.logout();
	}
}
