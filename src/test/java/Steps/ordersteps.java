package Steps;
import java.util.List;
import java.util.Map;
import Base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.Order;
import pages.Personalinfo;
import pages.Signin;

public class ordersteps extends BaseUtil {
	
	Signin creden;
	Order shop;
	Personalinfo prsn;

	 public ordersteps() {
	  
	    }

	@Given("user is navigated to automationpractise url")
	public void user_is_navigated_to_automationpractise_url() {
		BaseUtil.Driver.navigate().to("http://automationpractice.com");
	}

	@And("registered user should be able to login successfully")
	public void registered_user_should_be_able_to_login_successfully() throws InterruptedException {
		creden = new Signin(BaseUtil.Driver);
		creden.login(); 
	}

	@When("user orders Tshirt via Tshirt tab")
	public void user_orders_tshirt_via_tshirt_tab() throws InterruptedException {
		shop = new Order(BaseUtil.Driver);
		shop.tshirt();  
	}

  @And("Click on proceed to checkout button for further processing")
   public void click_on_proceed_to_checkout_button_for_further_processing() {
   shop = new Order(BaseUtil.Driver);
   shop.chkout();
	}

  @And("verify details in summary and signed terms & conditions")
  public void verify_details_in_summary_and_signed_terms_conditions() {
		shop = new Order(BaseUtil.Driver);
 		shop.sumry_verify();
 		shop.adrs_verify();
 	    shop.shipping_verify();

    }

 @And("Make a payment and click on Confirm my order")
   public void make_a_payment_and_click_on_confirm_my_order() {
		shop = new Order(BaseUtil.Driver);
		shop.payment();
	   
  }

  @Then("^User should be able to view the (.*) in Order history$")
  public void user_should_be_able_to_view_the_order_in_order_history(String orderref) {
    shop = new Order(BaseUtil.Driver);
    shop.order_verify(orderref);
   }

 @When("user navigate to My personal information section")
 public void user_clicks_on_my_personal_information_section() {
  prsn = new Personalinfo(BaseUtil.Driver);
  BaseUtil.Driver.getPageSource().contains("My personal information");
}

  @Then("user should able to update below firstnames")
  public void user_should_able_to_update_the_firstname(DataTable dataTable) {
     prsn = new Personalinfo(BaseUtil.Driver);
    List<Map<String,String>> user= dataTable.asMaps(String.class,String.class);
  for(Map<String,String> e : user)
  {
 prsn.save(e.get("firstname"));
 }
		
}
}
