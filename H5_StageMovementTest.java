package com.myfirstproject.homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class H5_StageMovementTest extends TestBase {

    @Test
    public void stageMovements(){
//        When a user is on the page
        driver.get("http://automationpractice.com/index.php");
//        Click on Add To Cart
        driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[1]")).click();

//        And verifies the product is added to the cart
//        And verifies the color, size, quantity, price, shipping, Total Price
//                (Example: Color : Orange, Size:S, Quanty:1 ,Price : $16.51, Shipping: $2.00, Total Price:
//        $18.51)
//        And clicks on Proceed to checkout
//        Then verify the Summary card is displayed(SELECT A CORE ELEMENT ON THAT PAGE FOR
//                VERIFICATION: EX SHOPPING-CART SUMMARY)
//        Then verify the product is In stock
//        Then verify the Unit price matches the price that is on the Add To Card page
//        And user clicks on + sign
//        Then verifies the TOTAL price is 2*price+shipping
//        And click on Proceed to checkout
//        Then verify sign-in page displayed
//        Then the user enters a username password and sign in
//        Then Verify user is on the Address stage
//        And click on Proceed to checkout
//        Then verify user moves to the Shipping stage(SHIPPING)
//                And click on Proceed to checkout
//        Then verify the error message: You must agree to the terms of service before continuing.
//        Then click on x to exit out
//        And click on the Terms of service checkbox
//        And click on Proceed to checkout
//        Then verify a user is on the Payment stage(PLEASE CHOOSE YOUR PAYMENT
//                METHOD)
    }
}
