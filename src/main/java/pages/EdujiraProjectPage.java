package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverConditions.title;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EdujiraProjectPage {

    private final SelenideElement issuesCount = $x("//div[@class='showing']//span[contains(text(), '1 из')]")
            .as("Счетчик задач");
    private final SelenideElement createIssueButton = $x("//a[@id='create_link']")
            .as("Создать задачу");
    private final SelenideElement searchField = $x("//input[@id='quickSearchInput']")
            .as("Поле поиска");
    private SelenideElement result = $x("//li[1][@class='quick-search-result-item']")
            .as("Первый результат поиска");

    @Step("Получение кол-ва задач")
    public int getInitialIssuesCount() {
        Selenide.refresh();
        String text = issuesCount.shouldBe(Condition.visible, Duration.ofSeconds(2)).getText();
        return Integer.parseInt(text.split(" ")[2]);
    }

    @Step("Проверка на изменение кол-ва задач")
    public void assertIssuesCountIncreased(int initialCount) {
        int newCount = getInitialIssuesCount();
        assertEquals(initialCount + 1, newCount);
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
        assertThat(searchField.getValue()).isEqualTo(search);
    }

    @Step("Открытие задачи {search} из результатов поиска")
    public EdujiraIssuePage openIssuePage(String search){
        searchInfo(search);
        assertTrue(result.shouldHave(Condition.visible, Duration.ofSeconds(8)).attr("original-title").contains(search));
        result.shouldBe(Condition.visible, Duration.ofSeconds(8)).click();
        return new EdujiraIssuePage();
    }

    @Step("Страница проекта {titleName} открыта")
    public EdujiraProjectPage assertNewPageIsOpen(String titleName) {
        assertThat(title(titleName));
        return this;
    }
}
