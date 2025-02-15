package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CreateIssueDialogPage {

    private final SelenideElement summaryInput = $x("//input[@id='summary']")
            .as("Название задачи");
    private final SelenideElement submitButton = $x("//input[@id='create-issue-submit']")
            .as("Создать задачу");
    private final SelenideElement descriptionArea = $x("//iframe[@id='mce_0_ifr']")
            .as("Поле описания");
    private final SelenideElement environmentArea = $x("//iframe[@id='mce_6_ifr']")
            .as("Поле окружения");
    private final SelenideElement tagEditor = $x("//textarea[1][@id='labels-textarea']")
            .as("Поле тега");
    private final SelenideElement fixVersionEditor = $x("//select[@id='fixVersions']")
            .as("Версия фикса");
    private final SelenideElement tochVersionEditor = $x("//select[@id='versions']")
            .as("Затрагиваемая версия");
    private final SelenideElement seriousnessEditor = $x("//select[@id='customfield_10400']")
            .as("Серьезность проблемы");
    private final SelenideElement visualButton = $x("//button[contains(text(),'Визуальный')]")
            .as("Кнопка 'Визуальный'");
    private final SelenideElement expectedVisualButton = $x("//button[contains(text(),'Визуальный')][@aria-pressed='true']")
            .as("Нажатая кнопка 'Визуальный'");
    private final SelenideElement performerButton = $x("//button[@id='assign-to-me-trigger']")
            .as("Кнопка исполнителя");

    public EdujiraProjectPage createBug(String summary) {
        summaryInput.shouldBe(Condition.visible, Duration.ofSeconds(2)).setValue(summary);
        submitButton.click();
        return new EdujiraProjectPage();
    }
    public EdujiraProjectPage createBug(String summary, String desc, String env, String tag,
                                        String fixInVersion, String tochedInVersion, String serios) {
        descriptionArea.shouldBe(Condition.visible).click();
        changeTextInsideIframe(descriptionArea, desc);
        environmentArea.shouldBe(Condition.visible).click();
        changeTextInsideIframe(environmentArea, env);
        summaryInput.shouldBe(Condition.visible, Duration.ofSeconds(4)).setValue(summary);
        tagEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).setValue(tag);
        fixVersionEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).selectOptionContainingText(fixInVersion);
        tochVersionEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).selectOptionContainingText(tochedInVersion);
        performerButton.click();
        seriousnessEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
        seriousnessEditor.selectOptionContainingText(serios);
        Assertions.assertThat(visualButton).isEqualTo(expectedVisualButton);
        submitButton.click();

        return new EdujiraProjectPage();

    }
    public void changeTextInsideIframe(SelenideElement frame, String textValue) {
        String frameId = frame.attr("id");
        switchTo().frame(frameId);
        SelenideElement paragraph = $x("//p");
        paragraph.setValue(textValue);
        paragraph.shouldHave(text(textValue));
        switchTo().defaultContent();

    }

}
