package com.myfirstproject.practice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class HepsiBuradaTest extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.hepsiburada.com/");
        WebElement searchBox= driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        searchBox.sendKeys("kulaklık"+ Keys.ENTER);
        driver.findElement(By.xpath("(//*[@data-test-id='dropdown-toggle'])[2]")).click();

        driver.findElement(By.linkText("Artan Fiyat")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='searchbox-searchInput']")).sendKeys("sony");
        Thread.sleep(3000);
        driver.findElement(By.name("markalar")).click();
        Thread.sleep(2000);
        String sonyUrl= driver.getCurrentUrl();

        Thread.sleep(25000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(sonyUrl);
        do {
            Thread.sleep(3000);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            List<WebElement> sonyList= driver.findElements(By.xpath("//*[@data-test-id='product-card-image-container']"));
            if(sonyList.size()==88){
                Assert.assertEquals(88,sonyList.size());
                break;}
        }while (true);


//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement textToSee = driver.findElement(By.xpath("//div[@class='paginatorStyle-label']"));
//        js.executeScript("arguments[0].scrollIntoView(true);", textToSee);
//
//        List<WebElement> number = driver.findElements(By.xpath("//h3"));
//        int size = number.size();
//        System.out.println(size);


    }
}
