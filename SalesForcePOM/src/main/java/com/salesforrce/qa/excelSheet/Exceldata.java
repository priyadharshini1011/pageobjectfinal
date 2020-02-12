package com.salesforrce.qa.excelSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Exceldata {
	public static String[][] getDataInput(String filepath,String filename, String Sheetname)
			throws IOException
			{
			//Get the Xl path
			File xlfile = new File(filepath+"/"+filename);
			//access to the Xl path
			FileInputStream xlaccess = new FileInputStream(xlfile);
			//access to workbook
			HSSFWorkbook Wb = new HSSFWorkbook(xlaccess);
			//Access the sheet
			HSSFSheet sheet = Wb.getSheet(Sheetname);
			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			System.out.println(rowCount);
			System.out.println(columnCount);
			String [][] readData = new String [rowCount+1][columnCount];
			for(int i=0;i<=rowCount;i++)
			{
				for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
				{
					//System.out.println("row:"+i);
					//System.out.println("coulmn"+j);
					//System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
					//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				readData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			
				}
			//System.out.println();

			}
			return readData;
			}
}
