package tests;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import generic.Auto_Const;
import libraries.ExcelLibrary;
public class BaseClass implements Auto_Const
{
	public WebDriver driver;
	public ExcelLibrary xlib;
	@BeforeClass
	public void launchApplication()
	{
		xlib=new ExcelLibrary();
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		driver=new ChromeDriver();
		driver.get("https://www.urbanladder.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void captureScreenshot(String testName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File out=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(testName+".jpg");
		try
		{
			FileUtils.copyFile(out,dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void close()
	{
		/*String testName=iresult.getTestClass().getName();
		if(iresult.getStatus()==2)
		{
			captureScreenshot(testName);
		}*/
		driver.close();
	}
}
