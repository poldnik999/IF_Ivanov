import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import pages.*;



import static com.codeborne.selenide.WebDriverConditions.title;
import static org.assertj.core.api.Assertions.assertThat;

public class EdujiraTest extends WebHooks {
    static EdujiraHomePage dashboard;
    static EdujiraProjectPage project;
    static EdujiraIssuePage issuePage;
    static int initialIssuesCount;

    @Test
    @Order(1)
    public void loginTest() {
        dashboard = new EdujiraLoginPage()
                .login("AT10", "Qwerty123");

        Assertions.assertThat(title("System Dashboard - Jira"));
    }

    @Test
    @Order(2)
    public void openProjectTest() {
        loginTest();
        project = dashboard.openTestProject();
        Assertions.assertThat(title("TEST"));
    }

    @Test
    @Order(3)
    public void verifyIssuesCountTest() {
        openProjectTest();

        initialIssuesCount = project.getInitialIssuesCount();
        project.clickCreateIssue()
                .createBug("Проверка счетчика AT10");
        project.verifyIssuesCountIncreased(initialIssuesCount);
    }

    @Test
    @Order(4)
    public void verifyIssueDetailsTest() {
        openProjectTest();
        project.openIssuePage("TestSeleniumATHomework")
                .verifyIssueDetails();
    }

    @Test
    public void createAndCloseBugTest() {
        openProjectTest();
        project.clickCreateIssue()
                .createBug("Проверка создания задачи AT10",
                        "blablabla",
                        "blabla",
                        "test",
                        "Version 1.0",
                        "Version 1.0",
                        "Тривиальный")
                .openIssuePage("Проверка создания задачи AT10")
                .completeIssue();
    }
}