package com.myfirstproject.practice;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GooglePractice extends TestBase {

    @Test
    public void googleSearch() throws IOException {
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Iphone x", Keys.ENTER);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File image = ts.getScreenshotAs(OutputType.FILE);

        String currentTime = new SimpleDateFormat("yyyy.MM.dd.hhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+".png";

        File finalPath = new File(path);
        FileUtils.copyFile(image,finalPath);


    }
}
