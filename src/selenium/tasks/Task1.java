package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import java.io.File;


public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test

    public void errorOnText() {
//        TODO
        WebElement numberField = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
//        enter a text instead of a number, check that correct error is seen
        numberField.sendKeys("fhfhfhfh");
        submitButton.click();
        String errorMsg=driver.findElement(By.id("ch1_error")).getText();
        System.out.println(errorMsg);
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
       WebElement numberField = driver.findElement(By.id("numb"));
      WebElement submitButton = driver.findElement(By.className("w3-btn"));
//        enter number which is too small (below 50), check that correct error is seen
       numberField.sendKeys("30");
     submitButton.click();
        String errorMsg=driver.findElement(By.id("ch1_error")).getText();
       System.out.println(errorMsg);

    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement numberField = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
//        enter number which is too small (below 50), check that correct error is seen
        numberField.sendKeys("121");
        submitButton.click();
        String errorMsg=driver.findElement(By.id("ch1_error")).getText();
        System.out.println(errorMsg);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement numberField = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        numberField.sendKeys("64");
        submitButton.click();
        Alert alert = driver.switchTo().alert(); // switch to alert
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
