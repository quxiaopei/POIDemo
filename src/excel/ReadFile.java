package excel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFile {
	public static void main(String[] args) {

		  try {
			Workbook wb = WorkbookFactory.create(new File("D:\\Workspace-new-02\\ExcelDemo\\workbookNewCells.xlsx"));
		} catch (EncryptedDocumentException | InvalidFormatException
				| IOException e) {
			e.printStackTrace();
		}

	}
}
