package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BlogPage {

    WebDriver webdriver;

    private final By BLOG_ARTICLES = By.xpath("//*[@id=\"wp--skip-link--target\"]/section[3]/div/article");
    private final By BLOG_ARTICLES_TEXT = By.xpath(".//h6//a");

    public BlogPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public boolean selectArticle(String title) {
        boolean result = false;
        List<WebElement> articles = webdriver.findElements(BLOG_ARTICLES);
        for (WebElement article : articles) {
            WebElement link = article.findElement(BLOG_ARTICLES_TEXT);
         //   System.out.println(link.getText());      //  s.toLowerCase().contains("ABCD".toLowerCase());
            if (link.getText().toLowerCase().contains(title.toLowerCase())) {
                WebDriverWait wait = new WebDriverWait(webdriver, 10);
                wait.until(ExpectedConditions.elementToBeClickable(link));
                link.click();
                result = true;
            }

        }
        return result;
    }
}
