package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver webdriver;

    private final String URL = "https://codecool.com/hu/";
    private final By BLOG_BUTTON = By.xpath("/html/body/header/div/div/nav/ul[1]/li[3]/a");
    private final By ENGLISH_BUTTON = By.xpath("/html/body/header/div/div/nav/ul[2]/li[2]/div/div/a[1]");
    private final By LANGUAGE_BUTTON = By.xpath("//*[@class='languages__label']");
    private final By LANGUAGE_CHOSEN_BUTTON = By.xpath(" /html/body/header/div/div/nav/ul[2]/li[2]/div/span/i/svg");



    public MainPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void navigateTo(){
          webdriver.get(URL);

    }

    public void clickOnBlog(){
        webdriver.findElement(BLOG_BUTTON).click();
    }



    public CodecoolEnglishPage changeLanguage(){
        String languageCode = webdriver.findElement(LANGUAGE_BUTTON).getText();
        if ( !languageCode.equalsIgnoreCase("en ")){
            webdriver.findElement(LANGUAGE_BUTTON).click();
            webdriver.findElement(ENGLISH_BUTTON).click();
        }
        return new CodecoolEnglishPage(webdriver);
    }






}
