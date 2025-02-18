package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;


import static com.codeborne.selenide.Selenide.$x;

public class EdujiraProjectPage {

    private final SelenideElement issuesCount = $x("//div[@class='showing']//span[contains(text(), '1 из')]")
            .as("Счетчик задач");
    private final SelenideElement createIssueButton = $x("//a[@id='create_link']")
            .as("Создать задачу");
    private final SelenideElement searchField = $x("//input[@id='quickSearchInput']")
            .as("Поле поиска");
    private final SelenideElement result = $x("//li[1][@class='quick-search-result-item']")
            .as("Первый результат поиска");

    public int getInitialIssuesCount() {
        String text = issuesCount.shouldBe(Condition.visible, Duration.ofSeconds(2)).getText();
        return Integer.parseInt(text.split(" ")[2]);
    }

    public void verifyIssuesCountIncreased(int initialCount) {
        Selenide.refresh();
        int newCount = getInitialIssuesCount();
        assertThat(newCount).isEqualTo(initialCount + 1);
    }

    public CreateIssueDialogPage clickCreateIssue() {
        createIssueButton.shouldBe(Condition.visible).click();
        return new CreateIssueDialogPage();
    }

    public void searchInfo(String search){
        searchField.shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
        searchField.shouldBe(Condition.visible, Duration.ofSeconds(8)).setValue(search);
    }

    public EdujiraIssuePage openIssuePage(String search){
        searchInfo(search);
        result.shouldBe(Condition.visible, Duration.ofSeconds(8)).click();
        return new EdujiraIssuePage();
    }
}
