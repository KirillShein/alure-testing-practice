package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest {

    private static final String REPO = "selenide/selenide";
    private static final String ISSUE = "#2948";

    @Test
    public void lambdaCheckingGitHubText() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
                open("https://github.com/");
        });

        step("Найти репозиторий {REPO}", () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPO).pressEnter();
        });

        step("Кликнуть по ссылки репозитория {REPO}", () -> {
            $(linkText(REPO)).click();
        });

        step("Кликнуть по вкладке Issue", () -> {
            $("#issues-tab").click();
        });

        step("Проверить Issue с номером {ISSUE}", () -> {
            $(".ListItems-module__listItem--Blv7W").shouldBe(text(ISSUE));
        });
    }


}
