package testnghHelperAttribute;

import org.testng.annotations.Test;

public class DataProvider {

	@Test(dataProvider = "loginDetails" )
	public void login(String username, String password) {
		
		System.out.println(username);
		System.out.println(password);

	}

	
	
	@org.testng.annotations.DataProvider
	public Object[][] loginDetails(){
		
		Object[][] objarr = new Object[2][2];
		
		objarr[0][0]="Dhoni";
		objarr[0][1]="dhoni07";
		objarr[1][0]="Virat";
		objarr[1][1]="virat18";

		return objarr;
		
	}
	
	
	
}
