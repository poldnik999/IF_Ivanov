package steps;

import io.cucumber.java.ru.Тогда;
import pages.EdujiraHomePage;

public class HomePageSteps {

        EdujiraHomePage homePage = new EdujiraHomePage();

        @Тогда("Переходим в проект 'ТЕСТ'")
        public void openProjectTest() {
            homePage.openTestProject();
    }
}
