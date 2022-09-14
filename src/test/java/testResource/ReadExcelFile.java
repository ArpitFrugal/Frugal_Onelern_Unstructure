package testResource;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Objects;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Object[][] LoginTestCasesCredentials(String testcase){
		Object[][] x = new Object[0][];
		int NoOfStudentTestcases = 0, index=0;
		DataFormatter formatter = new DataFormatter();
		try {
			File src = new File(System.getProperty("user.dir")+"/data/UserSignInFunctionality.xlsx");
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);

			sheet = workbook.getSheetAt(1);
			if(Objects.equals(testcase, "SLPC")){
				sheet = workbook.getSheetAt(2);
				NoOfStudentTestcases = getRowCount(2);
			}
			else if(Objects.equals(testcase, "SLPIP")){
				sheet = workbook.getSheetAt(3);
				NoOfStudentTestcases = getRowCount(3);
			}
			else if(Objects.equals(testcase, "IUMNC")){
				sheet = workbook.getSheetAt(4);
				NoOfStudentTestcases = getRowCount(4);
			}
			else if(Objects.equals(testcase, "TLPCC")){
				sheet = workbook.getSheetAt(5);
				NoOfStudentTestcases = getRowCount(5);
			}
			else if(Objects.equals(testcase, "TLPIP")){
				sheet = workbook.getSheetAt(6);
				NoOfStudentTestcases = getRowCount(6);
			}
			x = new Object[5][2];
			for (int i = 1; i < NoOfStudentTestcases; i++) {
				Cell cell1 = sheet.getRow(i).getCell(0);
				String mobilenumber = formatter.formatCellValue(cell1);
				Cell cell2 = sheet.getRow(i).getCell(1);
				String password = formatter.formatCellValue(cell2);
				x[index][0] = mobilenumber;
				x[index][1] = password;
				index++;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return x;
	}
	public static Object[][] TestcasesCredentials(String stakeholder) {
		Object[][] x = new Object[0][];
		int NoOfStudentTestcases;
		DataFormatter formatter = new DataFormatter();
		try {
			File src = new File(System.getProperty("user.dir")+"/data/UserSignInFunctionality.xlsx");
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);

			if(Objects.equals(stakeholder, "student")){
				sheet = workbook.getSheetAt(0);
				NoOfStudentTestcases = getRowCount(0);
			}
			else{
				sheet = workbook.getSheetAt(1);
				NoOfStudentTestcases = getRowCount(1);
			}
			x = new Object[NoOfStudentTestcases-1][2];
			Iterator<Row> rows = sheet.iterator();
			for (int i = 1; i < NoOfStudentTestcases; i++) {
				Iterator<Cell> ce = rows.next().cellIterator();
				Cell cell1 = sheet.getRow(i).getCell(0);
				String mobilenumber = formatter.formatCellValue(cell1);
				Cell cell2 = sheet.getRow(i).getCell(1);
				String password = formatter.formatCellValue(cell2);
				x[i-1][0] = mobilenumber;
				x[i-1][1] = password;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return x;
	}

	public static int getRowCount(int sheetindex) {
		int row = workbook.getSheetAt(sheetindex).getLastRowNum();
		row = row + 1;
		return row;
	}

}
