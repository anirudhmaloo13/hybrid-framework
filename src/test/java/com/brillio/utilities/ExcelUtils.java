package com.brillio.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getSheetIntoTwoDimArray(String fileDetail, String sheetname) throws IOException
	{
		
        FileInputStream file=new FileInputStream(fileDetail); // location
		
		XSSFWorkbook book=new XSSFWorkbook(file);  // open
		
		XSSFSheet sheet=book.getSheet(sheetname);
		
		int rowcount= sheet.getPhysicalNumberOfRows();
		int cellcount= sheet.getRow(0).getPhysicalNumberOfCells();
		
		DataFormatter format=new DataFormatter();
		
		Object[][] main =new Object[rowcount-1][cellcount];
		
		for(int r=1; r<rowcount; r++) {
			for(int c=0; c<cellcount; c++)
			{
				String value= format.formatCellValue(sheet.getRow(r).getCell(c));
				main[r-1][c]=value;
			}
		}
		return main;

	}

}
