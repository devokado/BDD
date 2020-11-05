package stepDefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before("@MobileTest")
	public void beforevalidation()
	{
		System.out.println("Before mobile hook");
	}
	@After("@MobileTest")
	public void aftervalidation()
	{
		System.out.println("After mobile hook");
	}
	@Before("@WebTest")
	public void beforewebvalidation()
	{
		System.out.println("Before web hook");
	}
	@After("@WebTest")
	public void afterwebvalidation()
	{
		System.out.println("After web hook");
	}	

}
