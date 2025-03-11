package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverConditions.title;
import static org.assertj.core.api.Assertions.assertThat;

public class EdujiraHomePage {

    private final SelenideElement projectsMenu = $x("//a[@id='browse_link']")
            .as("Выпадающий список проектов");
    private final SelenideElement projectLink = $x("//a[@id='admin_main_proj_link_lnk']")
            .as("Ссылка на проект");

    @Step("Открытие проекта {projectName}")
    public EdujiraProjectPage openProject(String projectName) {
        projectsMenu.hover().click();
        projectLink.shouldHave(text(projectName)).click();
        return new EdujiraProjectPage();
    }

    @Step("Проверяем что страница открыта")
    public EdujiraHomePage assertNewPageIsOpen() {
        assertThat(title("System Dashboard - Jira"));
        return this;
    }
}
