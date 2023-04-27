package com.ninja.qa.test.data;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SupplyTestData {
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
@DataProvider (name = "tutorialsninjaDataSupply")
public static Object dataSupplyfrom2DimensionalObjectArray() {
	Object[][] data = {{"rezikahachour@gmail.com","Rezika@123"},
			{"rezikahachour1@gmail.com","Rezika@123"},
			{"rezikahachour2@gmail.com","Rezika@123"}};
	return data;
}
@DataProvider(name = "tutorialsninjaExelDataProvider")
public static Object[][] excelSheetDataSuplier() throws Exception {
	Object[][] data = SupplyTestData.getTutorialsninjaTestDataFromExcelSheet("login");
	return data;
	
	
	
	}
public static Object [][]getTutorialsninjaTestDataFromExcelSheet(String sheetName) throws Exception{
	 ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ninja\\qa\\test\\data\\TutorialsninjaTestData.xlsx");
	 workbook =new XSSFWorkbook (ip);
	 sheet =workbook.getSheet(sheetName);
	int rows = sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[rows][cols];
	for (int i=0; i<rows; i++) {
		XSSFRow row = sheet.getRow(i+1);
		for(int j=0; j<cols; j++ ) {
			XSSFCell cell = row.getCell(j);
			CellType celltype = cell.getCellType();
			switch(celltype) {
			case STRING:
				data[i][j]= cell.getStringCellValue();
				break;
			case NUMERIC:
				data[i][j]= Integer.toString((int)cell.getNumericCellValue());
				break;
			case BOOLEAN:
				data[i][j]= cell.getBooleanCellValue();
				break;
			}
					}
		
		
	}
return data;
}

}

