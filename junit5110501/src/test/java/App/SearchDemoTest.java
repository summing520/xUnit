package App;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.MalformedURLException;

public class SearchDemoTest {

    static MainPage main;

    @BeforeAll
    static void  BeforeAll() throws MalformedURLException {
        main=new MainPage();
    }

    @Test
    @ValueSource(strings = {"xx", "中文", "a_b", "a b", "xxx（）有限公司"})
     void searchTest(String name)
    {

        main.search().search(name);

    }
}
