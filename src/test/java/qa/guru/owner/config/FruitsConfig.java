package qa.guru.owner.config;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FruitsConfig extends Config {
//проверить дома комбинации с браузером List + возвращаемый тип
    @Key("array")
    String[] getFruitsArray();

    @Key("array-with-default-values")
    @DefaultValue("orange, apple")
    String[] getFruitsArrayWithDefaultValues();

    @Key("list")
    List<String> getFruitsList();

    @Separator(";")
    @Key("list-with-separator")
    @DefaultValue("orange; banana")
    List<String> getFruitsListWithSeparator();

}
