package hw8;/*Open Chrome browser  on Amazon  website:   https://www.amazon.com/
Assert  website title.
Search  for “Leather  shoes”. */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW8_5_AmazonSite {

    private static WebDriver driver2;
    String title="Amazon.com. Spend less. Smile more.";

    @BeforeClass
    public static void beforeAll() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        driver2 = new ChromeDriver(options);
    }

    @Test
    public void test_01() {//open site
        driver2.get("https://www.amazon.com");
        driver2.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @Test
    public void test_02() {//open site
        Assert.assertEquals(driver2.getTitle(),title);
    }
    @Test
    public void test_03() {//open site
        WebElement input = driver2.findElement(By.id("twotabsearchtextbox"));
        input.click();
        input.sendKeys("Leather shoes");
        input.submit();
        System.out.println(input);
    }

    @AfterClass
    public static void afterAll() {
        System.out.println(driver2.getTitle());

        driver2.quit(); //close session

    }
}
