import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage extends Tests {
    @FindBy(how = How.XPATH, using = "//a[@id='browse_link']")
    private SelenideElement projectsLink;

    @FindBy(how = How.XPATH, using = "//a[@id='admin_main_proj_link_lnk']")
    private SelenideElement testsLink;

    @FindBy(how = How.XPATH, using = "//a[@class='aui-nav-item ']")
    private SelenideElement testsSection;


    public DashboardPage clickProjectsLink() {
        projectsLink.click();
        return page(DashboardPage.class);
    }

    public DashboardPage clickTestsLink() {
        testsLink.click();
        return page(DashboardPage.class);
    }

    public DashboardPage clickTasks() {
        testsSection.click();
        return page(DashboardPage.class);
    }


    public DashboardPage findValue() {
        String[] tasksCount = $x("//div[@class='ghx-issue-count']").text().split(" ");
        int tasksValue = Integer.parseInt(tasksCount[0]);

        int content = $$(By.xpath("//div[@class='ghx-issue-content']")).size();

        Assert.assertEquals(tasksValue, content);

        System.out.println("Количество задач в списке: " + tasksValue);
        System.out.println("Количество строк с задачами: " + content);
        return page(DashboardPage.class);
    }



}