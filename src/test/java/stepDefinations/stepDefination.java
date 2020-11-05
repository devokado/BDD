package stepDefinations;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.List;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination {

	@Given("^validate the browser$")
	public void validate_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  System.out.println("deciding the browser to open");
	}

	@When("^Browser is triggered$")
	public void browser_is_triggered() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("browser is triggered");
	}

	@Then("^check if browser is displayed$")
	public void check_if_browser_is_started() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("check if browser is displayed");
	}
	
	@Given("^User is on NetBanking landing page$")
	public void user_is_on_netbanking_landing_page() throws Throwable {
		// code to navigate to login url
		System.out.println("navigated to login url");
	}
	@Given("^User is on NetBanking sign up page$")
	public void user_is_on_NetBanking_sign_up_page() throws Throwable {
	    // code to navigate to sign up url
		System.out.println("navigated to sign up url");
	}

	@When("^User login into application with username and password$")
	public void user_login_into_application_with_username_and_password() throws Throwable {
		// code to login
		System.out.println("Logged in success");
	}

	@When("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_login_into_application_with_something_and_password_something(String strArg1, String strArg2)
			throws Throwable {

		System.out.println(strArg1);
		System.out.println(strArg2);
	}

	@When("^User sign up with following details$")
	public void user_sign_up_with_following_details(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		 List<List<String>> obj = arg1.raw();
		 for (String list : obj.get(0)) {
			 System.out.println(list);
			
		}
			 
	}
	
	@When("^User login in to application with (.+) and password (.+)$")
    public void user_login_into_application_with_and_password(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(username);
	   System.out.println(password);
	}


	@Then("^Home page is populated$")
	public void home_page_is_populated() throws Throwable {
		// home page validation
		System.out.println("Validated home page");
	}

	@Then("^Cards displayed are \"([^\"]*)\"$")
	public void cards_displayed_are(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(arg1);
	}

}