
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


@UsePlaywright(MyFirstTest.MyOption.class)
public class MyFirstTest {

    private Playwright playwright;

    public static class MyOption implements OptionsFactory{

        @Override
        public Options getOptions() {
            return new Options().setHeadless(false)
                    .setLaunchOptions(
                            new BrowserType.LaunchOptions()
                            .setArgs(Arrays.asList("--no-sandbox","--disable-gpu"))
                    );
        }
    }

    @Test
    void myTest(Page page) {
        page.navigate("https://practicesoftwaretesting.com/");
        String title = page.title();
        Assertions.assertTrue(title.contains("Practice Software Testing - Toolshop - v5.0"));
    }

    @Test
    void shouldSearchByKeyword(Page page) {
        page.navigate("https://practicesoftwaretesting.com/");
        page.locator("#search-query").fill("Pliers");
        page.locator("button[data-test='search-submit']").click();
    }
}
