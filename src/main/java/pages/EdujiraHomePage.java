package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraHomePage {

    private final SelenideElement projectsMenu = $x("//a[@id='browse_link']")
            .as("Выпадающий список проектов");
    private final SelenideElement testProjectLink = $x("//a[contains(text(),'Test (TEST)')]")
            .as("Проект TEST");

    @Step("Открытие проекта TEST")
    public EdujiraProjectPage openTestProject() {
        projectsMenu.hover().click();
        testProjectLink.click();
        return new EdujiraProjectPage();
    }
}
