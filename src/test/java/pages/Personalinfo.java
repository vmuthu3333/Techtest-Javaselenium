package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Personalinfo {

	@FindBy(how= How.XPATH, using ="//*[@id=\"center_column\"]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")
	WebElement btn_pinfo;
		
	@FindBy(how= How.XPATH, using ="//*[@id=\"firstname\"]")
	WebElement txt_frstname;
	
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"old_passwd\"]")
	WebElement txt_currentpwd;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"passwd\"]")
	WebElement txt_newpwd;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"confirmation\"]")
	WebElement txt_cfrmpwd;

	@FindBy(how= How.XPATH, using ="//*[@id=\"center_column\"]/div[1]/form[1]/fieldset[1]/div[11]/button[1]/span[1]")
	WebElement btn_save;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"center_column\"]/ul[1]/li[1]/a[1]/span[1]")
	WebElement btn_bcktoacc;
	
	 WebDriver driver;
	public Personalinfo(WebDriver driver)
	{
	
    	this.driver=driver;
		PageFactory.initElements(driver,this);
	}	
	
	public void upate_personalinfo()
	{
		
	
	}
	
	public void save(String firstname)
	{
		btn_pinfo.click();
		txt_frstname.clear();
		txt_frstname.sendKeys(firstname);
		txt_currentpwd.sendKeys("Sunday56");
		txt_newpwd.sendKeys("Sunday56");
		txt_cfrmpwd.sendKeys("Sunday56");
		btn_save.click();
		btn_bcktoacc.click();
	}
}
