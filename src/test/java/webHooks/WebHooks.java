package webHooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigLoader;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebHooks {

    private static ConfigLoader prop = new ConfigLoader();

    @BeforeEach
    public void initBrowser(){
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Selenide.open(prop.getProperty("edujira.url"));
        WebDriverRunner.getWebDriver().manage().window().maximize();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(Boolean.parseBoolean(prop.getProperty("save.screen")))
                .savePageSource(Boolean.parseBoolean(prop.getProperty("save.page.source"))));
    }

    @AfterEach
    public void afterTest(){
        Selenide.closeWebDriver();
    }

}
