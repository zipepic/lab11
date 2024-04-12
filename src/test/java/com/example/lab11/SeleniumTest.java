package com.example.lab11;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    @Test
    public void test(){
        WebDriver driver = new SafariDriver();
        driver.get("http://localhost:8081/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password");

        WebElement button = driver.findElement(By.xpath("//button[text()='Sign in']"));
        button.click();

        String expectedUrl = "http://localhost:8081/login";
        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header//h1[text()='Добро пожаловать']")));


        assertTrue(welcomeMessage.isDisplayed());

        driver.quit();
    }
    @Test
    public void test2(){
        WebDriver driver = new SafariDriver();
        driver.get("http://localhost:8081/login");

        // Fill in the username and password fields and click the "Sign in" button
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password");

        WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement calcButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("clac")));
        calcButton.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement priceField = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("itemPrice")));

        // Теперь элемент "itemPrice" найден и доступен для взаимодействия
        priceField.clear(); // Очищаем поле ввода, если оно уже содержит какое-то значение
        priceField.sendKeys("1000"); // Вводим значение в поле


        WebElement monthsField = driver.findElement(By.id("months"));
        monthsField.clear(); // Clear any existing value
        monthsField.sendKeys("6");


        WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
        calculateButton.click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofMillis(3000));
        // Optionally, you can wait for the result to be displayed
        WebElement salePriceElement = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("p")));
        WebElement redemptionPriceElement = driver.findElement(By.id("pp"));

        // Extract the text of sale price and redemption price elements
        String salePrice = salePriceElement.getText();
        String redemptionPrice = redemptionPriceElement.getText();

        assertEquals("700",salePrice);
        assertEquals("938",redemptionPrice);

        // Close the browser
        driver.quit();

    }
}
