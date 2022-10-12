package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void readFromExcelFile() throws IOException {
        String path = "SampleData.xlsx";

        File file = new File(path);

        //to read from excel we need to load it to FileInputStrem
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook>sheet>row>cell

        //<1> create workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //<2> We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //<3> Select row and cell
        //Print out mary's cell
        //indexes start from 0

        System.out.println(sheet.getRow(1).getCell(0));

        //ptint out developer
        System.out.println(sheet.getRow(3).getCell(2));
        
        //Return the count of used cells only
        //starts from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);
        
        //Return the count of from top to buttom
        //it doesnt care if the cell used or not
        // starts from 0
        
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);
        
        //TODO: Create a logic to print Vindo's name

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }

        }

        //TODO: create a logic to print out lindas job id

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){
                System.out.println(sheet.getRow(rowNum).getCell(2));
            }
        }



    }
}
