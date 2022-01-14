package hw8;/*Write a  TestNG  test  that  will open the following:
        a.  Chrome  –   https://www.walla.co.il
        b.  FireFox  –   https://www.ynet.co.il    */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HW8_1 {

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
        public void test_01(){//open site
            driver.get("https://www.walla.co.il");
            driver2.get("https://www.ynet.co.il");
        }

        @AfterClass
        public static void afterAll(){
            System.out.println(driver.getTitle());
            System.out.println(driver2.getTitle());

            driver.quit(); //close session
        }
    }
