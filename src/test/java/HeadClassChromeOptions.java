import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

import java.util.Arrays;

public class HeadClassChromeOptions implements OptionsFactory {
    @Override
    public Options getOptions() {
        return new Options().setLaunchOptions(
                new BrowserType.LaunchOptions()
                        .setHeadless(true)
                        .setArgs(Arrays.asList(
                                "--no-sandbox",
                                "--disable-dev-shm-usage",
                                "--disable-gpu",
                                "--start-maximized",
                                "--disable-extensions",
                                "--incognito"
                        ))
        );
    }
}
