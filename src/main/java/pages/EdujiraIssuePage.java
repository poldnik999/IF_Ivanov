package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class EdujiraIssuePage {

    private final SelenideElement status = $x("//span[@id='status-val']")
            .as("Статус задачи");
    private final SelenideElement fixVersion = $x("//span[@id='fixVersions-field']")
            .as("Версия");
    private final SelenideElement dropDownField = $x("//a[@id='opsbar-transitions_more']")
            .as("Выпадающий список статусов задач");
    private final SelenideElement completeButton = $x("//span[@class='trigger-label'][contains(text(), 'Выполнено')]")
            .as("кнопка изменения статуса задачи");

    @Step("Проверяем задачу на совпадение статуса {expectedStatus} и версии {expectedVersion}")
    public void verifyIssueDetails(String expectedStatus, String expectedVersion) {
        assertThat(status.getText()).isEqualTo(expectedStatus);
        assertThat(fixVersion.getText()).contains(expectedVersion);
    }

    @Step("Изменяем статус задачи на выполнено")
    public void completeIssue() {
        dropDownField.click();
        completeButton.shouldBe(Condition.visible).click();
    }

}
