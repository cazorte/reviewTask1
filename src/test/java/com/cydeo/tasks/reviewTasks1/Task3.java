package com.cydeo.tasks.reviewTasks1;

import net.bytebuddy.jar.asm.Handle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.*;

public class Task3 {
    static WebDriver driver;

    @BeforeTest
    public static void beforeM(){
        // driver = null;
         driver= Driver.getDriver();

    }


    @Test
    public void test1(){
        //step1
        driver.get("http://zero.webappsecurity.com/index.html");

        WebElement signInButton = driver.findElement(By.xpath("//*[@id='signin_button'] "));
        signInButton.click();

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("user name", "","   ", "Username."));
        ArrayList<String> passwords = new ArrayList<>(Arrays.asList("   ","","pass word", "pasda1231asdas"));

        //test field text

        String expectedText = "Login and/or password are wrong.";

        int count = 0;
        for (String eachUsername : usernames) {
            signInTest(eachUsername, "password");
            WebElement text = driver.findElement(By.xpath("//div[@class='alert alert-error']"));
            String actualText = text.getText();
            Assert.assertEquals(actualText,expectedText);
            System.out.println(count++ +" . invalid username credential test done!");

        }
        count = 0;
        for (String eachPassword : passwords) {
            signInTest("username",eachPassword);
            WebElement text = driver.findElement(By.xpath("//div[@class='alert alert-error']"));
            String actualText = text.getText();
            Assert.assertEquals(actualText,expectedText);
            System.out.println(count++ +" . invalid password credential test done!");

        }



    }

    @Test
    public void test2(){


        driver.get("http://zero.webappsecurity.com/index.html");

        WebElement signInButton = driver.findElement(By.xpath("//*[@id='signin_button'] "));
        signInButton.click();

        WebElement usernameInput = driver.findElement(By.xpath("//*[@id='user_login']"));
        usernameInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id = 'user_password']"));
        passwordInput.sendKeys("password");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        driver.navigate().back();

        //title test
        String expectedTitle = "Zero - Personal Banking - Loans - Credit Cards";
        String actualTitle =driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        //Account summary page tests
        //title test

        String expectedTitleAccountSummary = "Zero - Free Access to Online Banking";
        WebElement onlineBanking = driver.findElement(By.xpath("//*[@id='onlineBankingMenu']"));
        onlineBanking.click();

        String actualTitleAccountSummary = driver.getTitle();
        Assert.assertEquals(actualTitleAccountSummary,expectedTitleAccountSummary);

    }

    @Test
    public void test3(){
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id='account_summary_link']")).click();

        //title test
        String actualAccountSummary =  driver.getTitle();
        String expectedAccountSummary = "Zero - Account Summary";
        Assert.assertEquals(actualAccountSummary,expectedAccountSummary);

        //account type test
        AccountSummaryFeature();


        //last test table must have account credit card balance columns





    }
    public static void AccountSummaryFeature(){

        String actualTitle;
        String expectedTitle;
        String[] titles = { "Cash Accounts","Investment Accounts",
                "Credit Accounts","Loan Accounts"};

        for (int i = 0; i < titles.length; i++) {

            actualTitle = driver.findElement(By.xpath("(//h2[@class='board-header'])["+ (i+1) +"]")).getText();

            expectedTitle = titles[i];

            Assert.assertEquals(actualTitle,expectedTitle);

        }


    }

    public static void signInTest(String name, String password){
        WebElement usernameInput = driver.findElement(By.xpath("//*[@id='user_login']"));
        usernameInput.sendKeys(name);

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id = 'user_password']"));
        passwordInput.sendKeys(password);

        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }

    public static void staticWait(int seconds) {

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }

    @AfterMethod
    public  void tearDrop(){
        staticWait(2);
        //driver.close();
    }




}
