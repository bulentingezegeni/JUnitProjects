package com.myfirstproject.practice;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Team3_Practice extends TestBase {

    @Test
    public void studentForm(){

        driver.get("https://demoqa.com/automation-practice-form");

        Actions actions=new Actions(driver);
        Faker faker= new Faker();

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(faker.name().name());
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys("1234567890")
                .sendKeys(Keys.TAB).sendKeys("12.12.2002"+Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys("M").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        WebElement closMessage= driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]"));

        Assert.assertTrue(closMessage.isDisplayed());


    }


}
