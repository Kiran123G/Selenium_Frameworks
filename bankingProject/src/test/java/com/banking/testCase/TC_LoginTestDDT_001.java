package com.banking.testCase;

import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.utilities.Xutils;

public class TC_LoginTestDDT_001 {

	@Test
	public void loginDDT() {

	}

	@DataProvider(name = "login data")
	TC_LoginTestDDT_001() {
		String pathString = "/home/htadmin/git/repository_Kiran/bankingProject/src/test/java/com/banking/utilities/validAndInvalidData.xlsx";
		int rownum = Xutils.readRowCount(pathString, "validData");
		int cellnum = Xutils.readCellCount(pathString, "validData",1 );
		
		String dataString [][] = new String[rownum][cellnum];
		for (int i = 1; i < rownum; i++) {
			for (int j = 1; j < cellnum; j++) {
				
			}
		}
		

}
}
