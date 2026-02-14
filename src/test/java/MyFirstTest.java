
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@UsePlaywright(HeadClassChromeOptions.class)
public class MyFirstTest {


    @Test
    @DisplayName("My test")
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
