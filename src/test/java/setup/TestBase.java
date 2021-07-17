package setup;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Long.parseLong;

public class TestBase {

    Faker random = new Faker(new Locale("en-US"));

    public String
            urlBase = "https://d8base.com/",
            urlLogin = urlBase + "/auth/login",
            urlUserRegistration = urlBase + "/auth/registration",
            userFirstName = random.name().firstName(),
            userLastName = random.name().lastName(),
            userEmail = random.name().username() + "@dd.dd",
            userPassword = random.internet().password(),
            userPhoneNumber = "911" + random.number().digits(7),
            userCountry = "Russia",
            userCity = "Moscow";

    @BeforeEach
    public void setupConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open(urlBase);
    }

    @AfterEach
    public void refresh() {
        closeWebDriver();
    }

}