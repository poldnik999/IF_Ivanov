package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.CreateIssueDialogPage;
import pages.EdujiraIssuePage;
import pages.EdujiraProjectPage;

public class IssueDialogPageSteps {
    public CreateIssueDialogPage issueDialogPage = new CreateIssueDialogPage();
    public EdujiraIssuePage issuePage = new EdujiraIssuePage();
    EdujiraProjectPage projectPage = new EdujiraProjectPage();
    private String summary;
    private String desc;
    private String env;
    private String tag;
    private String fixInVersion;
    private String tochedInVersion;
    private String serios;

    @Дано("Название задачи {string}, описание {string}, " +
            "окружение {string}, тег {string}, версия фикса {string}, " +
            "затрагиваемая версия {string}, серьезность {string}")
    public void IssuePage(String summary, String desc, String env, String tag,
                     String fixInVersion, String tochedInVersion, String serios){
        this.summary = summary;
        this.desc = desc;
        this.env = env;
        this.tag = tag;
        this.fixInVersion = fixInVersion;
        this.tochedInVersion = tochedInVersion;
        this.serios = serios;
    }

    @Когда("Открыто окно создания задачи")
    public void openDialogPage(){
        projectPage.clickCreateIssue();
    }

    @Тогда("Создаем задачу")
    public void createAndCloseBugTest() {
        issueDialogPage.createBug(summary,
                        desc,
                        env,
                        tag,
                        fixInVersion,
                        tochedInVersion,
                        serios
        );

    }
    @Затем("Изменяем статус задачи")
    public void closeIssue(){
        issuePage.completeIssue();
    }
}
