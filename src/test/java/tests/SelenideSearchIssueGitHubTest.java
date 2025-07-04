package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideSearchIssueGitHubTest extends TestBase {



    @Test
    public void selenideCheckingGitHubText() {

        SelenideLogger.addListener("alluer", new AllureSelenide());

        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $(linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(".ListItems-module__listItem--Blv7W").shouldBe(text("#2948"));
    }
}
