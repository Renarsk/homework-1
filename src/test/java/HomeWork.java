import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomeWork {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode='primary']");
    private final By COMMENTS = By.xpath(".//span[@class='list-article__comment section-font-color']");
    private final By ALL_HEADERS_OF_ARTICLES = By.xpath(".//span[@class='list-article__headline']");
    private final By LOGO = By.xpath(".//img[@alt='Postimees']");
    private final By RUS = By.linkText("RUS");


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

    @Test
    public void printArticlesWithCommentCountInConsole() {
        System.setProperty("webdriver.chrome.driver", "/Users/iMac/chromedriver");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("http://tvnet.lv"); // always http to check https

        WebDriverWait wait = new WebDriverWait(chrome, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        chrome.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> allTitles = chrome.findElements(ALL_HEADERS_OF_ARTICLES);
        List<WebElement> allComments = chrome.findElements(COMMENTS);

       /* if(allComments.isEmpty() && allTitles.isEmpty()){
            System.out.println(allComments.getText() + " " + allTitles.getText());
        }*/


        for (int i = 0; i < allComments.size(); i++) {
            if (!allComments.get(i).getText().isEmpty()) {
                System.out.println(allComments.get(i).getText() + " " + allTitles.get(i).getText());
            }
        }


    }

   /* List<WebElement> titles = driver.findElements(ARTICLES);

    //----------------- FOR -----------------------
        for (int i = 0; i < titles.size(); i++) {

        if (!titles.get(i).getText().isEmpty()) {
            System.out.println(i + ": " + titles.get(i).getText());
        }
    }

    //----------------- FOREACH --------------------
        for (WebElement we : titles) {
        if (!we.getText().isEmpty()) {
            System.out.println(we.getText());
        } else {
            System.out.println("-------------");
        }
        // Short version of If Else   ? true : false (else)
        System.out.println(we.getText().isEmpty() ? "-------" : we.getText());*/


}
