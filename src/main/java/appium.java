import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.xml.bind.Element;
import java.io.File;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: QAproject
 * @description: appium測試
 * @author: bjweiman
 * @create: 2018-11-02 21:52
 **/
public class appium {

    private AndroidDriver driver;
    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","127.0.0.1:7555");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("app", "C:\\Users\\bjweiman\\IdeaProjects\\QAproject\\apps\\LSApp.apk");//配置待测试的apk的路径

        /*capabilities.setCapability("deviceName","127.0.0.1:62001");
        capabilities.setCapability("platformVersion", "4.4.2");*/
        capabilities.setCapability("appPackage", "com.nsip.exchange.android");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("newCommandTimeout", 60000);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("App is launched!");
    }

    @Test
    public void addContact() throws Exception{
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        List<WebElement> webElements = new ArrayList<WebElement>(driver.findElements(By.className("android.widget.EditText")));
        WebElement traderIdE = webElements.get(0);
        WebElement passWorld = webElements.get(1);

        traderIdE.sendKeys("17710866130");
        passWorld.sendKeys("11111111");

        WebElement login = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"立即登录"+"\")");
        login.click();

        WebElement lsdz = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"天津小麦"+"\")");
        lsdz.click();

        WebElement zhiaPaiElement = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"摘牌"+"\")");
        zhiaPaiElement.click();

        WebElement count = driver.findElement(By.className("android.widget.EditText"));
        count.sendKeys("11");

        WebElement confirm = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"摘牌数量"+"\")");
        confirm.click();

        WebElement confirmElemenet = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"确定"+"\")");
        confirmElemenet.click();

        List<WebElement> sumbits = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\""+"提交订单"+"\")");
        sumbits.get(1).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"我的"+"\")").click();
        driver.findElementById("com.sky.jisuanji:id/btn6");
        driver.findElementsByClassName("android.widget.EditText");
        driver.findElementsByXPath("//*[@id=\"collapseOne\"]/div/div[1]/div[1]/h4");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"摘牌订单"+"\")").click();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        System.out.println("App is done!");

    }

    @After
    public void tearDown() throws Exception {

        driver.quit();

    }

}

