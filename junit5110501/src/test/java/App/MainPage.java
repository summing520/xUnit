package App;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;


public class MainPage extends BasePage {

    public MainPage() throws MalformedURLException {
        String caps=System.getenv("driver");
        driver= (AppiumDriver) DriverFactory.getInstance().createDriver(caps);

//        new WebDriverWait(driver, 120)
//                .until(
//                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='通讯录']")));

        new WebDriverWait(driver, 120)
                .until(
                        ExpectedConditions.visibilityOfElementLocated(By.id("com.xueqiu.android:id/home_search")));
    }

    public ContactPage search() {
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        return new ContactPage(driver);
    }

}
