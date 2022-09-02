package testResource;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.FileAlreadyExistsException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;

	public ReadExcelFile() throws FileAlreadyExistsException {
		try {
			File src = new File("D:\\2(WORK)\\Onelern\\Automation\\MAIN-repo\\Frugal_Onelern_Main\\data\\UserSignInFunctionality.xlsx");
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);

			int no_of_rows_Studentdata = getRowCount(2);


		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getdata(int sheetnumber, int row, int column) {
		sheet = workbook.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getRowCount(int sheetindex) {
		int row = workbook.getSheetAt(sheetindex).getLastRowNum();
		row = row + 1;
		return row;
	}

}
