import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFirstTest {

    @Test
    void myTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https://practicesoftwaretesting.com/");

        String title = page.title();

        Assertions.assertTrue(title.contains("Practice Software Testing - Toolshop - v5.0"));


        browser.close();
        playwright.close();
    }

    @Test
    void shouldSearchByKeyword(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https://practicesoftwaretesting.com/");
        page.locator("#search-query").fill("Pliers");
        page.locator("button[data-test='search-submit']").click();

        browser.close();
        playwright.close();
    }
}
