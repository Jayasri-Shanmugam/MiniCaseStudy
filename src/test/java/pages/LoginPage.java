package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath="//a[@href='#/login']")
	
    WebElement login_btn;
	
    @FindBy(xpath="//input[@name='email']")
    
    WebElement email;
    
    @FindBy(xpath="//input[@name='password']")
    
    WebElement password;
    
    @FindBy(xpath="//button[contains(text(),'Login')]")
    
    WebElement loginbtn;
    
    public LoginPage(WebDriver driver)
    
    {
    	
		PageFactory.initElements(driver,this);
		
	}
    
    public void loginTest(String strmail,String strpassword)
    
    {
  	
  	  login_btn.click();
  	  
  	  email.sendKeys(strmail);
  	  
  	  password.sendKeys(strpassword);
  	  
  	  loginbtn.click();
  	  
   }
}
