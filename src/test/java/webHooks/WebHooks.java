package webHooks;

import com.codeborne.selenide.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.*;

import java.awt.*;

public class WebHooks {

    @Before
    public void initBrowser(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        Configuration.browserBinary = "src/test/resources/drivers/chrome-win64/chrome.exe";
        //Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = width + "x" + height;;
        Selenide.open("https://edujira.ifellow.ru/");
    }
    @After
    public void afterTest(){
        Selenide.closeWebDriver();
    }
}
