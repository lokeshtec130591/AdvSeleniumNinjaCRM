package testnghHelperAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority {

	
	@Test(priority =5)
	public void amazon() {
		Reporter.log("amazon",true);
		
	}
	
	@Test(priority =0)
	public void baskinrobin() {
		Reporter.log("baskinrobin",true);
		
	}
	
	@Test(priority = -1)
	public void bigbasket() {
		Reporter.log("bigbasket",true);
		
	}
	
	@Test(priority =-2)
	public void cricbuzz() {
		Reporter.log("cricbuzz",true);
		
	}
	

	
	
}
