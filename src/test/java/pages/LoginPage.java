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
    
    @FindBy(xpath="//div[contains(text(),'Jai')]")
    
    WebElement successlogin;
    
    @FindBy(xpath="//li[contains(text(),'Wrong email/password combination')]")
    WebElement invalidlogin;
    
    public LoginPage(WebDriver driver)
    
    {
    	
		PageFactory.initElements(driver,this);
		
	}
    
    public void InValidLoginTest(String strmail,String strpassword) {
      	
    	  login_btn.click();
    	  email.sendKeys(strmail);
    	  password.sendKeys(strpassword);
    	  loginbtn.click();
    	}
      public void ValidLoginTest(String strmail,String strpassword) {
        	  email.clear();
      	  email.sendKeys(strmail);
      	  password.clear();
      	  password.sendKeys(strpassword);
      	  loginbtn.click();
      	}
     public String checkValidLogin() {
      	 return successlogin.getText();
      }
   
     public String checkInValidLogin() {
  	   return invalidlogin.getText();
     }
}
