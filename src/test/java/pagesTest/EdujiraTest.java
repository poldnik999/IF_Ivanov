package pagesTest;

import config.ConfigLoader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.EdujiraHomePage;
import pages.EdujiraLoginPage;
import pages.EdujiraProjectPage;
import webHooks.WebHooks;

import static com.codeborne.selenide.WebDriverConditions.title;

@DisplayName("Edujira Test")
public class EdujiraTest extends WebHooks {
    static EdujiraHomePage dashboard;
    static EdujiraProjectPage project;
    static int initialIssuesCount;

    private static ConfigLoader prop = new ConfigLoader();

    @Test
    @DisplayName("Авторизация пользователя")
    public void loginTest() {
        dashboard = new EdujiraLoginPage()
                .login(prop.getProperty("user.login"), prop.getProperty("user.password"));

        Assertions.assertThat(title("System Dashboard - Jira"));
    }

    @Test
    @DisplayName("Открытие проекта TEST")
    public void openProjectTest() {
        loginTest();
        project = dashboard.openTestProject();
        Assertions.assertThat(title(prop.getProperty("project.name")));
    }

    @Test
    @DisplayName("Проверка счетчика задач")
    public void verifyIssuesCountTest() {
        openProjectTest();
        initialIssuesCount = project.getInitialIssuesCount();
        project.clickCreateIssue()
                .createBug(
                        prop.getProperty("issue.counter.name") + " " +
                                prop.getProperty("user.login")
                );
        project.verifyIssuesCountIncreased(initialIssuesCount);
    }

    @Test
    @DisplayName("Проверка статуса и версии задачи")
    public void verifyIssueDetailsTest() {
        openProjectTest();
        project.openIssuePage(prop.getProperty("issue.verify.name"))
                .verifyIssueDetails(
                        prop.getProperty("issue.verify.status"),
                        prop.getProperty("issue.verify.version")
                );
    }

    @Test
    @DisplayName("Создание задачи и закрытие")
    public void createAndCloseBugTest() {
        openProjectTest();
        String issueName = prop.getProperty("issue.create.name") + " " + prop.getProperty("user.login");

        project.clickCreateIssue()
                .createBug(issueName,
                        prop.getProperty("issue.create.desc"),
                        prop.getProperty("issue.create.env"),
                        prop.getProperty("issue.create.tag"),
                        prop.getProperty("issue.create.fVersion"),
                        prop.getProperty("issue.create.tVersion"),
                        prop.getProperty("issue.create.serious"))
                .openIssuePage(issueName)
                .completeIssue();
    }
}