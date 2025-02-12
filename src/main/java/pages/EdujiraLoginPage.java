package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraLoginPage {

    private final SelenideElement login = $x("//input[@id='login-form-username']");
    private final SelenideElement password = $x("//input[@id='login-form-password']");
    private final SelenideElement submitButton = $x("//input[@id='login']");

    public EdujiraHomePage login(String username, String password) {
        this.login.shouldBe(Condition.visible, Duration.ofSeconds(2)).setValue(username);
        this.password.shouldBe(Condition.visible, Duration.ofSeconds(2)).setValue(password);
        this.submitButton.shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
        return new EdujiraHomePage();
    }
}
