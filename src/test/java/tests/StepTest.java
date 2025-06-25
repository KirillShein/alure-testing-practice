package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepTest extends TestBase {

    private static final String REPO = "selenide/selenide";
    private static final String ISSUE = "#2948";

    @Test
    public void stepCheckingGitHubText() {
        SelenideLogger.addListener("alluer", new AllureSelenide());
        GitHubSteps gitHubSteps = new GitHubSteps();

                gitHubSteps.openPage()
                        .seacrhRepository(REPO)
                        .clickRepositoryLink(REPO)
                        .tabIssue()
                        .searchIssueNumber(ISSUE);
    }
}
