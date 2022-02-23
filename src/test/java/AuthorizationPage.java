import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AuthorizationPage extends Tests {
    @FindBy(how = How.XPATH, using = "//input[@id='login-form-username']")
    private SelenideElement loginLane;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-password']")
    private SelenideElement passwordLane;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-submit']")
    private SelenideElement btnLogin;

    @FindBy(how = How.XPATH, using = "//a[@id='login-form-cancel']")
    private SelenideElement btnCantLogin;

    public AuthorizationPage clickBtnLogin() {
        loginLane.click();
        loginLane.sendKeys(login);
        return page(AuthorizationPage.class);
    }

    public AuthorizationPage clickBtnPassword() {
        passwordLane.click();
        passwordLane.sendKeys(password);
        return page(AuthorizationPage.class);
    }

    public AuthorizationPage clickBtnIn() {
        btnLogin.click();
        return page(AuthorizationPage.class);
    }

}
