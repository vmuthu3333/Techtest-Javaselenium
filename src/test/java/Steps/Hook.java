package Steps;

import org.openqa.selenium.chrome.ChromeDriver;
import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hook extends BaseUtil {
	
	  public Hook() {
	    	
	    }

	@Before
	public void setup() {
       String projectpath=System.getProperty("user.dir");
      System.out.println("project path"+projectpath);
      System.setProperty("webdriver.chrome.driver",projectpath+"/src/test/resources/drivers/chromedriver.exe");
	  BaseUtil.Driver = new ChromeDriver(); 

	}

   @After
   public void teardown() {
   BaseUtil.Driver.close();
   BaseUtil.Driver.quit();
	}	

}
