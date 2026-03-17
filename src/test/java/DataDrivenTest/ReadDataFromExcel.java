package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xls");
		FileInputStream fis = new FileInputStream("C:/Users/Owner/Downloads/TestScriptData.xls");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Campaign");
		String campname = sh.getRow(1).getCell(2).getStringCellValue();
		String size = sh.getRow(1).getCell(3).getStringCellValue();
		String status = sh.getRow(1).getCell(4).getStringCellValue();
		
		System.out.println(campname);
		System.out.println(size);

		

		
		
	}

}
