package VitegerGenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * It is developed using apache.libraary which is used to handle microsoft Excel
 * @param SheetName
 * @param RowNum
 * @param Cellnum
 * @return
 * @throws Throwable
 */
public class ExcelUtility {
	/**
	 * It is used to read the data from the excel as on below argument
	 * @param SheetName
	 * @param RowNum
	 * @param Cellnum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String SheetName, int RowNum, int Cellnum) throws Throwable {
		FileInputStream fisExcel=new FileInputStream("./data/TestScriptData1.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sheet = wb.getSheet(SheetName);
		Row row = sheet.getRow(7);
		Cell cell = row.getCell(2);
		String data=cell.getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * It is used to get the number of RowCount from specified sheet
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String SheetName) throws Throwable
	{
		FileInputStream fisExcel=new FileInputStream("./data/TestScriptData1.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sheet = wb.getSheet(SheetName);
		wb.close();
		return sheet.getLastRowNum();
		
		
	}
	/**
	 * It is used to write the data from 
	 * @param SheetName
	 * @param RowNum
	 * @param Cellnum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataFromExcel(String SheetName, int RowNum, int Cellnum,String data) throws Throwable 
		{
			FileInputStream fisExcel=new FileInputStream("./data/TestScriptData1.xlsx");
			Workbook wb = WorkbookFactory.create(fisExcel);
			Sheet sheet = wb.getSheet(SheetName);
		  Row row=sheet.getRow(RowNum);
		  Cell cell=row.createCell(Cellnum);
		  cell.setCellValue(data);
		  FileOutputStream fos = new FileOutputStream("./data/TestScriptData1.xlsx");
		 wb.write(fos);
		 wb.close();
		  
		  
		}
	
	
	}


	
