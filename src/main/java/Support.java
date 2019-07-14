import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by heymn on 29.10.2018.
 */
public class Support {
    public String _driver = System.getProperty("browser");       //получение ключа для тестирования
    private WebDriver driver;
    public Support () {
        getDriver(_driver);
    }

    public void getDriver(String type){                          // выбор браузера для тестирования по ключу
        String driverPath = "C:\\Users\\heymn\\IdeaProjects\\testforterstir\\src\\main\\resources\\drivers\\";
        switch (type){
            case "ch":
                System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ff":
                System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability("marionatte", false);
                FirefoxOptions opt = new FirefoxOptions();
                opt.merge(dc);
                driver = new FirefoxDriver(opt);
                break;
            default:
                break;
        }
        driver.manage().window().maximize();
    }


    public void go (String url){                       //запуск браузера
        driver.get(url);
        sleep(4000);
    }

    public void sleep(int t){                       // функция задержки приложения
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getData(WebElement element){                    //получение данных с элемента формы
        sleep(1000);
        return element.getText().trim();
    }

    public void setData(WebElement element, String data){             //передача данных в форму
        clear_field(element);
        element.sendKeys(data);
    }

    public WebElement getEl(String path){                            //доступ к элементу формы по его селектору
        return driver.findElement(By.cssSelector(path));
    }

    public void click (WebElement element){                            //нажатие на элемент формы
        try {
            element.click();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Boolean comparison (String text1, String text2){             //сравнение 2 элементов
        if (text1.equals(text2) ){
            return true;
        } else {
            return false;
        }

    }

    public void reload_page(){                                          //перезагрузка страницы формы
        driver.navigate().refresh();
        sleep(3000);
    }

    public void clear_field(WebElement element){                      // очистка текстового элемента формы
        element.clear();
    }



    public void stopDriver(){
        driver.quit();                                                //остановка работы Selenium
    }



}
