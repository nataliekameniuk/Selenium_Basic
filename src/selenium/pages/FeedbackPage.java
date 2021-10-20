package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.io.File;

import static org.junit.Assert.*;

public class FeedbackPage extends GenericSamplePage {

    WebDriver driver;

    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageInput;
    @FindBy(how = How.NAME, using = "language")
    private List<WebElement> boxLang;
    @FindBy(how = How.NAME, using = "gender")
    private List<WebElement> radioButtonGender;
    @FindBy(how = How.ID, using = "like_us")
    private WebElement likeUsDropDown;
    @FindBy(how = How.NAME, using = "comment")
    private WebElement comment;
    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement sendButton;


    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterAge(int age) {
        enterAge(String.valueOf(age));
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public void setName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public WebElement getAgeInput() {
        return ageInput;
    }

    public void setAgeInput(WebElement ageInput) {
        this.ageInput = ageInput;
    }

    public List<WebElement> getRadioButtonGender() {
        return radioButtonGender;
    }

    public void setRadioButtonGender(List<WebElement> radioButtonGender) {
        this.radioButtonGender = radioButtonGender;
    }


    public void enterAge(String age) {
        ageInput.clear();
        ageInput.sendKeys(age);
    }

    public void clickSend() {
        sendButton.click();
    }

    public void sendComment(String s) {
        comment.sendKeys(s);
    }

    public void langBoxesDefault() {
        assertTrue(!boxLang.get(0).isSelected());
        assertTrue(!boxLang.get(1).isSelected());
        assertTrue(!boxLang.get(2).isSelected());
        assertTrue(!boxLang.get(3).isSelected());
    }
    public void radioButtonsGenderDefault(){
        assertTrue(!radioButtonGender.get(0).isSelected());
        assertTrue(!radioButtonGender.get(1).isSelected());
        assertTrue(radioButtonGender.get(2).isSelected());
    }
    public void likeUsDefault(){
       //
        Select likeUsDropDown = new Select(driver.findElement(By.id("like_us")));
        assertEquals("Choose your option", likeUsDropDown.getFirstSelectedOption().getText());
    }
    public void commentSectionDefault(){
        assertEquals(comment.getText(), null);
    }
    public void sendButtonDefault(){
        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals("rgba(250, 250, 250, 1)", sendButton.getCssValue("color"));
    }
}

