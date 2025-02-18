package steps;


import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import pages.EdujiraLoginPage;


public class LoginPageSteps {

    private final EdujiraLoginPage loginPage = new EdujiraLoginPage();

    @Дано("Логин {string} и Пароль {string}")
    public void fillLoginFields(String login, String password){
        loginPage.setData(login, password);
    }
    @Тогда("Нажимаем на кнопку входа")
    public void selectLoginButton() {
        loginPage.login();
    }
}
