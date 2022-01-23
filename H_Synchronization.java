package com.myfirstproject.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class H_Synchronization {
    /*
   NOTE: .isEnabled(); is used to check if an element is enabled or not

   Solutions will be shared
    */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void isEnabled(){
        //Click enable Button
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enabledText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        //And verify the message is equal to “It's enabled!”
        String expectedEnabledText = "It's enabled!";
        String actualEnabledText = enabledText.getText();
        Assert.assertEquals(expectedEnabledText,actualEnabledText);

        //And verify the textbox is enabled (I can type in the box)
        boolean isEnabled = driver.findElement(By.xpath("//input[@type='text']")).isEnabled();
        Assert.assertTrue(isEnabled);

        //And click on Disable button
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

        //And verify the message is equal to “It's disabled!”
        WebElement disabledText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String expectedDisabledText = "It's disabled!";
        String actualDisabledText = disabledText.getText();
        Assert.assertEquals(expectedDisabledText, actualDisabledText);

        //And verify the textbox is disabled (I cannot type in the box)
        boolean isDisabled = driver.findElement(By.xpath("//input[@type='text']")).isEnabled();
        Assert.assertFalse(isDisabled);

    }

}
