package com.cydeo.tasks.reviewTasks1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.security.Key;

public class CartTest1 {

    @Test
    public void TC1(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        String testText = ConfigurationReader.getProperty("searchText");
        searchBox.sendKeys(testText + Keys.ENTER);

        WebElement firstProduct = driver.findElement(By.xpath("(//img[@class = 's-image'])[1]"));
        firstProduct.click();


        //dropdown menu

        WebElement dropdown = driver.findElement(By.xpath("(//select[@id='quantity'])"));
        Select select = new Select(dropdown);
        select.selectByValue("2");


        WebElement selection2 = driver.findElement(By.xpath("//li[@aria-labelledby = 'quantity_1']"));
        selection2.click();

        WebElement addToChart = driver.findElement(By.id("add-to-cart-button"));
        addToChart.click();

//        WebElement itemText = driver.findElement(By.xpath("//span[@id='sw-subtotal-item-count']"));
//        String actualItemText1 = itemText.getText();
//        //System.out.println("actualItemText1 = " + actualItemText1);
//        String expectedItemText1 = "Cart subtotal (2 items):";
//
//        Assert.assertEquals(actualItemText1,expectedItemText1);
//        System.out.println("expectedItemText1 = " + expectedItemText1);

        WebElement priceItem1 = driver.findElement(By.xpath("//span[.='$39.98']"));
        String actualPriceItem1Text = priceItem1.getText();
        String expectedPriceItem1Text = "$39.98";

        Assert.assertEquals(actualPriceItem1Text,expectedPriceItem1Text);
        System.out.println("expectedPriceItem1Text = " + expectedPriceItem1Text);

        WebElement addToChartButton = driver.findElement(By.xpath("//a[@href='/gp/cart/view.html?ref_=sw_gtc']"));
        addToChartButton.click();




    }
}