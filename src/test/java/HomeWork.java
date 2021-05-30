import okhttp3.internal.http2.Header;
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

public class HomeWork {
    private final Logger LOGGER = LogManager.getLogger(HomeWork.class);

    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode='primary']");
    private final By COMMENTS = By.xpath(".//span[@class='list-article__comment section-font-color']");
    private final By ALL_HEADERS_OF_ARTICLES = By.xpath(".//span[@class='list-article__headline']");
    private final By LOGO = By.xpath(".//img[@alt='Postimees']");
    private final By RUS = By.linkText("RUS");
    private final By ARTICLES_BLOCK = By.xpath(".//div[@class='list-article__text']");

    @Test
    public void firstArticleComent() {
        System.setProperty("webdriver.chrome.driver", "/Users/iMac/chromedriver");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("http://tvnet.lv"); // always http to check https

        WebDriverWait wait = new WebDriverWait(chrome, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        chrome.findElement(ACCEPT_COOKIES_BTN).click();
        chrome.findElement(COMMENTS).click();
    }

    @Test
    public void clickRusLang() {
        System.setProperty("webdriver.chrome.driver", "/Users/iMac/chromedriver");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("http://tvnet.lv"); // always http to check https

        WebDriverWait wait = new WebDriverWait(chrome, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        chrome.findElement(ACCEPT_COOKIES_BTN).click();
        chrome.findElement(RUS).click();

    }

    @Test
    public void printFirstArticleInConsole() {
        System.setProperty("webdriver.chrome.driver", "/Users/iMac/chromedriver");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("http://tvnet.lv"); // always http to check https

        WebDriverWait wait = new WebDriverWait(chrome, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        chrome.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> titles = chrome.findElements(ALL_HEADERS_OF_ARTICLES);

        for (int i = 0; i < 1; i++) {
            if (!titles.get(i).getText().isEmpty()) {
                System.out.println(titles.get(i).getText());
            }
        }


    }

    @Test
    public void printAllArticlesInConsole() {
        System.setProperty("webdriver.chrome.driver", "/Users/iMac/chromedriver");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("http://tvnet.lv"); // always http to check https

        WebDriverWait wait = new WebDriverWait(chrome, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        chrome.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> titles = chrome.findElements(ALL_HEADERS_OF_ARTICLES);

        for (int i = 0; i < titles.size(); i++) {
            if (!titles.get(i).getText().isEmpty()) {
                System.out.println(titles.get(i).getText());
            }
        }


    }


    // Gets article title with comment count

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
