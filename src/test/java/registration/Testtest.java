package registration;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class Testtest extends setup.TestBase {

    @Test
    void registration() {
        open(urlUserRegistration);
        $("input[name='name']").setValue(userFirstName);

        $("input[name='name']", 1).setValue(userLastName);

        $("input[name='email']").setValue(userEmail);

        $("input[name='password']").setValue(userPassword);
        $("input[name='confirm']").setValue(userPassword);

        $("input[name='ion-input-5']").setValue(userPhoneNumber);
        $("app-registration-form").$("button[type='button']").click();
        sleep(1000);
        $("ionic-selectable-modal").$("input").sendKeys(userCountry);
        sleep(500);
        $("ionic-selectable-modal").$("ion-item", 0).click();


        $("app-country-selector").$("button").click();
        sleep(1000);
        $("ionic-selectable-modal").$("input").sendKeys(userCountry);
        sleep(500);
        $("ionic-selectable-modal").$("ion-label", 0).click();


        $("app-city-selector").$("button").click();
        sleep(1000);
        $("ionic-selectable-modal").$("input").sendKeys(userCity);
        sleep(500);
        $("ionic-selectable-modal").$("ion-label", 0).click();

        $("ion-button[type='submit']").click();

        $("app-profile").$(withText(userFirstName)).should(Condition.visible);
        $("app-profile").$(withText(userLastName)).should(Condition.visible);
        $("app-profile").$(withText(userEmail)).should(Condition.visible);
        $("app-profile").$(withText(userPhoneNumber)).should(Condition.visible);
        $("app-profile").$(withText(userCountry)).should(Condition.visible);
        $("app-profile").$(withText(userCity)).should(Condition.visible);
    }

    @Test
    void login() {
        open(urlLogin);
        $("app-login").$("input", 0).setValue(userEmail);
        $("app-login").$("input", 1).setValue(userPassword);
        $("ion-button[type='submit']").click();
        sleep(1000);
    }
}

