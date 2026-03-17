package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:/Users/Owner/Downloads/TestScriptData.xls");

		Workbook wb = WorkbookFactory.create(fis);
		
		String data = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		
		return data;
		
		
	}
	
	
	
	
	
}
