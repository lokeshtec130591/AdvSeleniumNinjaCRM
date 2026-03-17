package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test
  public void testCases() {
	  System.out.println("First TestCase 001");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Login Application");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Logout Application");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Launch Browser");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Close Browser");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Pre Condition");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Post Condition");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("DB Open");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("DB Close");
  }

}
