package resttestcases;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class ExcelOperations {

	String filePath;
	Sheet sh;

	public ExcelOperations(String sheetName) {
		try {
			filePath = System.getProperty("user.dir") + "/src/test/resources/Puju.xlsx";
		} catch (Exception e) {
			e.printStackTrace();
		}
		// open file - workbook
		File testDataFile = new File(filePath);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sh = wb.getSheet(sheetName);
	}

	// get test data from test data sheet in hashmap based on row number
	@SuppressWarnings("deprecation")
	public HashMap<String, String> getTestDataInMap(int rowNum) throws Exception {
		// read data row by row and put in map
		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			String value;
			if (sh.getRow(rowNum).getCell(i) != null) {
				sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
				value = sh.getRow(rowNum).getCell(i).toString();
			} else {
				value = "";
			}
			hm.put(sh.getRow(0).getCell(i).toString(), value);
		}
		return hm;
	}

	// get row count
	public int getRowCount() {
		return sh.getLastRowNum();
	}

	// ger column count
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();

	}
}
