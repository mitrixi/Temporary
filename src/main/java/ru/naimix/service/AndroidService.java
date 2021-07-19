package ru.naimix.service;

import io.appium.java_client.android.AndroidDriver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@Service

public class AndroidService {
    protected static AndroidDriver<WebElement> driver;
    protected static ResourceBundle xpath;
    protected static ResourceBundle data;

//    public AndroidService(Version version) {
//        driver = (AndroidDriver<WebElement>) version.driver;
//        xpath = version.xpath;
//        data = version.data;
//    }

//    public void selectProfile() {
//        clickElementByXPath("Профиль[кнопка]");
//        assertThat("При переходе в профиль НЕ появилось уведомление о заполнении профиля",
//                isDisplayedByXPath("Закрыть_уведомление"), equalTo(true));
//    }

    public static void clickElementByXPath(String resourceXPath) {
        driver.findElementByXPath(xpath.getString(resourceXPath)).click();
    }

    public static void clickElementByXPath(String resourceXPath, int index) {
        driver.findElementsByXPath(xpath.getString(resourceXPath)).get(index).click();
    }

    public static void clickElementByXPath(String resourceXPath, String resourceData) {
        driver.findElementByXPath(MessageFormat.format(xpath.getString(resourceXPath), data.getString(resourceData))).click();
    }

    public static void sendKeysIntoElementByXPath(String resourceXPath, String resourceData) {
        driver.findElementByXPath(xpath.getString(resourceXPath)).sendKeys(resourceData);
    }

    public static boolean isDisplayedByXPath(String resourceXPath) {
        return driver.findElementByXPath(xpath.getString(resourceXPath)).isDisplayed();
    }

    protected boolean isDisplayedByXPath(String resourceData, XPathType xPathType) {
        String xPath = "//android.widget.%s[@text='%s']";
        switch (xPathType) {
            case FIELD:
                xPath = String.format(xPath, XPathType.FIELD.getType(), resourceData);
                break;
            case TITLE:
                xPath = String.format(xPath, XPathType.TITLE.getType(), resourceData);
                break;
        }

        return driver.findElementByXPath(xPath).isDisplayed();
    }

    @Getter
    @AllArgsConstructor
    protected enum XPathType {
        FIELD("EditText"),
        TITLE("TextView");

        private final String type;
    }

    protected boolean isEnabledByXPath(String resourceXPath) {
        return driver.findElementByXPath(xpath.getString(resourceXPath)).isEnabled();
    }

    @SneakyThrows
    public boolean checkColorElement(String resourceXPath) {

        //ожидание времени на прорисовку анимации
        TimeUnit.SECONDS.sleep(2);

        Point point = driver.findElementByXPath(xpath.getString(resourceXPath)).getLocation();
        File srcFile2 = driver.getScreenshotAs(OutputType.FILE);
        BufferedImage image2 = ImageIO.read(srcFile2);

        int color = image2.getRGB(point.getX(), point.getY());

        int red = (color & 0x00ff0000) >> 16;
        int green = (color & 0x0000ff00) >> 8;
        int blue = color & 0x000000ff;

        return (red < 90 && red > 60) && (green < 185 && green > 155) && (blue < 70 && blue > 20);
    }

    @SneakyThrows
    public boolean checkColorElement(String resourceXPath, int index) {

        //ожидание времени на прорисовку анимации
        TimeUnit.SECONDS.sleep(2);

        //В некоторых активити присутствуют несколько элементов с искомым текстом. Нулевой скрыт, а первый - который нужен - располагается на кнопке
        Point point = driver.findElementsByXPath(xpath.getString(resourceXPath)).get(index).getLocation();
        File srcFile2 = driver.getScreenshotAs(OutputType.FILE);
        BufferedImage image2 = ImageIO.read(srcFile2);

        int color = image2.getRGB(point.getX(), point.getY());

        int red = (color & 0x00ff0000) >> 16;
        int green = (color & 0x0000ff00) >> 8;
        int blue = color & 0x000000ff;

        return (red < 90 && red > 60) && (green < 185 && green > 155) && (blue < 70 && blue > 20);
    }

    public void scrollToElementByText(String locatorName) {
        Matcher matcher = Pattern.compile("//.*@text.*'(.*)'\\)*]").matcher(xpath.getString(locatorName));

        if (matcher.find())
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + matcher.group(1) + "\").instance(0))");
    }

    protected void sleep(int sleepSecond) {
        try {
            TimeUnit.SECONDS.sleep(sleepSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
