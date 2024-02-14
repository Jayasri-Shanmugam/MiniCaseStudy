package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteArticlePage

{
	WebDriver driver;
	
    @FindBy(xpath = "//button[@class='btn btn-sm'][1]")
	
	WebElement deleteBtn;
    
	 public DeleteArticlePage(WebDriver driver) 
	 
	 {
		 this.driver=driver;
		 
	 	 PageFactory.initElements(driver,this);
	 	 
	 }
	 
	 public void deleteArticle()
		{
			deleteBtn.click();
			
			Alert alert=driver.switchTo().alert();
			
			Assert.assertEquals(alert.getText(), "Want to delete the article?");
			
			alert.accept();
 
		}
 
}
