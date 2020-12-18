package App;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {


    private static DriverFactory instance;

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver createDriver(String caps) throws MalformedURLException {
        AppiumDriver driver = null;
        if (caps.equals("android")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("udid", "127.0.0.1:7555");
            capabilities.setCapability("deviceName", "127.0.0.1:7555");
            capabilities.setCapability("appPackage", "com.xueqiu.android");
            capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");

            driver = new AndroidDriver<MobileElement>(
                    new URL("http://0.0.0.0:4723/wd/hub"),
                    capabilities);
            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

//        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
//        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
//        driver.findElement(By.xpath("//*[@text='BABA']")).click();
//        System.out.println(driver.findElement(By.id("com.xueqiu.android:id/current_price")).getText());

            return driver;
        }
        else if (caps.equals("ios")) { }
        else if (caps.equals("firefox")) { }
        return driver;
    }

}
