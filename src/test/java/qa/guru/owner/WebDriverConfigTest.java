package qa.guru.owner;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qa.guru.owner.config.WebDriverConfig;
import qa.guru.owner.config.WebDriverProvider;
import qa.guru.owner.page.GithubPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverConfigTest {

    @Test
    @DisplayName("Пробный тест")
    public void testGithub00(){
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
        closeWebDriver();
    }

    @Test
    @DisplayName("Заглавная страница")
    void testGithubTextVisible(){
        step("Open page and check header", () ->{
        open(baseUrl);
        });
        $(".col-11 text-left pt-12 mt-12 pl-2 pl-sm-0")
                .shouldHave(text("GitHub: Let’s build from here · GitHub"));
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка репозитория")
    void shouldFindRepositoryAtFirstPlace(){
            step("Check repository", () -> {
            open("/selenide/selenide");
            $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
            $(".repo-list li").$("a").click();
            $("#repository-container-header").shouldHave(text("selenide / selenide"));
            closeWebDriver();
        });
    }
}
