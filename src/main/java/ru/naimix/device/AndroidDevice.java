package ru.naimix.device;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.naimix.service.JsonService;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.*;

/**
 * Класс для конфигурации тестов на Андройд устройствах. Здесь задаются ресурсы с локаторами, а также конфигурация драйвера
 */
public abstract class AndroidDevice extends Device {

    protected final ResourceBundle xpath = ResourceBundle.getBundle("locators/Android__V1_16_1/xpath");
    protected final ResourceBundle data = ResourceBundle.getBundle("locators/Android__V1_16_1/data");
    protected final ResourceBundle cssXpathWeb = ResourceBundle.getBundle("locators/web/cssXpath");
    protected final ResourceBundle dataWeb = ResourceBundle.getBundle("locators/web/data");

    public AppiumDriver<WebElement> driver;

    public AndroidDevice() {
        //        String deviceConfigPath = System.getenv("DeviceConfigPath") ;
        String deviceConfigPath =
                StringUtils.isNotEmpty(System.getenv("DeviceConfigPath"))
                        ? System.getenv("DeviceConfigPath")
                        : this.getClass().getClassLoader().getResource("config/androidSim.json").getPath();

        JSONObject appiumJson = JsonService.readJsonFromFile(deviceConfigPath);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(PLATFORM_NAME, "android");
        capabilities.setCapability(NO_RESET, true);

        JSONObject capabilitiesStr = JsonService.getCapabilities(appiumJson);
        capabilitiesStr.keySet().forEach(keyStr -> capabilities.setCapability(keyStr, capabilitiesStr.get(keyStr)));

        try {
                driver = new AndroidDriver<>(new URL(JsonService.getUrl(appiumJson)), capabilities);
//                driver = new AndroidDriver<>(new URL("http://10.254.0.131:4723/wd/hub"), capabilities);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(JsonService.getImplicitlyWait(appiumJson), TimeUnit.SECONDS);
    }

}
