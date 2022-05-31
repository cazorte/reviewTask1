package com.cydeo.tasks.reviewTasks1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {

    @Test
    public void testTask2() {

       WebDriver driver = Driver.getDriver();
       driver.get("https://moneygaming.qa.gameaccount.com/");

        WebElement joinButton = driver.findElement(By.xpath("//*[.='Join Now!']"));
        joinButton.click();

        //select dropdown

        Select select = new Select(driver.findElement(By.xpath("//select[@name='map(title)']")));
        select.selectByValue("Mr");

        //enter name and surname

        WebElement name = driver.findElement(By.name("map(firstName)"));
        name.sendKeys("Anil");
        WebElement surname = driver.findElement(By.name("map(lastName)"));
        surname.sendKeys("Aydemir");

        //dropdown selection
        WebElement checkBox = driver.findElement(By.name("map(terms)"));
        checkBox.click();
        if (checkBox.isSelected()) {
            System.out.println("checkbox is selected");
        }

        WebElement joinButton2 = driver.findElement(By.xpath("//input[@value='Join Now!']"));
        joinButton2.click();

        WebElement messageUnderBirth = driver.findElement(By.xpath("//select[@name='map(dobYear)']/following-sibling::label"));
        String actualMessage = messageUnderBirth.getText();
        System.out.println("actualMessage = " + actualMessage);
        String expectedMeesage = "This field is required";

        Assert.assertEquals(actualMessage,expectedMeesage);











    }
}
