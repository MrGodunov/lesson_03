import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Tests {

    String login = "anGodunov";
    String password = "123qaz!@#QAZ";
    String taskName = "Godunov";
    String taskInfoText = "Описание тестового бага";

    @BeforeAll
    static void TestBefore() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterAll
    static void TestAfter() {
        closeWebDriver();
    }

    @Test
    public void Test1() {
        Selenide.open("https://edujira.ifellow.ru/login.jsp", AuthorizationPage.class)
                .clickBtnLogin()
                .clickBtnPassword()
                .clickBtnIn();

        Selenide.open("https://edujira.ifellow.ru/", DashboardPage.class)
                .clickProjectsLink()
                .clickTestsLink()
                .clickTasks()
                .findValue();
        closeWebDriver();
    }

    @Test
    public void Test2() {
        Selenide.open("https://edujira.ifellow.ru/login.jsp", AuthorizationPage.class)
                .clickBtnLogin()
                .clickBtnPassword()
                .clickBtnIn();

        Selenide.open("https://edujira.ifellow.ru/", ProjectPage.class)
                .clickBtnIn()
                .clickTaskNameLane()
                .clickTaskInfo()
                .clickSubmitTask()
                .clickTaskLink()
                .taskWork();
    }
}
