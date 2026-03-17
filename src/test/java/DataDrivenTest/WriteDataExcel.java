package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:/Users/Owner/Downloads/TestScriptData.xls");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Campaign");
		Row r = sh.getRow(1);
		Cell c = r.createCell(5);
		c.setCellValue("New Data");
		
		FileOutputStream fos = new FileOutputStream("C:/Users/Owner/Downloads/TestScriptData.xls");
		wb.write(fos);   // use this for save file
		wb.close();
		
		
	}

}
