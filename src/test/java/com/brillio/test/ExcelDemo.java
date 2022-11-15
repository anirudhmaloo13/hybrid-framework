package com.brillio.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {

	public static void main(String[] args) throws IOException {


		FileInputStream file=new FileInputStream("test-data/Test data for Invalid Credentential.xlsx");
		
		XSSFWorkbook book=new XSSFWorkbook(file);
		
		XSSFSheet sheet=book.getSheet("invaliddata");
		
		int rowcount= sheet.getPhysicalNumberOfRows();
		int cellcount= sheet.getRow(0).getPhysicalNumberOfCells();
		
		DataFormatter format=new DataFormatter();
		
		Object[][] main =new Object[rowcount-1][cellcount];
		
		for(int r=1; r<rowcount; r++) {
			for(int c=0; c<cellcount; c++)
			{
				String value= format.formatCellValue(sheet.getRow(0).getCell(0));
				System.out.println(value);
				main[r-1][c]=value;
			}
		}
		
		
		//String value=sheet.getRow(0).getCell(0).getStringCellValue(); --> It will throw error when value contains as numeric
		//Above line will be used to handle those scenarios
		
		

	}

}
