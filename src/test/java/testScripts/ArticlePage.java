package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DeleteArticlePage;
import pages.LoginPage;
import pages.NewArticlePage;
import pages.UpdateArticlePage;

public class ArticlePage {
WebDriver driver;
	
	LoginPage loginPage;
	
	NewArticlePage newArticlePage;
	
	UpdateArticlePage updateArticle;
	
	DeleteArticlePage deleteArticle;
	
	public ArticlePage() 
	{
		TestBase.initDriver();
		
		driver=TestBase.getDriver();
		
		loginPage=new LoginPage(driver);
		
		newArticlePage=new NewArticlePage(driver);
		
		updateArticle=new UpdateArticlePage(driver);
		
		deleteArticle=new DeleteArticlePage(driver);
		
	}
	
@BeforeTest

	public void setup()
    {
	
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
		
	}

	@Test(priority=1)
	public void loginTest() 
	{
		
		loginPage.loginTest("happymeshri@gmail.com","Jai@28");
	}
	
	@Test(priority=2)
	public void newArticle() 
	{
		
		newArticlePage.newArticle();
	}
	
	@Test(priority=3)
	public void update_Article()
	{
		
		updateArticle.update();
	}
	
	@Test(priority=4)
	public void delete_Article()
	{
	
		deleteArticle.deleteArticle();
	}
	
}
