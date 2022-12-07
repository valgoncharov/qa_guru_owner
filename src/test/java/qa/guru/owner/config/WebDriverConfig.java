package qa.guru.owner.config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:${host}.properties"
})

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String baseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browserVersion")
    String browserVersion();

    @Key("remoteUrl")
    String remoteUrl();
}
