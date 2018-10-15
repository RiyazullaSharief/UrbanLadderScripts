package tests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;
public class InvalidLoginLogout extends BaseClass
{
	@Test
	public void invalidLoginLogout() throws InterruptedException
	{
		String un=xlib.getExceldata("Login", 2, 0);
		String pw=xlib.getExceldata("Login", 2, 1);
		WelcomePage wp=new WelcomePage(driver);
		wp.closePopup();
		wp.verifyAppOpened("Furniture Online: Buy Home Wooden Furniture in India @ 30% OFF - Urban Ladder");
		
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000);
		lp.loginLink();
		Thread.sleep(10000);
		lp.login(un,pw);
		Thread.sleep(10000);
		
		lp.error("The email or password you entered is incorrect. Please try again.");
		Thread.sleep(5000);
		
	}
}
