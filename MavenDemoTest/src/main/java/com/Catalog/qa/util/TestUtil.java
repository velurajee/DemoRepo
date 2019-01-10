package com.Catalog.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	static Workbook book;
	static Sheet sheet;
	 public static WebDriver driver;
	
	public static String Testdata_sheet_path="C:\\Software testing Assignments\\Testdata.xlsx";
	//public static String Testdata_sheet_path="C:\\Software testing Assignments\\catest.xlsx";

public static Object[][] gettestdata(String sheetname) {
		try {
		FileInputStream file= null;
		file=new FileInputStream(Testdata_sheet_path);
		book=WorkbookFactory.create(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (InvalidFormatException e) {
			e.printStackTrace();
	} catch (IOException e) {
				e.printStackTrace();
	}
		
		sheet=book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}	 
	}
	return data;
		}


public static void takeScreenshotAtEndOfTest() throws Exception {
	File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String CurrentDir=System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(CurrentDir + "/screenshot/" + System.currentTimeMillis()+ ".png"));
}
}
