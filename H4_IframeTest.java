package com.myfirstproject.homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class H4_IframeTest extends TestBase {
    // Note:
    //The page is too slow. Do some manual testing and understand the behavior

    @Test
    public void iframeTest() throws InterruptedException {
        //go to https://html.com/tags/iframe/
        driver.get("https://html.com/tags/iframe/");

        //Then click on the first video play to play the video
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        driver.switchTo().frame(0);
        Thread.sleep(5000);

        WebElement playButton = driver.findElement(By.id("movie_player"));
        playButton.click();

        //Then wait for a 5 second (hard wait)
        Thread.sleep(5000);

        //Then stop the play
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement pauseButton = driver.findElement(By.xpath("//video[@tabindex='-1']"));
        je.executeScript("arguments[0].click();", pauseButton);


    }


}
