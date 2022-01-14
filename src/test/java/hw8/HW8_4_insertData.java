package hw8;/*Open FireFox browser.
Navigate to selenium website: http://www.seleniumhq.org/
Find the search text  field using  name  locator
and  print the WebElement  you created.
e.g.  System.out.println(driver.findElement…)
Send the word “selenium” to this text  box */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW8_4_insertData {
    private static WebDriver driver2;

    @BeforeClass
    public static void beforeAll() {

        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\geckodriver.exe");

        FirefoxOptions options1 = new FirefoxOptions();
        driver2 = new FirefoxDriver(options1);
    }

    @Test
    public void test_02() {//open site
        driver2.get("https://www.selenium.dev");
        driver2.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement input = driver2.findElement(By.className("form-control"));
        input.click();
        input.sendKeys("selenium");
        System.out.println(input);

    }

    @AfterClass
    public static void afterAll() {
        System.out.println(driver2.getTitle());

        driver2.quit(); //close session

    }
}
