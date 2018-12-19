package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
//		InputStream inp = new FileInputStream("workbook.xls");
	    InputStream inp = new FileInputStream("D:\\Workspace-new-02\\ExcelDemo\\�������ֶα���.xlsx");

	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    if (cell == null)
	        cell = row.createCell(3);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue("a test");

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("workbook20180830.xls");
	    wb.write(fileOut);
	    fileOut.close();
	}
}
