package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.EdujiraProjectPage;

public class ProjectPageSteps {

    EdujiraProjectPage projectPage = new EdujiraProjectPage();
    private String issueName;

    @Дано("Название задачи {string}")
    public void setIssueName(String issueName){
        this.issueName = issueName;
    }

    @Тогда("Проверяем счетчик задач")
    public void verifyIssuesCount() {
        int initialIssuesCount = projectPage.getInitialIssuesCount();
        projectPage.clickCreateIssue()
                .createBug(issueName);
        projectPage.verifyIssuesCountIncreased(initialIssuesCount);
    }

    @Когда("Открыта задача {string}")
    public void openIssue(String search){
        projectPage.openIssuePage(search);
    }

}
