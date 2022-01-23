package com.myfirstproject.homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H_WebTableTest extends TestBase {

    @Test
    public void getLastnames(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> allLastnames = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
        List<String> list = new ArrayList<>();
        for (WebElement eachLastname: allLastnames){
            list.add(eachLastname.getText());
        }
        System.out.println(list);

        List<String> temp = new ArrayList<>(list);
        Collections.sort(list);
        Assert.assertFalse(list.equals(temp));

    }

}
