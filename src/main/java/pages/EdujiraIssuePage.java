package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EdujiraIssuePage {

    private final SelenideElement status = $x("//span[@id='status-val']")
            .as("Статус задачи");
    private final SelenideElement fixVersion = $x("//span[@id='fixVersions-field']")
            .as("Версия");
    private final SelenideElement dropDownField = $x("//a[@id='opsbar-transitions_more']")
            .as("Выпадающий список статусов задач");
    private final SelenideElement completeButton = $x("//span[@class='trigger-label'][contains(text(), 'Выполнено')]")
            .as("Кнопка изменения статуса задачи");

    @Step("Проверяем задачу на совпадение статуса {expectedStatus}")
    public void assertIssueDetails(String expectedStatus) {
        assertThat(status.shouldBe(Condition.text(expectedStatus)).getText()).isEqualTo(expectedStatus);
    }

    @Step("Проверяем задачу на совпадение статуса {expectedStatus} и версии {expectedVersion}")
    public void assertIssueDetails(String expectedStatus, String expectedVersion) {
        assertThat(status.getText()).isEqualTo(expectedStatus);
        assertThat(fixVersion.getText()).contains(expectedVersion);
    }

    @Step("Изменяем статус задачи на выполнено")
    public EdujiraIssuePage completeIssue() {
        dropDownField.shouldBe(Condition.visible, Duration.ofSeconds(8)).click();
        completeButton.shouldBe(Condition.visible, Duration.ofSeconds(8)).click();
        return this;
    }

    @Step("Страница задачи {titleName} открыта")
    public EdujiraIssuePage assertNewPageIsOpen(String titleName) {
        assertThat(title()).contains(titleName);
        return this;
    }

}
