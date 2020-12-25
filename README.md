# BDD
<h3>spring boot application with cucumber test cases</h3>

<b>step 1</b> : To start with cucumber </br>
Add the below dependencies to support Spring with Cucumber:
```
    <dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>1.2.6</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>1.2.5</version>
			<scope>test</scope>
		</dependency>
```
And for patch scenario add below dependencie

```
    <dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.4.1</version>
		</dependency>
```
----------------------------------
<b>step 2</b> :Define the Cucumber Runner Test in folder CucumberOption</br>


```
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/UserCrud.feature",
		glue = "stepDefinations")
public class TestRunner {

}

```

----------------------------------
<b>step 3</b> : Create a feature file in folder Features and define the BDD steps using gherkin language </br>

Example : Feature describing the scenario of creating a user with detail
```
Scenario: Create user 
	Given the user with user id 1 and user name "user1" and user password "1234" 
	When  the client calls "/users" with the given details 
	Then the client receives status code of 201 
	And the response contains user name "user1" 
  
```

----------------------------------
<b>step 4</b> </br>
When you run this feature file <b> Run as -> Cucumber </b>it generates the BDD style of java code. Using which you can write the service logic 
to file Step in stepDefinations folder
```

@Given("^the user with user id (\\d+) and user name \"([^\"]*)\" and user password \"([^\"]*)\"$")
	public void the_user_with_user_id_and_user_name_and_user_password(int id, String name, String password){ }
  
@When("^the client calls \"([^\"]*)\" with the given details$")
	public void the_client_calls_with_the_given_details(String path){ }
  
@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) {  }
  
@And("^the response contains user name \"([^\"]*)\"$")
	public void the_response_contains_user_name(String name)  {  }


```
-----------------------------------

<b>step 5</b> </br>
Copy file </br><b>https://github.com/devokado/BDD/blob/master/src/test/java/stepDefinations/AbstractSpringConfigurationTest.java</b></br>
to stepDefinations folder

-----------------------------------

<b>step 6</b> </br>
Similar to file
</br><b>https://github.com/devokado/BDD/blob/master/src/test/java/stepDefinations/UserStepDefinitionTest.java</b></br>
Complete the steps


