package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class EdujiraLoginPage {

    private final SelenideElement loginField = $x("//input[@id='login-form-username']")
            .as("Поле логина");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']")
            .as("Поле пароля");
    private final SelenideElement submitButton = $x("//input[@id='login']")
            .as("Кнопка подтверждения входа");

    private String username;
    private String password;

    @Step("Аутентификация пользователя")
    public EdujiraHomePage login() {

        submitButton.shouldBe(Condition.visible).click();
        return new EdujiraHomePage();
    }

    @Step("Заполнение полей пользователя {username} и пароля {password}")
    public EdujiraLoginPage fillAuthField(String username, String password) {
        this.username = username;
        this.password = password;

        loginField.shouldBe(Condition.visible).setValue(this.username);
        passwordField.shouldBe(Condition.visible).setValue(this.password);
        return this;
    }

    @Step("Проверяем поля ввода логина и пароля")
    public EdujiraLoginPage assertFieldIsFill() {
        assertThat(loginField.getValue()).isEqualTo(username);
        assertThat(passwordField.getValue()).isEqualTo(password);
        return this;
    }
}
