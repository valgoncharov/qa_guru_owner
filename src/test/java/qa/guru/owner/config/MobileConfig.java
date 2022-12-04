package qa.guru.owner.config;

import org.aeonbits.owner.Config;

//@Config.LoadPolicy(Config.LoadType.MERGE)
//не рекомендуется ее использовать. У нее две настройки Фёрст и Мердж
@Config.Sources({
        "classpath:${device}.properties",
        "classpath:mobile.properties"
})
public interface MobileConfig extends Config {

    @Key("device.name")
    String getDeviceName();

    @Key("platform.name")
    String getPlatformName();

    @Key("platform.version")
    String getPlatformVersion();
}
