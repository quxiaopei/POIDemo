package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestReadAndWrite {  
    public static void main(String[] args) throws IOException {  
        String path = "d:/";  
        String fileName = "�������ֶα���";  
        String fileType = "xlsx";  
        writer(path, fileName, fileType);  
        read(path, fileName, fileType);  
    }  
    private static void writer(String path, String fileName,String fileType) throws IOException {  
        //���������ĵ�����  
        Workbook wb = null;  
        if (fileType.equals("xls")) {  
            wb = new HSSFWorkbook();  
        }  
        else if(fileType.equals("xlsx"))  
        {  
            wb = new XSSFWorkbook();  
        }  
        else  
        {  
            System.out.println("�����ĵ���ʽ����ȷ��");  
        }  
        //����sheet����  
        Sheet sheet1 = (Sheet) wb.createSheet("sheet1");  
        //ѭ��д��������  
        for (int i = 0; i < 5; i++) {  
            Row row = (Row) sheet1.createRow(i);  
            //ѭ��д��������  
            for (int j = 0; j < 8; j++) {  
                Cell cell = row.createCell(j);  
                cell.setCellValue("����"+j);  
            }  
        }  
        //�����ļ���  
        OutputStream stream = new FileOutputStream(path+fileName+"."+fileType);  
        //д������  
        wb.write(stream);  
        //�ر��ļ���  
        stream.close();  
    }  
    public static void read(String path,String fileName,String fileType) throws IOException  
    {  
        InputStream stream = new FileInputStream(path+fileName+"."+fileType);  
        Workbook wb = null;  
        if (fileType.equals("xls")) {  
            wb = new HSSFWorkbook(stream);  
        }  
        else if (fileType.equals("xlsx")) {  
            wb = new XSSFWorkbook(stream);  
        }  
        else {  
            System.out.println("�������excel��ʽ����ȷ");  
        }  
        Sheet sheet1 = wb.getSheetAt(0);  
        for (Row row : sheet1) {  
            for (Cell cell : row) {  
                System.out.print(cell.getStringCellValue()+"  ");  
            }  
            System.out.println();  
        }  
    }  
}  
