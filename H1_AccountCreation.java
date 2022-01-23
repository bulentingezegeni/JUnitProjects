package com.myfirstproject.homeworks;

import com.github.javafaker.Faker;
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

public class H1_AccountCreation {
    WebDriver driver;
    Faker faker = new Faker();

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void signIn() {
        //3. Click on sign in link
        WebElement signInBtn = driver.findElement(By.xpath("//a[@class='login']"));
        signInBtn.click();

        //4.Verify the Text : CREATE AN ACCOUNT
        WebElement createAnAccountText = driver.findElement(By.xpath("(//h3[@class=\"page-subheading\"])[1]"));
        Assert.assertEquals("CREATE AN ACCOUNT",createAnAccountText.getText());

        //5.Send your email and click on create an account button
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email_create']"));
        emailBox.sendKeys("deneme2@gmail.com");

        WebElement createAccount = driver.findElement(By.xpath("//i[@class='icon-user left']"));
        createAccount.click();

        //6. Verify the Text : YOUR PERSONAL INFORMATION
        WebElement yourPersonalInfoText = driver.findElement(By.xpath("(//h3[@class=\"page-subheading\"])[1]"));
        Assert.assertTrue(yourPersonalInfoText.isDisplayed());

        //7. Verify the Text : Title
        WebElement titleText = driver.findElement(By.xpath("//*[(text()='Title')]"));
        Assert.assertEquals("Title", titleText.getText());

        //8. Select your title
        WebElement maleRadioButton = driver.findElement(By.xpath("(//div[@class='radio'])[1]"));
        maleRadioButton.click();

        //9. Enter your first name
        driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());

        //10. Enter your last name
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());

        //12. Enter your password
        driver.findElement(By.id("passwd")).sendKeys(faker.internet().password());

        //13. ENTER DATE OF BIRTH
        WebElement dayDropDown = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectDay = new Select(dayDropDown);

        WebElement monthDropDown = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonth = new Select(monthDropDown);

        WebElement yearDropDown = driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYear = new Select(yearDropDown);

            // Selecting the day
        selectDay.selectByValue("10");

            // Selecting the month
        selectMonth.selectByValue("1");

            // Selecting the year
        selectYear.selectByValue("1980");

        //14. Click on Sign up for our newsletter!
        WebElement firstCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        firstCheckBox.click();

        //17. Enter your company
        driver.findElement(By.id("company")).sendKeys(faker.company().name());

        //18. Enter your Address
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());

        //19. Enter your City
        driver.findElement(By.id("city")).sendKeys(faker.address().city());

        //20. SELECT STATE
        WebElement state = driver.findElement(By.id("id_state"));
        Select selectState = new Select(state);
        selectState.selectByValue("30");

        //21. Enter Postal Code
        driver.findElement(By.id("postcode")).sendKeys("07424");

        //23. Enter additional information
        driver.findElement(By.id("other")).sendKeys("I want to register");

        //24. Enter home phone
        driver.findElement(By.id("phone")).sendKeys("9736364557");

        //25. Enter mobile phone
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());


        //27. Click Register
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

        //28. Then verify MY ACCOUNT is displayed on the home page
        WebElement myAccountText = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(myAccountText.isDisplayed());

    }


    @After
    public void tearDown(){
        driver.quit();
    }


}
