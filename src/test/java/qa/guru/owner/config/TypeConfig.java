package qa.guru.owner.config;

import org.aeonbits.owner.Config;

public interface TypeConfig extends Config {
    //посмотреть какие еще типа данных поддерживает эта библиотека
    //проверить еще FILE, URL, Path, byte[]
    //конвертер поддерживает любой тип данных

    @Key("integer")
    Integer getInteger();

    @Key("double")
    Double getDouble();

    @Key("boolean")
    Boolean getBoolean();

    @Key("enum")
    Browser getEnum();
}
