package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: QAproject
 * @description: ContactManager appium测试
 * @author: bjweiman
 * @create: 2019-03-26 17:23
 **/
public class AppiumDemo {

    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        AndroidDriver<WebElement> driver;
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("app", "C:\\Users\\bjweiman\\IdeaProjects\\QAproject\\apps\\LSApp.apk");//配置待测试的apk的路径
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersion", "6.0.1");//手机操作系统版本
        des.setCapability("udid", "127.0.0.1:7555");//连接的物理设备的唯一设备标识
        des.setCapability("deviceName", "device");//使用的手机类型或模拟器类型  UDID
        des.setCapability("appPackage", "com.nsip.exchange.android");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability("appActivity", ".MainActivity");//app测试人员常常要获取activity，进行相关测试,后续会讲到
        des.setCapability("unicodeKeyboard", true);//支持中文输入
        des.setCapability("resetKeyboard", true);//支持中文输入
        des.setCapability("newCommandTimeout", "10");//没有新命令时的超时时间设置
        des.setCapability("nosign", true);//跳过检查和对应用进行 debug 签名的步骤

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);//设置超时等待时间,默认250ms


        driver.findElementById("com.sky.jisuanji:id/btn1").click();

        driver.findElement(By.id("com.sky.jisuanji:id/btn1")).click();//定位'1'
        driver.findElement(By.id("com.sky.jisuanji:id/jia")).click();//定位'+'
        driver.findElement(By.id("com.sky.jisuanji:id/btn6")).click();//定位'6'
        driver.findElement(By.id("com.sky.jisuanji:id/denyu")).click();//定位'='

    }

}
