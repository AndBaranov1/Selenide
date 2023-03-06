package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFinderRepositoryTop() {
        String result = "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}";

        Configuration.browserSize = "1920x1080";
        // Открыть главную страницу
        open("https://github.com/");
        // Ввести в поле поиска selenide и нажать enter
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        // Кликнуть на первый репозиторий из списка найденных
        $$("ul.repo-list li").first().$("a").click();
        // Проверка заголовка selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        // Переход на страницу wiki
        $("#wiki-tab").click();
        // Найти поле фильтра страницы и ввести название страницы SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        // Нажать на SoftAssertions
        $(byText("SoftAssertions")).click();
        // Проверить отображение примера кода JUnit5
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text(result));
    }
}