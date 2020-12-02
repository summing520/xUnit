package ceshiren.web;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class wxNeedLogin {

    public static WebDriver driver;
    @Test
    public void needLogin() throws InterruptedException, IOException {
        //C:\Users\wuwen\AppData\Local\Google\Chrome\Application\chromedriver
//        System.setProperty("webdriver.chrome.driver",
//                "C:/Program Files/Google/Chrome/Application/chromedriver.exe") ;
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //sleep 20
        Thread.sleep(15000);
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);

        Thread.sleep(15000);
       // System.exit(0);

    }





   @Test
    public void readCookies() throws IOException, InterruptedException {
        File file = new File("cookies.yaml");
        if (file.exists()) {
            //利用cookie复用session登录
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://work.weixin.qq.com/wework_admin/frame");

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
            };

            List<HashMap<String, Object>> cookies = mapper.readValue(file, typeReference);
            System.out.println(cookies);

            cookies.forEach(cookieMap -> {
                driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
            });

            driver.navigate().refresh();


            driver.findElement(By.id("menu_contacts")).click();
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);


        } else {
            needLogin();
        }
    }

    @Test
    public void searchDepart()
    {
        driver.findElement(By.id("menu_contacts")).click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
}
