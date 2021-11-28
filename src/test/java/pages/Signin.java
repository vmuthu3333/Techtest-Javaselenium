package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Signin {
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"header\"]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]")
	WebElement lnk_sign;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"email\"]")
	WebElement txt_Emailaddress;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"passwd\"]")
	WebElement txt_pwd;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"SubmitLogin\"]")
	WebElement btn_sign;
	
	WebDriver driver;
	public Signin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

public void login() throws InterruptedException
{
	lnk_sign.click();
	Thread.sleep(200);
	txt_Emailaddress.sendKeys("testng@gmail.com");
	txt_pwd.sendKeys("Sunday56");
	btn_sign.click();
	
}
	
}
