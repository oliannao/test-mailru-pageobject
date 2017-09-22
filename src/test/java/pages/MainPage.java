import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends Page {
    private final String URL = "http://mail.ru";

    private final By findLogin = By.id("mailbox__login");
    private final By findPassword = By.id("mailbox__password");
    private final By findLoginDomain = By.id("mailbox__login__domain");
    private final By findAuthButton = By.id("mailbox__auth__button");

    private final String login = "rebenokan";
    private final String password = "galina2010";
    private final By login__domain = By.id("mailbox__login__domain");

    private final String domen = "@inbox.ru";

    private WebElement elementLogin = null;
    private WebElement elementPassorw = null;
    private WebElement elementLoginDomain = null;
    private WebElement elementAutButton = null;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(URL);
    }

    public void findMailboxLoginAndPassword() {
        elementLogin = driver.findElement(findLogin);
        elementPassorw = driver.findElement(findPassword);
        elementLoginDomain = driver.findElement(findLoginDomain);
        elementAutButton = driver.findElement(findAuthButton);

    }

    public MessagesPage enterLoginAndPassword() {
        elementLogin.sendKeys(login);
        elementPassorw.sendKeys(password);
        new Select(elementLoginDomain).selectByVisibleText(domen);
        elementAutButton.click();
        return new MessagesPage(driver);

    }

}