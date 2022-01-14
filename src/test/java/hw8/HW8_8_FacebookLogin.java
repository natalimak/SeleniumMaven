package hw8;/*Open Chrome browser  on Facebook  website https://www.facebook.com/
Login into Facebook  (No need to send me  credentials).*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW8_8_FacebookLogin {
    private static WebDriver driver;
    private static WebDriver driver2;

    @BeforeClass
    public static void beforeAll() {
       System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");

       System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\geckodriver.exe");

        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options1=new FirefoxOptions();
        driver = new ChromeDriver(options);
        driver2 = new FirefoxDriver(options1);
    }

    @Test
    public void test_01()   {//open site
        driver.get("https://facebook.com/");

        List<WebElement> elementLists=driver.findElements(By.name("email"));
        System.out.println(elementLists.get(0));
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        elementLists.get(0).sendKeys("test@gmail.com");

        List<WebElement> pass=driver.findElements(By.name("pass"));
        pass.get(0).sendKeys("1234");

        List<WebElement> submit=driver.findElements(By.name("login"));
        submit.get(0).submit();
    }

    @Test
    public void test_02() {//open site
        driver2.get("https://facebook.com/");
        driver2.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement input = driver2.findElement(By.name("email"));

        input.sendKeys("test1@gmail.com");
        WebElement pass = driver2.findElement(By.name("pass"));
        pass.sendKeys("1111");

        List<WebElement> submit=driver2.findElements(By.name("login"));
        submit.get(0).submit();
        System.out.println(input);
        }
    @AfterClass
    public static void afterAll () {
       System.out.println(driver.getTitle());
       System.out.println(driver2.getTitle());

        //driver.quit(); //close session
    }
}
