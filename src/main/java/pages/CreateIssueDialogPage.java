package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateIssueDialogPage {

    private final SelenideElement summaryInput = $x("//input[@id='summary']");
    private final SelenideElement descriptionEditor = $x("//a[contains(text(),'Визуальный')]");
    private final SelenideElement submitButton = $x("//input[@id='create-issue-submit']");

    private final SelenideElement descriptionTextEditor = $x("//textarea[@id='description']");
    private final SelenideElement environmentTextEditor = $x("//textarea[@id='environment']");
    private final SelenideElement tagEditor = $x("//textarea[1][@id='labels-textarea']");
    private final SelenideElement fixVersionEditor = $x("//select[@id='fixVersions']");
    private final SelenideElement tochVersionEditor = $x("//select[@id='versions']");
    private final SelenideElement seriousnessEditor = $x("//select[@id='customfield_10400']");

    public EdujiraProjectPage createBug(String summary) {
        if (!descriptionEditor.isDisplayed()) {
            $x("//button[contains(text(),'Визуальный')]").click();
        }

        summaryInput.shouldBe(Condition.visible, Duration.ofSeconds(2)).setValue(summary);
        submitButton.click();
        return new EdujiraProjectPage();
    }
    public EdujiraProjectPage createBug(String summary, String desc, String env,String tag,
                                        String fixInVersion, String tochedInVersion, String serios) {
        $x("//button[contains(text(),'Текст')]").shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
        //sleep(2000);
        summaryInput.shouldBe(Condition.visible, Duration.ofSeconds(4)).setValue(summary);
        descriptionTextEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).setValue(desc);
        environmentTextEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).setValue(env);

        tagEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).setValue(tag);
        fixVersionEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).selectOptionContainingText(fixInVersion);
        tochVersionEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).selectOptionContainingText(tochedInVersion);
        $x("//button[@id='assign-to-me-trigger']").click();
        seriousnessEditor.shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
        seriousnessEditor.selectOptionContainingText(serios);

        sleep(6000); //по другому вообще не получалось
        $x("//button[contains(text(),'Визуальный')][@aria-pressed='false']")
                .shouldBe(Condition.visible, Duration.ofSeconds(16)).click();
        $x("//button[contains(text(),'Визуальный')][@aria-pressed='false']")
                .shouldBe(Condition.visible, Duration.ofSeconds(16)).click();
        sleep(1500);
        Assertions.assertThat( $x("//button[contains(text(),'Визуальный')]"))
                .isEqualTo($x("//button[contains(text(),'Визуальный')][@aria-pressed='true']"));
        submitButton.click();
        return new EdujiraProjectPage();
    }

}
