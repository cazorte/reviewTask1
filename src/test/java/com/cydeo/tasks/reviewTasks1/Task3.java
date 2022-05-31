package com.cydeo.tasks.reviewTasks1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.*;

public class Task3 {

    static WebDriver driver= Driver.getDriver();

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

//        WebElement username = driver.findElement(By.xpath("//*[@id='user_login']"));
//        username.sendKeys("usernameEach");
//
//        WebElement password = driver.findElement(By.xpath("//*[@id = 'user_password']"));
//        password.sendKeys("passwordEach");

    }

    public static void signInTest(String name, String password){
        WebElement usernameInput = driver.findElement(By.xpath("//*[@id='user_login']"));
        usernameInput.sendKeys(name);

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id = 'user_password']"));
        passwordInput.sendKeys(password);

        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }

    @AfterMethod
    private void tearDrop(){
        driver.close();
    }




}
