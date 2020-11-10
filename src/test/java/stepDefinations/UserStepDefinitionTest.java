package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import stepDefinations.AbstractSpringConfigurationTest;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import webservices.User.User;
import webservices.User.UserRepository;

@RunWith(Cucumber.class)
public class UserStepDefinitionTest  extends AbstractSpringConfigurationTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserStepDefinitionTest.class);

	private String UserName = null;
	private int UserId ;
	private String UserPassword;
	private ResponseEntity<String> response = null;
	
	@Given("^the user with user id (\\d+) and user name \"([^\"]*)\" and user password \"([^\"]*)\"$")
	public void the_user_with_user_id_and_user_name_and_user_password(int id, String name, String password)
	{
		if (logger.isInfoEnabled()) {
			logger.info("User to be saved with user id {} and user name {} user password {}", name, id, password);
		}
		this.UserName =name;
		this.UserId = id;
		this.UserPassword = password;

	}
	
	@Given("^the user saved with user id (\\d+) and user name \"([^\"]*)\" and user password \"([^\"]*)\"$")
	public void the_user_saved_with_user_id_and_user_name_and_user_password(int id, String name, String password) throws Throwable {
		String url = buildUrl(HOST, PORT, "/users");
		logger.info("url {}", url);
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("id", id);
		requestMap.put("name", name);
		requestMap.put("password",password);
		HttpEntity<?> requestEntity = new HttpEntity<>(requestMap, getDefaultHttpHeaders());
		response = invokeRESTCall(url, HttpMethod.POST, requestEntity);


	}

	@When("^the client calls \"([^\"]*)\" with the given details$")
	public void the_client_calls_with_the_given_details(String path) throws Throwable {
		
		if (logger.isInfoEnabled()) {
			logger.info("path {}", path);
		}
		String url = buildUrl(HOST, PORT, path);
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("name", this.UserName);
		requestMap.put("id", this.UserId);
		requestMap.put("password", this.UserPassword);
		HttpEntity<?> requestEntity = new HttpEntity<>(requestMap, getDefaultHttpHeaders());
		response = invokeRESTCall(url, HttpMethod.POST, requestEntity);

	}
	
	@When("^the client calls GET \"([^\"]*)\" with user id as (\\d+)$")
	public void the_client_calls_GET_with_user_id_as(String path, int id) throws Throwable {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(id));
		String url = buildUrl(HOST, PORT, path, uriVariables);
		logger.info("url {}", url);
		response = invokeRESTCall(url, HttpMethod.GET, null);
	}


	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {

		if (response != null && response.getStatusCode().is2xxSuccessful()) {
			assertEquals(statusCode, response.getStatusCode().value());
		}
	}
	@Then("^the response contains user name \"([^\"]*)\"$")
	public void the_response_contains_user_name(String name) throws Throwable {
		

		if (response != null && response.getStatusCode().is2xxSuccessful()) {
			String responseBody = response.getBody();
			com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
			Map<String, String> responseMap = mapper.readValue(responseBody, Map.class);
			System.out.println(responseMap);
			assertEquals(name, responseMap.get("name"));
		}

	}
	
	


}