package qa.guru.owner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qa.guru.owner.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {
    private WebDriver driver;

//    @BeforeAll
//    static void configMy(){
//        System.setProperty("WebDriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
//    }

    @BeforeEach
    public void startDriver(){
        // driver = getDriver(); после добавления провайдера можем записать так

        driver = new WebDriverProvider().get();
    }

    @Test
    //@DisplayName("Изначльный тест который будем менять")
    public void testGithub00(){
        //если используем не selenide
        //это на селениуме
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        //WebDriverManager.chromedriver().setup();// скачивает и устанавливает актуальную версию браузера
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com");
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
        driver.quit();
    }
    @Test
    @DisplayName("Выносим чтоб запускать на разных браузерах")
    @Disabled ("Not run")
    @Deprecated
    public void testGithub01(){
        //WebDriver driver = getDriver();//меняем браузер в методе ниже
        driver.get("https://github.com");
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
        driver.quit();
    }
    @Test
    @DisplayName("Если запускать на разных урлах")
    @Disabled ("Not run")
    @Deprecated
    public void testGithub02(){
        //WebDriver driver = getDriver();
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
        driver.quit();
    }
    @Test
    @DisplayName("Теперь тест можно разделить, условно, на 2 стадии")
    @Disabled("Not run")
    @Deprecated
    public void testGithub03(){
        //подготовка Driver
        //WebDriver driver = getDriver();
        //тело выполнения теста
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
        driver.quit();
    }
    @Test
    @DisplayName("При использовании методов бефор и афтер")
    public void testGithub04(){
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
    }
    @AfterEach
    public void stopDriver(){
        driver.quit();
    }

    //если надо запускать тесты на разных браузерах, то можно сделать так
    //данный метот это конфигурация
    //после добавления провайдера этот метод можно удалить
    /*private WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();// скачивает и устанавливает актуальную версию браузера(00)
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com");//если надо запускать по разным урлам (02)
        return driver;
        //WebDriverManager.firefoxdriver().setup();//и в одном месте поменяли для всех тестов (01)
        //return new FirefoxDriver();
    }
    */

}
