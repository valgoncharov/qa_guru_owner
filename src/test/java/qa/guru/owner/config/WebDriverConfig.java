package qa.guru.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:remote.properties"
})

public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("99")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();
}
