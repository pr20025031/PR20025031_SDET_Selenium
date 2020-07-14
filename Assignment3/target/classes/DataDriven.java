package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static ArrayList<String> getData(String testcase) throws IOException {
		
		ArrayList<String> al = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\HP1\\PR20025031_Prasad_Ram_Sarode_Selenium_Assignment_New\\Assignment3\\src\\main\\java\\excelData\\databook3.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata") == true) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();

				int k = 0;

				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}

				System.out.println(column);

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase)) {
						Iterator<Cell> cv = r.cellIterator();

						while (cv.hasNext()) {
							Cell c= cv.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{
								al.add(c.getStringCellValue());
							}
							else {
								al.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
							
						}
					}
				}

			}

		}
		
		return al;
	}

	

}
