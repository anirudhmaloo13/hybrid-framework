package com.brillio.utilities;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	@DataProvider
	public Object[][] validdata(){
		
		Object[][] main=new Object[2][4];
		// --> i: no. of test data
		// --> j: no. of arguments
		main[0][0]="admin";
		main[0][1]="pass";
		main[0][2]="English (Indian)";
		main[0][3]="OpenEMR";
		
		main[1][0]="physician";
		main[1][1]="physician";
		main[1][2]="Dutch";
		main[1][3]="OpenEMR";
		
		return main;
		
	}
	    @DataProvider
        public Object[][] invaliddata(){
		
		Object[][] main=new Object[3][4];
		// --> i: no. of test data
		// --> j: no. of arguments
		main[0][0]="admin1";
		main[0][1]="pass1";
		main[0][2]="English (Indian)";
		main[0][3]="Invalid username or password";
		
		main[1][0]="physician34";
		main[1][1]="physician23";
		main[1][2]="Dutch";
		main[1][3]="Invalid username or password";
		
		main[2][0]="test";
		main[2][1]="test35";
		main[2][2]="Dutch";
		main[2][3]="Invalid username or password";
		return main;
		
	}
}
