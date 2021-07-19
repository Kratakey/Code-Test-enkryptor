package setup;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

public class TestBase {

    public static String testVar;

    @BeforeAll
    public static void setVar() {
        Faker random = new Faker(new Locale("en-US"));
        testVar = random.name().username() + "@dd.dd";
        System.out.println("Before all:" + testVar);
    }
}