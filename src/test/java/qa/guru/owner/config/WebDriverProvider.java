package qa.guru.owner.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {
    //теперь применяем конфигурацию Браузер и ВебКонфиг
    private final WebDriverConfig config;
//    public WebDriverProvider(){
//        this(new WebDriverConfig());
//    } не стал использовать Артем в лекции

    public WebDriverProvider(){
//это называется прокси классы
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }


    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.getBaseUrl());
        //driver.get("https://github.com"); после конфиг не нужен
        return driver;
    }

    public WebDriver createDriver(){
        //теперь пишем логику
        switch (config.getBrowser()){
            case CHROME:{
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");//запуск мой 403
               //WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case FIREFOX:{
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default:{
                throw new RuntimeException("No such driver");
            }
        }
    }
}
