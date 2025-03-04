package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class EdujiraProjectPage {

    private final SelenideElement issuesCount = $x("//div[@class='showing']//span[contains(text(), '1 из')]")
            .as("Счетчик задач");
    private final SelenideElement createIssueButton = $x("//a[@id='create_link']")
            .as("Создать задачу");
    private final SelenideElement searchField = $x("//input[@id='quickSearchInput']")
            .as("Поле поиска");
    private final SelenideElement result = $x("//li[1][@class='quick-search-result-item']")
            .as("Первый результат поиска");

    @Step("Получение кол-ва задач")
    public int getInitialIssuesCount() {
        String text = issuesCount.shouldBe(Condition.visible, Duration.ofSeconds(2)).getText();
        return Integer.parseInt(text.split(" ")[2]);
    }

    @Step("Проверка на изменение кол-ва задач")
    public void verifyIssuesCountIncreased(int initialCount) {
        Selenide.refresh();
        int newCount = getInitialIssuesCount();
        assertThat(newCount).isEqualTo(initialCount + 1);
    }

    @Step("Нажатие кнопки создания задачи")
    public CreateIssueDialogPage clickCreateIssue() {
        createIssueButton.shouldBe(Condition.visible).click();
        return new CreateIssueDialogPage();
    }

    @Step("Ввод {search} в поисковую строку")
    public void searchInfo(String search){
        searchField.shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
        searchField.shouldBe(Condition.visible).setValue(search);
    }

    @Step("Открытие задачи {search} из результатов поиска")
    public EdujiraIssuePage openIssuePage(String search){
        searchInfo(search);
        Assertions.assertThat(result.shouldBe(Condition.visible).getText()).contains(search);
        result.shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
        return new EdujiraIssuePage();
    }
}
