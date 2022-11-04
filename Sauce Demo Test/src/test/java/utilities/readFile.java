package utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class readFile {

    public Recordset getData(String excelSheetName,String Query) throws FilloException {

        Fillo filo = new Fillo();
        Connection connection = filo.getConnection(excelSheetName);
        Recordset rs = connection.executeQuery(Query);

        return  rs;
    }




//         File f = new File("resources/testdata/sauceDemo data.xlsx");
//         FileInputStream fis = new FileInputStream(f);
//         Workbook wb = WorkbookFactory.create(fis);
//         Sheet sheetName = wb.getSheet(excelSheetName);
//
//         int totalRows = sheetName.getLastRowNum();
//         Row rowCells = sheetName.getRow(0);
//
//         int totalCols = rowCells.getLastCellNum();
//
//        DataFormatter format = new DataFormatter();
//        String testData[][]= new String[totalRows][totalCols];
//
//        //looping through the excel file line by line
//        for(int i = 1; i <= totalRows; i++){
//            for (int j = 0; j < totalCols; j++){
//                testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
//
//            }
//        }
//        return testData;

}

