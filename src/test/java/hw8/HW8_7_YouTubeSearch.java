package hw8;/*Open Youtube  web page
Type  a name of a song  (any)
Click  on search.*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW8_7_YouTubeSearch {
        private static WebDriver driver;

        @BeforeClass
        public static void beforeAll() {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            FirefoxOptions options1=new FirefoxOptions();
            driver = new ChromeDriver(options);
        }

        @Test
        public void test_02() {//open site
            driver.get("https://www.youtube.com/");
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

            var search = driver.findElements(By.tagName("input"));
            for (int i = 0; i < search.size(); i++) {
                if (search.get(i).getAttribute("autocomplete").equals("off")) {
                    search.get(i).sendKeys("OZZY");
                    search.get(i).submit();
                }
            }
        }
            @AfterClass
            public static void afterAll () {
                System.out.println(driver.getTitle());
                // driver.quit(); //close session

            }
        }


