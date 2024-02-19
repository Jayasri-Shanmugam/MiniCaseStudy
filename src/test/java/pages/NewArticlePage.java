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
	   
	   //@FindBy(xpath="//h1[contains(text(),'Sample')]")
	  //  WebElement checktitle;
	    
	    @FindBy(xpath="//span[contains(text(),'Title already exists.. ')]")
	    WebElement findingduplicate;
	    
	   public NewArticlePage(WebDriver driver)
	   {
		   
	 		PageFactory.initElements(driver,this);
	 		
	   }
	   
	   public void newArticle(String title,String about,String text,String tags) {
		   newArticle_btn.click();
		   articleTitle.clear();
		   articleTitle.sendKeys(title);
		   articleAbout.clear();
		   articleAbout.sendKeys(about);
		   textArea.clear();
		   textArea.sendKeys(text);
		   enterTags.clear();
		   enterTags.sendKeys(tags);
		   pub_article_btn.click();
	   }  
	   public String newArticleValidate() {
		  return headerBtn.getText();
	   }
	   public String duplicateArticleValidate() {
		   return findingduplicate.getText();
	   }
}
