package tests;
import org.testng.annotations.Test;
import pages.WelcomePage;
public class VerifyAppOpened extends BaseClass
{
	@Test
	public void appOpenClose() throws InterruptedException
	{
		WelcomePage wp=new WelcomePage(driver);
		wp.closePopup();
		Thread.sleep(3000);
		wp.verifyAppOpened("Furniture Online: Buy Home Wooden Furniture in India @ 30% OFF - Urban Ladder");
	}
}
