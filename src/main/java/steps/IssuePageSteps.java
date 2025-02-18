package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import pages.EdujiraIssuePage;

public class IssuePageSteps {

    EdujiraIssuePage issuePage = new EdujiraIssuePage();
    private String expectedStatus;
    private String expectedVersion;

    @Дано("Ожидаемый статус задачи {string}")
    public void setExpectedStatus(String expectedStatus){
        this.expectedStatus = expectedStatus;
    }

    @Дано("Ожидаемая версия {string}")
    public void expectedVersion(String expectedVersion){
        this.expectedVersion = expectedVersion;
    }
    @Тогда("Проверяем статус задачи и версию")
    public void verifyIssueDetailsTest() {
        issuePage.verifyIssueDetails(expectedStatus, expectedVersion);
    }

    @Тогда("Закрыть задачу до статуса 'Выполнено'")
    public void completeIssue(){
        issuePage.completeIssue();
    }
}
