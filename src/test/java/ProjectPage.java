import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectPage extends Tests {

    @FindBy(how = How.XPATH, using = "//a[@id='create_link']")
    private SelenideElement btnCreateTask;

    @FindBy(how = How.XPATH, using = "//input[@id='summary']")
    private SelenideElement taskNameLane;

    @FindBy(how = How.XPATH, using = "//*[@id='description']")
    private SelenideElement taskInfo;

    @FindBy(how = How.XPATH, using = "//input[@id='create-issue-submit']")
    private SelenideElement btnSubmitTask;

    @FindBy(how = How.XPATH, using = "//*[@id='aui-flag-container']/div/div/a")
    private SelenideElement taskLink;

    public ProjectPage clickBtnIn() {
        btnCreateTask.click();
        return page(ProjectPage.class);
    }

    public ProjectPage clickTaskNameLane() {
        taskNameLane.click();
        taskNameLane.sendKeys(taskName);
        System.out.println("Задано название задачи");
        return page(ProjectPage.class);
    }

    public ProjectPage clickTaskInfo() {
        $(By.xpath("//*[@id='aui-uid-1']")).click();
        taskInfo.sendKeys(taskInfoText);
        System.out.println("Задано описание задачи");
        return page(ProjectPage.class);
    }

    public ProjectPage clickSubmitTask() {
        btnSubmitTask.click();
        System.out.println("Задача создана");
        return page(ProjectPage.class);
    }

    public ProjectPage clickTaskLink() {
        taskLink.click();
        return page(ProjectPage.class);
    }

    public ProjectPage taskWork() {
        $(By.xpath("//a[@id='action_id_21']")).click();
        System.out.println("Задаче присвоен статус \"В работе\"");
        $(By.xpath("//a[@id='opsbar-transitions_more']")).click();
        $(By.xpath("//a[@id='action_id_31']")).click();
        System.out.println("Задано присвоен статус \"ГОТОВО\"");
        assertTrue($x("//a[@id='action_id_31']").shouldBe(visible, Duration.ofSeconds(60)).exists());
        String taskStatus = $x("//*[@id='status-val']/span").text();
        String status = "ГОТОВО";
        Assert.assertEquals(taskStatus, status);
        System.out.println("Статус задачи отображается корректно");
        return page(ProjectPage.class);
    }
}
