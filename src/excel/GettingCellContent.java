package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GettingCellContent {
	public static void main(String[] args) {
		  // import org.apache.poi.ss.usermodel.*;
//		String excelUrl="D:\\Workspace-new-02\\ExcelDemo\\workbookNewCells.xls";
		String excelUrl="D:\\Workspace-new-02\\ExcelDemo\\workbookNewCells.xlsx";
		File excelFile = new File(excelUrl); 
//		HSSFWorkbook wb = null;
		XSSFWorkbook wb = null;
		try {
			InputStream is = new FileInputStream(excelFile);
//			wb = new HSSFWorkbook(is);
			wb = new XSSFWorkbook(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    DataFormatter formatter = new DataFormatter();
	    Sheet sheet1 = wb.getSheetAt(0);
	    for (Row row : sheet1) {
	        for (Cell cell : row) {
	            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
	            System.out.print(cellRef.formatAsString());
	            System.out.print(" - ");

	            // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
	            String text = formatter.formatCellValue(cell);
	            System.out.println(text);
	            
	            // Alternatively, get the value and format it yourself
	            switch (cell.getCellTypeEnum()) {
	         /*       case  CellType.STRING:
	                    System.out.println(cell.getRichStringCellValue().getString());
	                    break;
	                case CellType.NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell)) {
	                        System.out.println(cell.getDateCellValue());
	                    } else {
	                        System.out.println(cell.getNumericCellValue());
	                    }
	                    break;
	                case CellType.BOOLEAN:
	                    System.out.println(cell.getBooleanCellValue());
	                    break;
	                case CellType.FORMULA:
	                    System.out.println(cell.getCellFormula());
	                    break;
	                case CellType.BLANK:
	                    System.out.println();
	                    break;
	                default:
	                    System.out.println();*/
	            }
	        }
	    }	
	}
}
