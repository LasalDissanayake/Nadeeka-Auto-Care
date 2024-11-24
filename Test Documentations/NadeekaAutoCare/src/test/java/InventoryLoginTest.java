import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class InventoryLoginTest {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:5174/cLogin");
    }

    @Test
    public void loginTest() {
        // Wrong Username & Wrong Password
        WebElement wrongUsername1 = driver.findElement(By.id("username"));
        wrongUsername1.sendKeys("WrongUserName");
        WebElement wrongPassword1 = driver.findElement(By.name("password"));
        wrongPassword1.sendKeys("WrongPassword");
        WebElement submit1 = driver.findElement(By.name("submit"));
        submit1.click();

        // Handle SweetAlert dialog

        //Sweet alert ekk enna tikk wela ynwa. ek nisa ohoma wait ekk dnwa, ek enkn
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //wait untill ok button ek display wela clickable wenkn
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
        okButton.click();  // Click the OK button

        WebElement clearUsername1 = driver.findElement(By.id("username"));
        clearUsername1.clear();
        WebElement clearPassword1 = driver.findElement(By.name("password"));
        clearPassword1.clear();

        //Wrong Username & Correct Password
        WebElement wrongUsername2 = driver.findElement(By.id("username"));
        wrongUsername2.sendKeys("WrongUserName");
        WebElement CorrectPassword2 = driver.findElement(By.name("password"));
        CorrectPassword2.sendKeys("inventory123");
        WebElement submit2 = driver.findElement(By.name("submit"));
        submit2.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement okButton2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
        okButton2.click();  // Click the OK button
        WebElement clearUsername2 = driver.findElement(By.id("username"));
        clearUsername2.clear();
        WebElement clearPassword2 = driver.findElement(By.name("password"));
        clearPassword2.clear();


        //Correct Username & Wrong Password
        WebElement correctUsername3 = driver.findElement(By.id("username"));
        correctUsername3.sendKeys("inventory");
        WebElement wrongPassword3 = driver.findElement(By.name("password"));
        wrongPassword3.sendKeys("WrongPassword");
        WebElement submit3 = driver.findElement(By.name("submit"));
        submit3.click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement okButton3 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
        okButton3.click();  // Click the OK button
        WebElement clearUsername3 = driver.findElement(By.id("username"));
        clearUsername3.clear();
        WebElement clearPassword3 = driver.findElement(By.name("password"));
        clearPassword3.clear();

        //Empty Username Empty Password
        WebElement emptyUserName = driver.findElement(By.id("username"));
        emptyUserName.sendKeys("");
        WebElement emptyPassword = driver.findElement(By.name("password"));
        emptyPassword.sendKeys("");
        WebElement submit4 = driver.findElement(By.name("submit"));
        submit4.click();
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement okButton4 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
        okButton4.click();  // Click the OK button
        WebElement clearUsername4 = driver.findElement(By.id("username"));
        clearUsername4.clear();
        WebElement clearPassword4 = driver.findElement(By.name("password"));
        clearPassword4.clear();

        //Correct Username Correct Password
        WebElement correctUsername5 = driver.findElement(By.id("username"));
        correctUsername5.sendKeys("inventory");
        WebElement correctPassword5 = driver.findElement(By.name("password"));
        correctPassword5.sendKeys("inventory123");
        WebElement submit5 = driver.findElement(By.name("submit"));
        submit5.click();






    }
}
