package com.myfirstproject.homeworks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.*;

public class H3_AmazonDropdown {

    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // Go to https://www.amazon.com/
        driver.get("https://www.amazon.com");
    }

    //Create A Method dropdownTest
    @Test
    public void dropdownTest() throws InterruptedException {

        //Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        //Print the first selected option and assert if it equals “All Departments”
        Select select = new Select(dropDown);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println(firstSelectedOption.getText());
        Assert.assertEquals("All Departments",firstSelectedOption.getText());

        //Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        // (after you select you do need to use the get first selected option method)
        select.selectByIndex(3);
        Thread.sleep(5000);
        String selectedText = select.getFirstSelectedOption().getText();
        if(selectedText.equals("Amazon Devices")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }


        // Print all the dropdown options
        List<WebElement> allOptions = select.getOptions();
        for(WebElement eachOption : allOptions){
            System.out.println(eachOption.getText());
        }

        //Print the total number of options in the dropdown
        int numberOfOptions = allOptions.size();
        System.out.println("Total number of options : "+numberOfOptions);

        //Check if Appliances is a drop-down option.
        // Print true if “Appliances” is an option. Print false otherwise.
        List<String> options = new ArrayList<>();
        for(WebElement eachOption : allOptions){
            options.add(eachOption.getText());
        }
        if(options.contains("Appliances")){
            System.out.println("True");
        }else {
            System.out.println("False");
        }

        //BONUS: Check if the dropdown is in Alphabetical Order
        List<String> temp = new ArrayList<>(options);
        options.sort(Comparator.comparing(String::toUpperCase));
        Assert.assertTrue(temp.equals(options));

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
