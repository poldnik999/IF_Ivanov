package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraHomePage {

    private final SelenideElement projectsMenu = $x("//a[@id='browse_link']");
    private final SelenideElement testProjectLink = $x("//a[contains(text(),'Test (TEST)')]");
    private final SelenideElement searchMenu = $x("//a[contains(text(),'Поиск')]");
    private final SelenideElement TestSeleniumButton = $x("//input[@id='login-form-submit']");

    public EdujiraProjectPage openTestProject() {
        projectsMenu.hover().click();
        testProjectLink.click();
        return new EdujiraProjectPage();
    }
    public EdujiraIssuePage openIssuePage(){
        searchInfo("TestSeleniumATHomework");
        TestSeleniumButton.click();
        return new EdujiraIssuePage();
    }
    public void searchInfo(String result){
        searchMenu.setValue(result);
        searchMenu.click();
    }
}
