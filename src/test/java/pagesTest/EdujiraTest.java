package pagesTest;

import config.ConfigLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.EdujiraHomePage;
import pages.EdujiraLoginPage;
import pages.EdujiraProjectPage;
import webHooks.WebHooks;

@DisplayName("UI тесты Edujira")
public class EdujiraTest extends WebHooks {

    private static EdujiraHomePage dashboard;
    private static EdujiraProjectPage project;

    private static ConfigLoader prop = new ConfigLoader();

    @Test
    @DisplayName("Авторизация пользователя")
    public void loginTest() {
        dashboard = new EdujiraLoginPage()
                .fillAuthField(prop.getProperty("user.login"), prop.getProperty("user.password"))
                .assertFieldIsFill()
                .login()
                .assertNewPageIsOpen();
    }

    @Test
    @DisplayName("Открытие проекта")
    public void openProjectTest() {
        loginTest();
        project = dashboard
                .openProject(prop.getProperty("project.name"))
                .assertNewPageIsOpen(prop.getProperty("project.name"));

    }

    @Test
    @DisplayName("Проверка счетчика задач")
    public void verifyIssuesCountTest() {
        openProjectTest();
        int initialIssuesCount = project.getInitialIssuesCount();
        project.clickCreateIssue()
                .assertNewPageIsOpen()
                .fillIssueForm(prop.getProperty("issue.counter.name") + " " + prop.getProperty("user.login"))
                .createIssue()
                .assertIssuesCountIncreased(initialIssuesCount);
    }

    @Test
    @DisplayName("Проверка статуса и версии задачи")
    public void verifyIssueDetailsTest() {
        openProjectTest();
        project.openIssuePage(prop.getProperty("issue.verify.name"))
                .assertNewPageIsOpen(prop.getProperty("issue.verify.name"))
                .assertIssueDetails(
                        prop.getProperty("issue.verify.status"),
                        prop.getProperty("issue.verify.version")
                );
    }

    @Test
    @DisplayName("Создание задачи и закрытие")
    public void createAndCloseBugTest() throws InterruptedException {
        openProjectTest();
        String issueName = prop.getProperty("issue.create.name") + " " + prop.getProperty("user.login");

        project.clickCreateIssue()
                .assertNewPageIsOpen()
                .fillIssueForm(
                        issueName,
                        prop.getProperty("issue.create.desc"),
                        prop.getProperty("issue.create.env"),
                        prop.getProperty("issue.create.tags"),
                        prop.getProperty("issue.create.fVersion"),
                        prop.getProperty("issue.create.tVersion"),
                        prop.getProperty("issue.create.serious"))
                .createIssue()
                .openIssuePage(issueName)
                .assertNewPageIsOpen(issueName)
                .completeIssue()
                .assertIssueDetails(prop.getProperty("issue.create.status"));
    }
}