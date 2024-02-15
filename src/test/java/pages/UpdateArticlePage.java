package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

public class UpdateArticlePage 
{
	
	@FindBy(xpath="(//a[contains(text(),' Edit Article')])[1]")
	
    WebElement editBtn;
    
    @FindBy(xpath="//input[@placeholder='Article Title']")
    
    WebElement articleTitle;
    
    @FindBy(xpath="//input[@class='form-control ' and @name='description']")
    
    WebElement articleAbout;
    
    @FindBy(xpath="//textArea[@rows='8']")
    
    WebElement textArea;
    
    @FindBy(xpath="//input[@placeholder='Enter tags']")
     
    WebElement enterTags;
     
    @FindBy(xpath="//button[contains(text(),'Update Article')]")
    
    WebElement update_btn;
     
    @FindBy(xpath="//h1[contains(text(),'Amazon Services')]")
     
    WebElement headerCheckBtn;
     
     public  UpdateArticlePage(WebDriver driver) 
     
     {
    	 
    	 PageFactory.initElements(driver,this);
    	 
     }

	public void update(String article_title,String article_about,String text_area) 
	{
	         editBtn.click();
	         
	    	 articleTitle.clear();
	    	 
	    	 articleTitle.sendKeys(article_title);
	    	 
	    	 articleAbout.clear();
	    	 
	    	 articleAbout.sendKeys(article_about);
	    	 
	    	 textArea.clear();
	    	 
	    	 textArea.sendKeys(text_area);
	    	 
	    	 update_btn.click();
	    	 
	    	
		    	
   } 
	 	

}
