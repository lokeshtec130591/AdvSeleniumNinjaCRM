package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class demo {

	
	
	@Test
	public void add() {
		Reporter.log("Add",true);
		
	}
	
	@Test
	public void sub() {
		
		Reporter.log("Sub",true);
	}
	
	@Test
	public void multiply() {
		
		Reporter.log("Multiply",true);
	}
	
	
	
}
