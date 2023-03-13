package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SolutionsEnterprizeTest {

    @Test
    void solutionsEnterprizeCheckHeader() {
        Configuration.browserSize = "1920x1080";
        // Открыть главную страницу
        open("https://github.com/");
        // Наведение мышкой на элемент (без клика)
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(".enterprise-hero").shouldHave(text("Build like the best"));
    }
}
