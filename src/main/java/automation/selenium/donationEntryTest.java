package automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class donationEntryTest {
    @Test
    void donation() {

        //This is for chrome browser - local testing
        //WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","/Users/vikassingh/Downloads/chromedriver");
        //driver.get("http://34.93.213.58:8080/food-donation/");
        //driver.manage().window().maximize();


        //This is for firefox browser - remote testing
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "src/main/java/automation/selenium/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("http://34.93.213.58:8080/food-donation/");
        driver.manage().timeouts().implicitlyWait(4,
                TimeUnit.SECONDS);

        //Click on Donate Button
        WebElement element = driver.findElement(By.xpath(".//*[@id=\"section-counter\"]/div/div/div[2]/div/div/p[2]/a"));
        element.click();

        //Enter Your Name
        WebElement element1 = driver.findElement(By.id("price"));
        element1.sendKeys("Puja Singh");

        //Enter Pickup Address
        WebElement element2 = driver.findElement(By.id("description"));
        element2.sendKeys("304, NRI City, Greater Noida");

        //Enter Phone Number
        WebElement element3 = driver.findElement(By.id("productId"));
        element3.sendKeys("9650014233");

        //Enter Date Time.
        WebElement element4 = driver.findElement(By.id("imageUrl"));
        element4.sendKeys("07042020");
        element4.sendKeys(Keys.TAB);
        element4.sendKeys("1100AM");

        //Click on the Submit Button
        WebElement element5 = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/form/div[5]/button"));
        element5.click();

        //Close Fire fox
        driver.quit();
    }

}

