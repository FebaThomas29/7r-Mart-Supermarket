package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {

	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet sh;

	public static String readStringData(int row, int column, String sheet) throws IOException {
		String excelPath = Constants.TESTDATAFILE;
		f = new FileInputStream(excelPath);
		w = new XSSFWorkbook(f); // to take the workbook from file f
		sh = w.getSheet(sheet); // to take sheet1 from the workbook
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		return c.getStringCellValue();
	}

	public static String readIntegerData(int row, int column, String sheet) throws IOException {
		String excelPath = Constants.TESTDATAFILE;
		f = new FileInputStream(excelPath);
		w = new XSSFWorkbook(f); // to take the workbook from file f
		sh = w.getSheet(sheet); // to take sheet1 from the workbook
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		int a = (int) c.getNumericCellValue();
		return String.valueOf(a);

	}
}
