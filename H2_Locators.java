package com.myfirstproject.homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class H2_Locators extends TestBase {

    @Test
    public void locators(){
        driver.get("https://www.saucedemo.com/");

        //username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //click login
        driver.findElement(By.id("login-button")).click();

        //verify the Products is displayed on the page
        WebElement productsText = driver.findElement(By.xpath("//span[@class=\"title\"]"));
        Assert.assertTrue(productsText.isDisplayed());

        //get all the prices on a list
        List<WebElement> allPriceElements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> priceList = new ArrayList<>();
        for(WebElement eachPriceElement :allPriceElements){
           String eachPriceText = eachPriceElement.getText().replaceAll("\\p{Punct}", "");
           double eachPrice = Double.parseDouble(eachPriceText)/100;
           priceList.add(eachPrice);
        }
        Double min = priceList.stream().distinct().sorted().findFirst().get();
        Double max = priceList.stream().distinct().reduce(Double.MIN_VALUE, Math::max);

        //verifies the minimum price is greater than $5
        Assert.assertTrue("minimum price is not greater than $5",min>5);

        //verifies the maximum price is less than $50
        Assert.assertTrue("maximum price is not less than $50", max<50);



    }
}
