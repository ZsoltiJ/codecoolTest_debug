package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BlogPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class BlogTest {

    WebDriver webdriver;
    MainPage mainPage;
    BlogPage blogPage;


    @BeforeEach
    public void Init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--headless");
        webdriver = new ChromeDriver(options);
        webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();
    }

    @Test
    public void blogTest()  {
        mainPage = new MainPage(webdriver);
        mainPage.navigateTo();
        mainPage.changeLanguage();
        mainPage.clickOnBlog();
        blogPage = new BlogPage(webdriver);
        boolean result = blogPage.selectArticle("full-stack developer");


        Assertions.assertTrue(result);




    }
    @AfterEach
    public void quitDriver(){
        webdriver.quit();
    }
}
