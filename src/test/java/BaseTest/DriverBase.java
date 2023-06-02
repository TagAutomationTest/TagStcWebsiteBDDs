package BaseTest;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverBase {

    public static WebDriver driver;
    static String values;

    public static WebDriver getdriverPerBrowser(String browser) {
        try {
            browser = browser.toLowerCase().trim();
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

            }
        } catch (Exception e) {
            throw e;

        }

        return driver;

    }

    public static void OpenWebsite(String browserName, String Url) {
        try {
            //driver = getdriverPerBrowser(browserName);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(Url);
        } catch (Exception e) {
            throw e;

        }
    }

    public static String readdata(String key_name) {

        try {
            JSONParser parser = new JSONParser();
            String currentpath = System.getProperty("user.dir");
            String filepath = currentpath + "/src/test/testdata/StcTvData.Json";
            Object obj = parser.parse(new FileReader(filepath));
            JSONObject jsonObject = (JSONObject) obj;
            values = (String) jsonObject.get(key_name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;

    }
}

