package qa.guru.owner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.guru.owner.config.WebDriverProvider;
import qa.guru.owner.helpers.Attach;

public class TestBase {
    @BeforeAll
    static void configure() {
        WebDriverProvider.configure();
        SelenideLogger.addListener("allure", new AllureSelenide());

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    }

    @AfterEach
    void addAttachments(){
        Attach.attachScreenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
