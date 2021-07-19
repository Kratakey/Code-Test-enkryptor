package setup;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public static String testVar;

    @BeforeAll
    public static void setVar() {
        Faker random = new Faker(new Locale("en-US"));
        testVar = random.name().username() + "@dd.dd";
        System.out.println("Before all:"+testVar);
    }
}