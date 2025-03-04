package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraLoginPage {

    private final SelenideElement login = $x("//input[@id='login-form-username']")
            .as("Поле логина");
    private final SelenideElement password = $x("//input[@id='login-form-password']")
            .as("Поле пароля");
    private final SelenideElement submitButton = $x("//input[@id='login']")
            .as("Кнопка подтверждения входа");

    @Step("Заполнение полей пользователя {username} и пароля {password}")
    public EdujiraHomePage login(String username, String password) {
        this.login.shouldBe(Condition.visible).setValue(username);
        this.password.shouldBe(Condition.visible).setValue(password);
        this.submitButton.shouldBe(Condition.visible).click();
        return new EdujiraHomePage();
    }
}
