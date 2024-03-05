package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_02_Selenimum_Locator {
    WebDriver driver;
    String fullName = "Selenium Locator";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login");
    }

    @Test
    public void TC_00_Locator() {

        //Tìm 1 element
        driver.findElement(By.id(""));
        // dùng 1 lần
        driver.findElement(By.cssSelector("")).click();

        // Dùng nhiều lần
        WebElement emailTextbox = driver.findElement(By.id(""));
        String abName = driver.findElement(By.id("")).getText();
        emailTextbox.click();
        emailTextbox.sendKeys();
        emailTextbox.clear();

        //Tìm nhiều element giống nhau
        driver.findElements(By.cssSelector("")).size();
        List<WebElement> textboxes = driver.findElements(By.cssSelector(""));

    }


    @Test
    public void TC_01_ID() throws InterruptedException {
        driver.findElement(By.id("Email")).sendKeys("kien.nguyen@gmail.com");
        Thread.sleep(3000);
    }
    @Test
    public void TC_02_Class() throws InterruptedException {
        // Chỉ nên lấy 1 phần
        driver.findElement(By.className("email")).sendKeys("kien.nguyen@gmail.com");
        Thread.sleep(3000);
    }
    @Test
    public void TC_03_Name() throws InterruptedException {
        driver.findElement(By.name("Email")).sendKeys("kien.nguyen@gmail.com");
        Thread.sleep(3000);
    }
    @Test
    public void TC_04_Link_Text() throws InterruptedException {
        // Chỉ làm việc vs element link, thẻ a, thuộc tính href. Lấy hết text
        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(3000);
    }
    @Test
    public void TC_05_Partial_Link_Text() {
        // Lấy 1 phần text nếu có khoảng trắng, độ chính xác ko cao nên lấy giá trị duy nhất
        driver.findElement(By.partialLinkText("Digital downloads")).click();
        driver.findElement(By.partialLinkText("Digital")).click();
        driver.findElement(By.partialLinkText("downloads")).click();

    }

    @Test
    public void TC_06_Tagname() {
        // Tên thẻ HTML
        // Khi tìm tất cả element giống nhau - Tất cả textbox, radio, checkbox...
        driver.findElements(By.tagName("button"));
        driver.findElements(By.tagName("input"));
        driver.findElements(By.tagName("label"));
    }

    @Test
    public void TC_07_Css() {
        // Cover được cả 6 loại trên
        driver.findElement(By.cssSelector("input#Email"));
        driver.findElement(By.cssSelector("#Email"));
        driver.findElement(By.cssSelector("input[id='Email']"));
        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));
        driver.findElement(By.cssSelector("a[href*='register?']")); // partialLinkText


    }

    @Test
    public void TC_08_Xpath() {
        // Cover được cả 7 loại trên
        driver.findElement(By.xpath("//input[@id='Email']"));
        driver.findElement(By.xpath("//input[@class='email']"));
        driver.findElement(By.xpath("//input[contains(@class,'email')]")); // 1 phan
        driver.findElement(By.xpath("//button[text()='Log in']")); // toan bo
        driver.findElement(By.xpath("//a[text()='Log in']"));

        driver.findElement(By.xpath("//a[text()='Samsung']/parent::h2/following-sibling::div[@class='action']/button"));

    }

    @Test
    public void TC_09_Related_Locator() {
        // New in Selenium 4
        // 1. Được dùng khi không thể định danh được element của chính nó (dựa vào vị trí bên cạnh)
        // 2. Được sử dụng để test GUI - vị trí của element

        // Element/By A
        By passwordTextbox = By.cssSelector("input#Password");
        WebElement passTextbox = driver.findElement(By.cssSelector("input#Password"));

        // Element B
        By rememberMeCheckbox = By.id("RememberMe");

        // Element C
        By forgotPassword = By.cssSelector("span.forgot-password");

        // Element D
        By loginButton = By.cssSelector("button.login-button");

        // Element E
        driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButton) // Label nam tren Login
                .below(passwordTextbox) // duoi password
                .toLeftOf(forgotPassword) // ben trai so vs Pass
                .toRightOf(rememberMeCheckbox) // ben phai so voi rememberMe
                .near(forgotPassword)
                .near(rememberMeCheckbox)
        );

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
