package webHooks;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import java.awt.*;

public class WebHooks {
    @BeforeEach
    public void initBrowser(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = width + "x" + height;;
        Selenide.open("https://edujira.ifellow.ru/");
    }
    @AfterEach
    public void afterTest(){
        Selenide.closeWebDriver();
    }
}
