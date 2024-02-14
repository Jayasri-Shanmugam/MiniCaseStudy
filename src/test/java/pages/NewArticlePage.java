package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewArticlePage
{

	   @FindBy(xpath="//a[@href='#/editor']")
	
	   WebElement newArticle_btn;
	   
	   @FindBy(xpath="//input[@placeholder='Article Title']")
	   
	   WebElement articleTitle;
	   
	   @FindBy(xpath="//input[@class='form-control ' and @name='description']")
	   
	   WebElement articleAbout;
	   
	   @FindBy(xpath="//textArea[@rows='8']")
	   
	   WebElement textArea;
	   
	   @FindBy(xpath="//input[@placeholder='Enter tags']")
	    
	   WebElement enterTags;
	    
	   @FindBy(xpath="//button[@type='submit']")
	   
	   WebElement pub_article_btn;
	    
	   @FindBy(xpath="//h1[contains(text(),'Amazon S3')]")
	   
	   WebElement headerBtn;
	    
	   public NewArticlePage(WebDriver driver)
	   {
		   
	 		PageFactory.initElements(driver,this);
	 		
	   }
	   
	   public void newArticle()
	   
	   {
		   
		   newArticle_btn.click();
		   
		   articleTitle.sendKeys("Amazon S3");
		   
		   articleAbout.sendKeys("Simple Storage Service");
		   
		   textArea.sendKeys("S3 is a storage service.Objects are stored inside a Bucket.Buckets are containers to store object.");
		   
		   enterTags.sendKeys("Amazon");
		   
		   pub_article_btn.click();
		   
		   String headerName=headerBtn.getText();
		   
		   System.out.println("New Article Title-"+headerName);
		   
		   Assert.assertEquals(headerName,"Amazon S3");
	  }
}
