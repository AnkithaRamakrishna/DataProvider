package com.qa.DataReq;
import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class DataSource {
	
	static Xls_Reader reader;

	public static ArrayList<Object[]> readDataFromExcel() {
		
		ArrayList<Object[]>  data = new ArrayList<Object[]>();
		
		try {
		reader = new Xls_Reader("C:\\Users\\Akshay\\Desktop\\Ankitha Resume\\TestData.xlsx");
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("RegUsers");rowNum++)
		{

			String fName =reader.getCellData("RegUsers", "firstname", rowNum);
			String lName= reader.getCellData("RegUsers", "lastname", rowNum);
			String mail= reader.getCellData("RegUsers", "email", rowNum);
			String password= reader.getCellData("RegUsers", "PASSWORD", rowNum);
			
			Object[] users = {fName,lName,mail,password};
			data.add(users);
		}		
		
		return data;
		
		
	}
}
