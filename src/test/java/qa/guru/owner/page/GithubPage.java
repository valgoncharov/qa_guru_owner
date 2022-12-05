package qa.guru.owner.page;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GithubPage {
    public GithubPage openPage(){
        step("Открываем главную страницу", () -> {
            open("/");
        });
        return this;
    }
}
