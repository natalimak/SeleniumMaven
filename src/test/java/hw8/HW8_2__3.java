package hw8;/*Open Chrome browser.
Navigate to Google Translate website:  https://translate.google.com/
Find translation box  (where you enter  text  to be translated)  using
2  different locators  and print  the WebElement  you created.
get translate results*/

/*Open FireFox browser.
Navigate to youtube:    https://www.youtube.com/
- Find Youtube button using  id  locator  and print  the WebElement  you created.
 e.g.  System.out.println(driver.findElement…)  */


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW8_2__3 {

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
            driver.get("https://translate.google.com/");

            List<WebElement> elementLists=driver.findElements(By.className("er8xn"));
            System.out.println(elementLists.get(0));
            elementLists.get(0).sendKeys("שלום");

            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

//-----------Print translate result---------------------//
           System.out.println(driver.findElement(By.xpath(
                   "/html/body/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[2]/div[6]/div/div[3]")).getAttribute("data-text"));
        }
      @Test
        public void test_02() {//open site
          driver2.get("https://www.youtube.com/");
          driver2.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
          WebElement input=driver2.findElement(By.id("search"));
          System.out.println(input);
     }

        @AfterClass
        public static void afterAll(){
           System.out.println(driver.getTitle());
           System.out.println(driver2.getTitle());

           driver.quit(); //close session
           driver2.quit();
        }
    }
