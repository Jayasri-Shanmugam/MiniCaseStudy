package testScripts;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import base.TestBase;
import pages.DeleteArticlePage;
import pages.LoginPage;
import pages.NewArticlePage;
import pages.UpdateArticlePage;

import commonUtils.Utility;

public class ArticleTest
{
	
    WebDriver driver;

    ExtentReports extentReports;
    
    ExtentSparkReporter spark;
    
    ExtentTest extentTest;
	
	LoginPage loginPage;
	
	NewArticlePage newArticlePage;
	
	UpdateArticlePage updateArticle;
	
	DeleteArticlePage deleteArticle;
	
	public ArticleTest() 
	{
		TestBase.initDriver();
		
		driver=TestBase.getDriver();
		
		loginPage=new LoginPage(driver);
		
		newArticlePage=new NewArticlePage(driver);
		
		updateArticle=new UpdateArticlePage(driver);
		
		deleteArticle=new DeleteArticlePage(driver);
		
	}
	
@BeforeTest

public void setupExtent()
{
	extentReports=new ExtentReports();
	
	spark=new ExtentSparkReporter("test-output/SparkReport.html")
			.viewConfigurer()
			.viewOrder()
			.as(new ViewName[] {
					ViewName.DASHBOARD,
					ViewName.TEST,
					ViewName.AUTHOR,
					ViewName.DEVICE,
					ViewName.LOG
					}).apply();
	extentReports.attachReporter(spark);
}
@BeforeTest
	public void setup()
    {
	
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
		
	}
@Test(priority=1)
public void InvalidloginTest() 
{
	extentTest=extentReports.createTest("Log In Test");
	
	loginPage.InValidLoginTest("happymeshri@gmail.com","Jai@2");
	
	Assert.assertEquals(loginPage.checkInValidLogin(),"Wrong email/password combination");
	
}


	@Test(priority=2)
	public void validloginTest() 
	{
		extentTest=extentReports.createTest("Log In Test");
		
		loginPage.ValidLoginTest("happymeshri@gmail.com","Jai@28");
		
		Assert.assertEquals(loginPage.checkValidLogin(),"Jai");
		
	}
	@Test(priority=3)
	public void duplicateArticleTest() {
		 extentTest=extentReports.createTest("Duplicate Article Test");
		newArticlePage.newArticle("Sample","Test","Manual Test","Test");
		Assert.assertEquals(newArticlePage.duplicateArticleValidate(),"Title already exists..");
	}
	
	@Test(priority=4)
	public void newArticle() 
	{
		extentTest=extentReports.createTest("New Article Test");
		
		newArticlePage.newArticle("Amazon S3","Simple Storage Service","S3 is a storage service.Objects are stored inside a Bucket.Buckets are containers to store object.","Amazon");
		
		String headerName=driver.findElement(By.xpath("//h1[contains(text(),'Amazon S3')]")).getText();
		   
		System.out.println("New Article Title-"+headerName);
		   
		Assert.assertEquals(headerName,"Amazon S3");
	}
	
	@Test(priority=5)
	public void update_Article()
	{
		extentTest=extentReports.createTest("Update Article Test");
		
		updateArticle.update("Amazon Services","Amazon S3","Simple Storage Service");
		
		String headerName=driver.findElement(By.xpath("//h1[contains(text(),'Amazon Services')]")).getText();
		   
		System.out.println("Updated Article Title-"+headerName);
		   
		Assert.assertEquals(headerName,"Amazon Services");
	}
	
	@Test(priority=6)
	public void delete_Article()
	{
		extentTest=extentReports.createTest("Delete Article Test");
	
		deleteArticle.deleteArticle();
		
		Assert.assertEquals(deleteArticle.deleteCheck(), "Articles not available.");
	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		extentTest.assignAuthor("AutomationTester1-jaya")
		
		.assignCategory("Regression")
		
		.assignDevice(System.getProperty("os.name"))
		
		.assignDevice(System.getProperty("os.version"));
		
		if(ITestResult.FAILURE==result.getStatus())
			
		{
			extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			
			String strPath=Utility.getSreenshotPath(driver);
			
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
			
		}
		


		//driver.close();
	}
	@AfterTest
	public void finishExtent() 
	{
		
		extentReports.flush();
		
	}
	
}
