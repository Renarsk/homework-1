import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PrintArticlesWithCommentCount {

    private final Logger LOGGER = LogManager.getLogger(HomeWork.class);

    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode='primary']");
    private final By COMMENTS = By.xpath(".//span[@class='list-article__comment section-font-color']");
    private final By ALL_HEADERS_OF_ARTICLES = By.xpath(".//span[@class='list-article__headline']");
    private final By ARTICLES_BLOCK = By.xpath(".//div[@class='list-article__text']");

    @Test
    public void printArticlesWithCommentCountInConsole() {
        LOGGER.info("Driver connected");
        System.setProperty("webdriver.chrome.driver", "/Users/iMac/chromedriver");
        LOGGER.info("Driver loading");
        WebDriver chrome = new ChromeDriver();
        LOGGER.info("Window resizing");
        chrome.manage().window().maximize();
        LOGGER.info("Visiting Tvnet.lv");
        chrome.get("http://tvnet.lv"); // always http to check https
        LOGGER.info("Creating waiting parameters");
        WebDriverWait wait = new WebDriverWait(chrome, 10);
        LOGGER.info("Waiting for advert btn");
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        LOGGER.info("Clicking advert btn");
        chrome.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> headers = chrome.findElements(ARTICLES_BLOCK);
        WebElement header = headers.get(0);

        String homePageTitle = header.findElement(ALL_HEADERS_OF_ARTICLES).getText();

        int homePageCommentsCount = 0;

        if (!header.findElements(COMMENTS).isEmpty()) {
            String commentsCount = header.findElement(COMMENTS).getText();
            commentsCount = commentsCount.substring(1, commentsCount.length() - 1);
            homePageCommentsCount = Integer.parseInt(commentsCount);
        }

        System.out.println(homePageTitle + " " + homePageCommentsCount);



    }


}
