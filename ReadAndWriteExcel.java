package com.myfirstproject.practice;

import com.myfirstproject.utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadAndWriteExcel extends TestBase {


    @Test
    public void wikipediaTable(){

        extentTest.pass("Going to the google home page");
        driver.get("https://en.wikipedia.org/wiki/List_of_countries_by_GDP_(nominal)");

        extentTest.pass("Putting country and GDP into a map");
        List<WebElement> countries = driver.findElements(By.xpath("(//tbody)[3]//tr//td[1]"));
        List<WebElement> gdp = driver.findElements(By.xpath("(//tbody)[3]//tr//td[4]"));

        Map<String, String> countryGdp = new LinkedHashMap<>();

        for(int i=0; i<countries.size(); i++){
            String countryName = countries.get(i).getText();
            String gdpOfCountry = gdp.get(i).getText();

            countryGdp.put(countryName, gdpOfCountry);
            writeToExcel(countryName,gdpOfCountry,i);
        }
        System.out.println(countryGdp);

    }


    public void writeToExcel(String a, String b, int c){
        try {
            String path = "./src/test/java/resources/CountryGDP.xlsx";
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            sheet.createRow(0).createCell(0).setCellValue("COUNTRY");
            sheet.getRow(0).createCell(1).setCellValue("GDP");

            sheet.createRow(c+1).createCell(0).setCellValue(a);
            sheet.getRow(c+1).createCell(1).setCellValue(b);

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);

        }catch(Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }

}
