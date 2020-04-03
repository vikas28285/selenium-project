package automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class donationEntryTest {
    @Test
    void donation() {

        //This is for chrome browser - local testing
        //WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","/Users/vikassingh/Downloads/chromedriver");
        //driver.get("http://34.93.213.58:8080/food-donation/");

        //This is for chrome browser - remote testing
        //System.setProperty("webdriver.chrome.driver", "src/main/java/automation/selenium/chromedriver");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //WebDriver driver = new ChromeDriver(chromeOptions);
        //driver.navigate().to("http://34.93.213.58:8080/food-donation/");

        //This is for Firefox browser - remote testing
        System.setProperty("webdriver.gecko.driver", "src/main/java/automation/selenium/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        //WebDriver driver = new FirefoxDriver();
        driver.get("http://34.93.213.58:8080/food-donation/");

        //Maximize the browser window
        //driver.manage().window().maximize();

        //Click on Donate Button
        WebElement element = driver.findElement(By.xpath(".//*[@id=\"section-counter\"]/div/div/div[2]/div/div/p[2]/a"));
        element.click();

        //Enter Your Name
        WebElement element1 = driver.findElement(By.id("price"));
        element1.sendKeys("Puja Singh");

        //Enter Pickup Address
        WebElement element2 = driver.findElement(By.id("description"));
        element2.sendKeys("303, NRI City, Greater Noida");

        //Enter Phone Number
        WebElement element3 = driver.findElement(By.id("productId"));
        element3.sendKeys("9650014233");

        //Enter Date Time.
        WebElement element4 = driver.findElement(By.id("imageUrl"));
        element4.sendKeys("04042020");
        element4.sendKeys(Keys.TAB);
        element4.sendKeys("1100AM");

        //Click on the Submit Button
        WebElement element5 = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/form/div[5]/button"));
        element5.click();

        //Close Fire fox
        driver.close();
    }

}

