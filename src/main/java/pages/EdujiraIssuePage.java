package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.$x;

public class EdujiraIssuePage {

    private final SelenideElement status = $x("//span[@id='status-val']");
    private final SelenideElement fixVersion = $x("//span[@id='fixVersions-field']");
    private final SelenideElement dropDownField = $x("//a[@id='opsbar-transitions_more']");
    private final SelenideElement completeButton = $x("//span[@class='trigger-label'][contains(text(), 'Выполнено')]");

    public void verifyIssueDetails() {
        assertThat(status.getText()).isEqualTo("СДЕЛАТЬ");
        assertThat(fixVersion.getText()).contains("Version 2.0");
    }
    public void completeIssue() {
        dropDownField.click();
        completeButton.shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
        sleep(1000);
    }

}
