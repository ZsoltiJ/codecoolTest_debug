package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CodecoolEnglishPage {

    WebDriver webdriver;

    private final By BLOG_BUTTON = By.xpath("/html/body/header/div/div/nav/ul[1]/li[3]/a");


    public CodecoolEnglishPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public BlogPage clickOnBlogButton(){
        webdriver.findElement(BLOG_BUTTON).click();
        return new BlogPage(webdriver);
    }


}
