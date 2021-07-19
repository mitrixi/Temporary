package ru.naimix.service;

import com.google.common.collect.Iterables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import javax.swing.text.MaskFormatter;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@Service
public class IosService {
    private IOSDriver<WebElement> driver;
    private ResourceBundle xpath;
    private ResourceBundle data;

//    // Размеры экрана телефона
//    protected final int displayWidth;
//    protected final int displayHeight;
//
//    public IosService(Version version) {
//        this.driver = (IOSDriver<WebElement>) version.driver;
//        this.xpath = version.xpath;
//        this.data = version.data;
//
//        this.displayWidth = driver.manage().window().getSize().width;
//        this.displayHeight = driver.manage().window().getSize().height;
//    }
//
//    protected void clickElementByXPath(String resourceXPath) {
//        MobileElement mobileElement = (MobileElement) driver.findElementByXPath(xpath.getString(resourceXPath));
//        mobileElement.click();
//    }
//
//    protected void clickElementByXPath(String resourceXPath, String resourceData) {
//        MobileElement mobileElement = (MobileElement) driver.findElementByXPath(MessageFormat.format(xpath.getString(resourceXPath), data.getString(resourceData)));
//        mobileElement.click();
//    }
//
//    protected void clickSecondElementByXPath(String resourceXPath) {
//        MobileElement mobileElement = (MobileElement) driver.findElementsByXPath(xpath.getString(resourceXPath)).get(1);
//        mobileElement.click();
//    }
//
//    protected void clickLastElementByXPath(String resourceXPath, String resourceData) {
//        MobileElement mobileElement = (MobileElement) Iterables.getLast(driver.findElementsByXPath(MessageFormat.format(xpath.getString(resourceXPath), data.getString(resourceData))));
//        mobileElement.click();
//    }
//
//    protected void clickElementByXPathToCoordinatesLeftTop(String resourceXPath, String resourceData) {
//        Point location = ((MobileElement) driver.findElementByXPath(MessageFormat.format(xpath.getString(resourceXPath), data.getString(resourceData)))).getLocation();
//        TouchAction action = new TouchAction(driver);
//        action.tap(PointOption.point(location.x + 1, location.y + 1)).perform();
//        sleep(2);
//    }
//
//    protected void clickElementByXPathToCoordinatesLeftTop(String resourceXPath) {
//        Point location = ((MobileElement) driver.findElementByXPath(xpath.getString(resourceXPath))).getLocation();
//        TouchAction action = new TouchAction(driver);
//        action.tap(PointOption.point(location.x + 1, location.y + 1)).perform();
//        sleep(2);
//    }
//
//    protected void clickOnRelativeCoordinates(double x, double y) {
//        TouchAction action = new TouchAction(driver);
//
//        // Кликаем по координатам
//        action.tap(PointOption.point((int) (displayWidth * x), (int) (displayHeight * y))).perform();
//    }
//
//    protected boolean isDisplayedByXPath(String resourceXPath) {
//        return driver.findElementByXPath(xpath.getString(resourceXPath)).isDisplayed();
//    }
//
//    protected boolean isExistByXPath(String resourceXPath) {
//        try {
//            driver.findElementByXPath(xpath.getString(resourceXPath));
//            return true;
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    protected boolean isExistByXPath(String resourceXPath, String data) {
//        try {
//            driver.findElementByXPath(MessageFormat.format(xpath.getString(resourceXPath), data));
//            return true;
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    protected boolean isNotExistByXPath(String resourceXPath) {
//        try {
//            driver.findElementByXPath(xpath.getString(resourceXPath));
//            return false;
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            return true;
//        }
//    }
//
//    protected boolean isExistByXIosNsPredicate(String predicate) {
//        try {
//            driver.findElementsByIosNsPredicate(predicate);
//            return true;
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    protected void sendKeyByXpath(String resourceXPath, String text) {
//        MobileElement mobileElement = (MobileElement) driver.findElementByXPath(xpath.getString(resourceXPath));
//        mobileElement.sendKeys(text);
//    }
//
//    protected void sleep(int sleepSecond) {
//        try {
//            TimeUnit.SECONDS.sleep(sleepSecond);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    protected Integer getOrderCountFromString(String line) {
//        String pattern = "\\s\\d+\\s";
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(line);
//        if (m.find()) {
//            return Integer.valueOf(m.group(0).trim());
//        } else {
//            return null;
//        }
//    }
//
//    protected String getPhoneXPath() {
//        String phoneMask = "(###) ###-##-##";
//        String phoneNumber = data.getString("Телефон");
//        String phoneNumberByMask = "";
//
//        MaskFormatter maskFormatter = null;
//        try {
//            maskFormatter = new MaskFormatter(phoneMask);
//            maskFormatter.setValueContainsLiteralCharacters(false);
//            phoneNumberByMask = maskFormatter.valueToString(phoneNumber);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return MessageFormat.format(xpath.getString("ФормаСмс"), phoneNumberByMask);
//    }
//
//    protected void scrollToElementByXpaths(String resourceXPath/*, int swipeSpeed*/) {
//        scrollToElementByXpaths(null, resourceXPath, true);
//    }
//
//    protected void scrollToElementByXpaths(List<String> xpaths/*, int swipeSpeed*/) {
//        scrollToElementByXpaths(xpaths, null, true);
//    }
//
//    protected void scrollToElementByXpaths(List<String> xpaths, String resourceXPath, boolean isEnabled/*, int swipeSpeed*/) {
//        // ToDo Тесты показали, что во время swipe элементы DOM-дерева находящиеся выше могут пропадать из DOM, соотв mobileElement НЕ будет находится...
//        //      Почему это происходит и как решать проблему - непонятно. Так же непонятно как определить: текущее положение scroll; убедиться что мы уперлись в верхнюю границу
//        //      Вероятно универсального механизма 'swipe до нужного элемента' не существует (ранее существовавщая реализация AppiumDriver.swipe() была убрана)
//
//        // На 1 экран вверх (возможно это лишнее)
////        HashMap paramsUpScroll = new HashMap<>();
////        paramsUpScroll.put("direction", "down");
////        driver.executeScript("mobile: swipe", paramsUpScroll);
//
//        // Находим элемент и проверяем на экране ли (isDisplayed), если да, то возвращаемся сразу
//        MobileElement mobileElement = null;
//        if (isEnabled) {
//            if (xpaths != null) {
//                for (String xpath : xpaths) {
//                    mobileElement = mobileElement == null ? (MobileElement) driver.findElementByXPath(xpath) : mobileElement.findElementByXPath(xpath);
//                }
//            }
//            if (resourceXPath != null) {
//                mobileElement = (MobileElement) driver.findElementByXPath(xpath.getString(resourceXPath));
//            }
//            if (mobileElement == null || !mobileElement.isEnabled()) {
//                System.out.println("Ошибка сценария: scrollToElementByXpaths нет элемента на странице");
//                return;
//            }
//            if (mobileElement != null && mobileElement.isDisplayed())
//                return;
//        }
//
//        // Определяем выше или ниже искомый mobileElement относительно центра экрана
//        String swipeDirection = isEnabled ? getSwipeDirection(displayWidth, mobileElement.getLocation().y) : "up";
//
//        boolean isDisplayed = isEnabled ? false : isExistByXPath(xpaths.get(0));
//
//        while (!isDisplayed) {
//            upSwipe();
//
//            isDisplayed = isEnabled ? mobileElement.isDisplayed() : isExistByXPath(xpaths.get(0));
//            if (!isDisplayed && isEnabled) {
//                // Если после текущего свайпа элемент "проскочил"
//                if (!swipeDirection.equals(getSwipeDirection(displayWidth, mobileElement.getLocation().y))) {
//                    // Корректируем "немного" положение экрана в обратном направлении (относительно swipeDirection)
//                    Map<String, Object> dragFromToForDuration = new HashMap<>();
//                    dragFromToForDuration.put("duration", 0);
//                    dragFromToForDuration.put("fromX", displayWidth / 2);
//                    dragFromToForDuration.put("toX", displayWidth / 2);
//                    if (swipeDirection.equals("down")) {
//                        dragFromToForDuration.put("fromY", displayHeight / 2 + displayHeight / 24);
//                        dragFromToForDuration.put("toY", displayHeight / 2);
//                    } else {
//                        dragFromToForDuration.put("fromY", displayHeight / 2);
//                        dragFromToForDuration.put("toY", displayHeight / 2 + displayHeight / 24);
//                    }
//                    driver.executeScript("mobile: dragFromToForDuration", dragFromToForDuration);
//
//                    // Выходим принудительно, т.к. считаем что элемент уже isDisplayed
//                    isDisplayed = true;
//                    break;
//                }
//            }
//        }
//    }
//
//    protected void upSwipe() {
//        Map<String, Object> dragFromToForDurationBase = new HashMap<>();
//        dragFromToForDurationBase.put("duration", 0);
//        dragFromToForDurationBase.put("fromX", displayWidth / 2);
//        dragFromToForDurationBase.put("toX", displayWidth / 2);
//        dragFromToForDurationBase.put("fromY", displayHeight / 2 + displayHeight / 6); // 6 - "swipeSpeed"
//        dragFromToForDurationBase.put("toY", displayHeight / 2);
//        driver.executeScript("mobile: dragFromToForDuration", dragFromToForDurationBase);
//    }
//
//    private String getSwipeDirection(int displayWidth, int mobileLocationY) {
//        return displayWidth / 2 - mobileLocationY > 0 ? "down" : "up";
//    }

}
