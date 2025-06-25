package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubSteps {

    @Step("Открыть главную страницу")
    public GitHubSteps openPage() {
        open("https://github.com/");
        return this;
    }

    @Step("Найти репозиторий {repo}")
    public  GitHubSteps seacrhRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).pressEnter();

        return this;
    }

    @Step("Кликнуть по ссылки репозитория {repo}")
    public GitHubSteps clickRepositoryLink(String repo) {
        $(linkText(repo)).click();

        return this;
    }

    @Step("Кликнуть по вкладке Issue")
    public GitHubSteps tabIssue() {
        $("#issues-tab").click();

        return this;
    }

    @Step("Проверить Issue с номером {Issue}")
    public GitHubSteps searchIssueNumber(String issue){
        $(".ListItems-module__listItem--Blv7W").shouldBe(text(issue));

        return this;
    }


}
