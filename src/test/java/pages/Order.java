package pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;


public class Order {
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"block_top_menu\"]/ul[1]/li[3]/a[1]")
	WebElement lnk_tshirt;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"layer_cart\"]/div[1]/div[1]/span[1]")
	WebElement btn_cart;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"center_column\"]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]/span[1]")
	WebElement btn_chkout;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a[1]/span[1]")
	WebElement btn_prcdchkout;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"center_column\"]/p[2]/a[1]/span[1]")
	WebElement btn_sumrychkout;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"center_column\"]/form[1]/p[1]/button[1]/span[1]")
	WebElement btn_addrschkout;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"cgv\"]")
	WebElement chk_term;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"form\"]/p[1]/button[1]/span[1]")
	WebElement btn_shpchkout;
	
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div[1]/p[1]/a[1]")
	WebElement btn_pymt;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"cart_navigation\"]/button[1]/span[1]")
	WebElement btn_confirm_order;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"center_column\"]/p[1]/a[1]")
	WebElement btn_back_order;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"order-list\"]/tbody[1]/tr[1]/td[7]/a[1]/span[1]")
	WebElement btn_order_detail;
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"order-list\"]/thead[1]/tr[1]/th[2]")
	WebElement txt_product_name;
	
	
	@FindBy(how= How.XPATH, using ="//*[@id=\"order-list\"]/tbody[1]/tr[1]/td[2]")
	WebElement txt_product_value;
	
	WebDriver driver;
	public Order(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void tshirt() throws InterruptedException
	{
		lnk_tshirt.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btn_cart);
		Thread.sleep(200);
		btn_chkout.click();
	}
	
	public void chkout()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btn_prcdchkout);
	}
	
	public void sumry_verify()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btn_sumrychkout);
	}
	
	public void adrs_verify()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btn_addrschkout);
	}

	public void shipping_verify()
	{
		chk_term.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btn_shpchkout);
	}
	
	public void payment()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btn_pymt);
		jse.executeScript("arguments[0].click();", btn_confirm_order);

	}
	
	@SuppressWarnings("deprecation")
	public void order_verify(String orderref)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btn_back_order);
		jse.executeScript("arguments[0].click();", btn_order_detail);
       //driver.getPageSource().contains("Faded Short Sleeve T-shirts");
       
       List<WebElement> order = driver.findElements(By.xpath("//table[@id='order-list']//tr//td[1]"));
       System.out.println(order.size());
       
       boolean companystatus=false;
       
       for(WebElement ele:order)
       {
    	   String value= ele.getText();
    	   System.out.println(value);
    	   
    	   if(value.contains(orderref))
    	   {
    		   companystatus=true;
    		   break;
    	   }
       }
    
       Assert.assertTrue("could not find",companystatus);
	}
	
}
