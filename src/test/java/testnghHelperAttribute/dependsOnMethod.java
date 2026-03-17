package testnghHelperAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class dependsOnMethod {

	
	@Test
	public void zcreateAcc() {
		Reporter.log("Created",true);
		
	}
	
	@Test(dependsOnMethods = "zcreateAcc")
	public void editAcc() {
		Reporter.log("Edited",true);
		
	}
	
	@Test(dependsOnMethods = {"zcreateAcc","editAcc"})
	public void deleteAcc() {
		Reporter.log("Deleted",true);
		
	}
	
	
}
