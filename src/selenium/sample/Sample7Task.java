package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void selectCheckBox() throws Exception {
//         TODO:
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
//        check that none of the checkboxes are ticked
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
        }
//        tick  "Option 2"
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        option2.click();

//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        assertFalse(driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox']")).isSelected());
        assertTrue(driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']")).isSelected());
        assertFalse(driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']")).isSelected());

//        tick  "Option 3"
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        option3.click();

//        click result
        WebElement resultButton = driver.findElement(By.cssSelector("#result_button_checkbox"));
        resultButton.click();
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        assertEquals(driver.findElement(By.cssSelector("#result_checkbox")).getText(), "You selected value(s): Option 2, Option 3");
    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected()); // radio are NOT selected
        }
//        select  "Option 3"
        WebElement option3Button = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio']"));
        option3Button.click();
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        WebElement option1Button = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio']"));
        WebElement option2Button = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']"));
        for (WebElement radioButton : radioButtons) {
            assertFalse(option1Button.isSelected()); // radio1 is NOT selected
            assertFalse(option2Button.isSelected());
            assertTrue(option3Button.isSelected());
        }
//        select  "Option 1"
        option1Button.click();
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        for (WebElement radioButton : radioButtons) {
            assertTrue(option1Button.isSelected());
            assertFalse(option2Button.isSelected());
            assertFalse(option3Button.isSelected());
        }
//        click result
        WebElement resultRadioButton = driver.findElement(By.cssSelector("#result_button_ratio"));
        resultRadioButton.click();

//        check that 'You selected option: Option 1' text is being displayed
       assertEquals(driver.findElement(By.cssSelector("#result_radio")).getText(), "You selected option: Option 1");



    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        dropdown.selectByValue("value3");
//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());
//        select "Option 2" in Select
        dropdown.selectByValue("value2");
//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
//        click result
        WebElement resultDropdown = driver.findElement(By.cssSelector("#result_button_select"));
        resultDropdown.click();
//        check that 'You selected option: Option 2' text is being displayed
        assertEquals(driver.findElement(By.cssSelector("#result_select")).getText(), "You selected option: Option 2");
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
    }
}
