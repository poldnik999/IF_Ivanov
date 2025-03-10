package webHooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigLoader;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

public class WebHooks {

    private static ConfigLoader prop = new ConfigLoader();

    @BeforeEach
    public void initBrowser(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = width + "x" + height;;
        Selenide.open(prop.getProperty("edujira.url"));
    }

    @AfterEach
    public void afterTest(){
        Selenide.closeWebDriver();
    }

    @BeforeAll
    public static void allureSetup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
    }
}
