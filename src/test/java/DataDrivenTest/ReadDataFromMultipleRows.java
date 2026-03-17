package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMultipleRows {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:/Users/Owner/Downloads/TestScriptData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Mobiles");
		
		int rowcount = sh.getLastRowNum();

		for(int i=1;i<=rowcount;i++) {
		String prodname = sh.getRow(i).getCell(0).getStringCellValue();
		String prodcat = sh.getRow(i).getCell(0).getStringCellValue();
		
		System.out.println(prodname +"-----" + prodcat);
		}
		
		
	}

}
