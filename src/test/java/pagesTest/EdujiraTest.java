package pagesTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import pages.*;
import webHooks.WebHooks;


import static com.codeborne.selenide.WebDriverConditions.title;

public class EdujiraTest extends WebHooks {
    static EdujiraHomePage dashboard;
    static EdujiraProjectPage project;
    static EdujiraIssuePage issuePage;
    static int initialIssuesCount;

    @Test
    public void loginTest() {
        dashboard = new EdujiraLoginPage()
                .login("AT10", "Qwerty123");

        Assertions.assertThat(title("System Dashboard - Jira"));
    }

    @Test
    public void openProjectTest() {
        loginTest();
        project = dashboard.openTestProject();
        Assertions.assertThat(title("TEST"));
    }

    @Test
    public void verifyIssuesCountTest() {
        openProjectTest();

        initialIssuesCount = project.getInitialIssuesCount();
        project.clickCreateIssue()
                .createBug("Проверка счетчика AT10");
        project.verifyIssuesCountIncreased(initialIssuesCount);
    }

    @Test
    public void verifyIssueDetailsTest() {
        openProjectTest();
        project.openIssuePage("TestSeleniumATHomework")
                .verifyIssueDetails("СДЕЛАТЬ", "Version 2.0");
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