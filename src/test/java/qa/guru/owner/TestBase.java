package qa.guru.owner;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import qa.guru.owner.config.WebDriverProvider;

public class TestBase {
    @BeforeAll
    static void startDriver(){
        WebDriverProvider.configuration();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
