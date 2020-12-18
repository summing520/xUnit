import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class wireMockDemoTest {

    public static WireMockServer wireMockServer;
    @BeforeAll
    public static void BeforeAll()
    {
        wireMockServer = new WireMockServer(wireMockConfig().port(8089)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        configureFor("localhost",8089);
    }
    @Test
    void stubMockTest() throws InterruptedException {
        stubFor(get(urlEqualTo("/my/resource"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));
        Thread.sleep(5000000);
    }



    @Test
    void proxyMockTest() throws InterruptedException, IOException {
        try {
            stubFor(get(urlMatching("*"))
                    .willReturn(aResponse().proxiedFrom("http://www.ceshiren.com")));

            stubFor(get(urlEqualTo("/categories_and_latest")).atPriority(1)
                    .willReturn(aResponse().withBody(Files.readAllBytes(Paths.get(wireMockDemoTest.class.getResource("/categories_and_latest_new").getPath())))));

            Thread.sleep(5000000);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
