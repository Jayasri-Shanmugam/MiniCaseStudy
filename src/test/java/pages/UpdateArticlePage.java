package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

	public void update() 
	{
	         editBtn.click();
	         
	    	 articleTitle.clear();
	    	 
	    	 articleTitle.sendKeys("Amazon Services");
	    	 
	    	 articleAbout.clear();
	    	 
	    	 articleAbout.sendKeys("Amazon S3");
	    	 
	    	 textArea.clear();
	    	 
	    	 textArea.sendKeys("Simple Storage Service");
	    	 
	    	 update_btn.click();
	    	 
	    	 System.out.println("Updated Article Title-"+headerCheckBtn.getText());
	    	 
		     Assert.assertEquals(headerCheckBtn.getText(),"Amazon Services");
		    	
   } 
	 	

}
