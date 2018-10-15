package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SearchPage;
import pages.WelcomePage;

public class Search extends BaseClass
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
		
		SearchPage scp=new SearchPage(driver);
		scp.search("beds");
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		lp.logout();
		Thread.sleep(2000);
	}
}
