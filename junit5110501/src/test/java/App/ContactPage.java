package App;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactPage extends  BasePage {

    public ContactPage(AppiumDriver driver) {
        super(driver);
    }
    public By home_search=By.id("com.xueqiu.android:id/home_search");
    public By search_input_text=By.id("By.id(\"com.xueqiu.android:id/search_input_text\")");
    public By BABA=By.id("By.xpath(\"//*[@text='BABA']\")");
    public By current_price=By.id("By.id(\"com.xueqiu.android:id/current_price\")");



    public ContactPage search(String name)
    {
      driver.findElement(home_search).click();
      driver.findElement(search_input_text).sendKeys(name);
      driver.findElement(BABA).click();
      return this;
    }

    public ContactPage getPrice()
    {
        String price=driver.findElement(current_price).getText();
        System.out.println("price:"+price);
        return  this;
    }

}
