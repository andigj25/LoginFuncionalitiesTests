import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginFunctionalityTests {

    private WebDriver driver;

    @Before
    public void beforeEachTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }

    @After
    public void afterEachTest() {
        driver.quit();
    }

    @Test
    public void TC_1_loginWithValidCredentials() {

        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[class='fa fa-2x fa-sign-in']")).click();

        // Kontrollojme nese nje nga elementet e faqes post login shfaqet
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h4[@class='subheader']")).isDisplayed());

        System.out.println("----------------------- Test finnished -----------------------");
    }

    @Test
    public void TC_2_loginWithInvalidCredentials() {

        driver.findElement(By.cssSelector("input#username")).sendKeys("notTom");
        driver.findElement(By.cssSelector("input#password")).sendKeys("SuperIncorrectSecretPassword!");
        driver.findElement(By.cssSelector("[class='fa fa-2x fa-sign-in']")).click();

        // Identifikojme nese shfaqet error banner, qe mbulon te dy llojet e kredencialeve te gabuara
        String actualAlert = driver.findElement(By.xpath("/html//div[@id='flash']")).getAttribute("class");
        String expectedAlert = "flash error";

        Assert.assertEquals(expectedAlert, actualAlert);

        System.out.println("----------------------- Test finnished -----------------------");


    }

    @Test
    public void TC_3_assertLoginFailAlert() {

        driver.findElement(By.cssSelector("input#username")).sendKeys("notTom");
        driver.findElement(By.cssSelector("input#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[class='fa fa-2x fa-sign-in']")).click();

        String actualMessage = driver.findElement(By.cssSelector("div#flash")).getText();
        String expectedMessage = "Your username is invalid!\n" +
                "×";

        Assert.assertEquals(expectedMessage, actualMessage);

        System.out.println("----------------------- Test finnished -----------------------");


    }
}
