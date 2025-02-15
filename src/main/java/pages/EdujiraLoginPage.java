package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;


import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class EdujiraLoginPage {

    private final SelenideElement login = $x("//input[@id='login-form-username']")
            .as("Поле логина");
    private final SelenideElement password = $x("//input[@id='login-form-password']")
            .as("Поле пароля");
    private final SelenideElement submitButton = $x("//input[@id='login']")
            .as("Кнопка подтверждения входа");

    public EdujiraHomePage login(String username, String password) {
        this.login.shouldBe(Condition.visible).setValue(username);
        this.password.shouldBe(Condition.visible).setValue(password);
        this.submitButton.shouldBe(Condition.visible).click();
        return new EdujiraHomePage();
    }
}
