package utility;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadXLSdata {

    public void getData(String excelSheetname) throws IOException {
        File f = new File(System.getProperty("user.dir")+"data\\UserSignInFunctionality.xlsx");

        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetname = wb.getSheet(excelSheetname);


    }
}
