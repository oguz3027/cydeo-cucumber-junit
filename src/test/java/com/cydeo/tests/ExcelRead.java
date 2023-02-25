package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    @Test
    public  void read_from_excel_file() throws IOException {

        String path = "SampleData.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Employees");

        System.out.println(sheet.getRow(1).getCell(0));

        System.out.println(sheet.getRow(3).getCell(2));

        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);



        //create a logic to print Vinod's name
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinod"))
                System.out.println(sheet.getRow(rowNum).getCell(0));
        }

        //create a logic to print out Linda's Job_ID
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Linda"))
                System.out.println(sheet.getRow(rowNum).getCell(2));
        }



    }
}
