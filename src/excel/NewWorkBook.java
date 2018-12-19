package excel;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class NewWorkBook {
	public static void main(String[] args) {
		Workbook wb = new HSSFWorkbook();
	    FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream("workbookNewWorkBook.xls");
			 wb.write(fileOut);
			 fileOut.close();
			 System.out.println("Successed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   
	}
}
