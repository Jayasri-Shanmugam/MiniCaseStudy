package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

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
	   
	   public void newArticle(String article_title,String article_about,String text_area,String enter_tag)
	   
	   {
		   
		   newArticle_btn.click();
		   
		   articleTitle.sendKeys(article_title);
		   
		   articleAbout.sendKeys(article_about);
		   
		   textArea.sendKeys(text_area);
		   
		   enterTags.sendKeys(enter_tag);
		   
		   pub_article_btn.click();
		   
		   
	  }
}
