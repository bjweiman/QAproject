/*
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.http.HttpClient;
import org.springframework.util.StringUtils;

import java.net.URL;
import java.util.List;

*/
/**
 * @program: QAproject
 * @description: 包装类
 * @author: bjweiman
 * @create: 2018-11-12 17:37
 **//*

public class AppiumUtils extends AppiumDriver{
    public AppiumUtils(HttpCommandExecutor executor, Capabilities capabilities) {
        super(executor, capabilities);
    }

    public AppiumUtils(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
    }

    public AppiumUtils(URL remoteAddress, HttpClient.Factory httpClientFactory, Capabilities desiredCapabilities) {
        super(remoteAddress, httpClientFactory, desiredCapabilities);
    }

    public AppiumUtils(AppiumDriverLocalService service, Capabilities desiredCapabilities) {
        super(service, desiredCapabilities);
    }

    public AppiumUtils(AppiumDriverLocalService service, HttpClient.Factory httpClientFactory, Capabilities desiredCapabilities) {
        super(service, httpClientFactory, desiredCapabilities);
    }

    public AppiumUtils(AppiumServiceBuilder builder, Capabilities desiredCapabilities) {
        super(builder, desiredCapabilities);
    }

    public AppiumUtils(AppiumServiceBuilder builder, HttpClient.Factory httpClientFactory, Capabilities desiredCapabilities) {
        super(builder, httpClientFactory, desiredCapabilities);
    }

    public AppiumUtils(HttpClient.Factory httpClientFactory, Capabilities desiredCapabilities) {
        super(httpClientFactory, desiredCapabilities);
    }

    public AppiumUtils(Capabilities desiredCapabilities) {
        super(desiredCapabilities);
    }

    public WebElement findByClassNameAndText(List<WebElement> elements, String text){
        if (elements == null || elements.isEmpty() || StringUtils.isEmpty(text)){
            return null;
        }
        for (WebElement element: elements){
            if (text.equals(element.getText())){
                return element;
            }
        }

        return null;

    }

    @Override
    public WebElement scrollTo(String text) {
        return null;
    }

    @Override
    public WebElement scrollToExact(String text) {
        return null;
    }

    @Override
    public void rotate(ScreenOrientation orientation) {
        super.rotate(orientation);
    }

    @Override
    public DeviceRotation rotation() {
        return null;
    }
}
*/
