package ru.naimix.implementation.ios.I6__V1_16_12;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import lombok.SneakyThrows;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.naimix.declaration.partialRegistration.PartialRegistration;
import ru.naimix.implementation.TestsImplementation;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static ru.naimix.service.IosService.*;

public class PartialRegistrationImplementation extends TestsImplementation /*implements PartialRegistration*/ {
//    ////
//    public void startRegistration() {
//        clickElementByXPath("Регистрация");
//        assertThat("Переход на страницу авторизации НЕ выполнен", isExistByXPath("ЗаголовокТелефона"));
//    }
//
//    ////
//    public void enterPhoneNumber() {
//        // Атрибут enable у кнопки 'Регистрация' всегда true, поэтому проверяем косвенно
//        assertThat("МП-ЧР enterPhoneNumber: Кнопка 'Регистрация' НЕ должна быть активна", driver.findElementsByXPath(xpath.getString("Регистрация")).size(), lessThan(3));
//
////        MobileElement mobileElement = (MobileElement) driver.findElementByXPath(xpath.getString("ФормаТелефона"));
////        mobileElement.sendKeys(data.getString("Телефон"));
//        sendKeyByXpath("ФормаТелефона", data.getString("Телефон"));
//
//        assertThat("МП-ЧР enterPhoneNumber: Кнопка 'Регистрация' должна быть активна", driver.findElementsByXPath(xpath.getString("Регистрация")).size(), equalTo(3));
//    }
//
//    ////
//    public void goToEnterConfirmationCode() {
//        clickElementByXPath("Регистрация");
//
//        // ToDo Как проверить отправку конфирма, tshark?
//
////        assertThat("Переход на форму подтверждения СМС НЕ выполнен", driver.findElementByXPath(getPhoneXPath()).isDisplayed());
//        // не получается завязаться на появлении какого-нибудь элемента(someElement.isDisplayed()), поэтому здесь костыль в виде отсчета времени
//        sleep(5);
//    }
//
//    ////
//    public void enterConfirmationCode() {
//        TouchAction action = new TouchAction(driver);
//
//        // Вводим 0000
//        for (int i = 0; i < 4; i++) {
//            action.tap(PointOption.point(displayWidth / 2, displayHeight - displayHeight / 20)).perform();
//        }
//        assertThat("Переход на 1-й шаг ЧР НЕ выполнен", isExistByXPath("Шаг1"));
//    }
//
//    ////
//    public void enterYourName() {
////        MobileElement mobileElement = (MobileElement) driver.findElementByXPath(xpath.getString("ФИО"));
////        mobileElement.sendKeys(StringFunctions.randomFio());
//        sendKeyByXpath("ФИО", StringFunctions.randomFio());
//
//        // Атрибут enable у кнопки 'Продолжить' всегда true, поэтому проверяем косвенно
//        assertThat("МП-ЧР enterYourName: Кнопка 'Продолжить' НЕ должна быть активна", driver.findElementsByXPath(xpath.getString("Продолжить")).size(), lessThan(3));
//    }
//
//    ////
//    public void enterYourEmail() {
////        MobileElement mobileElement = (MobileElement) driver.findElementByXPath(xpath.getString("Email"));
////        mobileElement.sendKeys(StringFunctions.randomEmail(10));
//        sendKeyByXpath("Email", StringFunctions.randomEmail(10));
//
//        // Атрибут enable у кнопки 'Продолжить' всегда true, поэтому проверяем косвенно
//        assertThat("МП-ЧР enterYourEmail: Кнопка 'Продолжить' НЕ должна быть активна", driver.findElementsByXPath(xpath.getString("Продолжить")).size(), lessThan(3));
//    }
//
//    ////
//    public void activateCheckBoxConsentProcessingData() {
//        clickElementByXPath("Согласие");
//
//        // Атрибут enable у кнопки 'Продолжить' всегда true, поэтому проверяем косвенно
//        assertThat("МП-ЧР activateCheckBoxConsentProcessingData: Кнопка 'Продолжить' должна быть активна", driver.findElementsByXPath(xpath.getString("Продолжить")).size(), equalTo(3));
//    }
//
//    ////
//    public void goToSelectionTypeOfWork() {
//        clickElementByXPath("Продолжить");
//        // На данный момент, после обновления, элементы экрана не активны, делаем костыль:
////        assertThat("Переход на 2-й шаг ЧР НЕ выполнен", isDisplayedByXPath("Шаг2"));
//    }
//
//    ////
//    public void selectTypeOfWork() {
//        // На данный момент, после обновления, элементы экрана не активны, делаем костыль:
//
//        sleep(2);
//
//        TouchAction action = new TouchAction(driver);
//
//        // Кликаем по полю
//        action.tap(PointOption.point(displayWidth / 2, 160)).perform();
//        // Кликаем по "Автомеханик"
//        action.tap(PointOption.point(displayWidth / 2, 230)).perform();
//
////        // Атрибут enable у кнопки 'Продолжить' всегда true, поэтому проверяем косвенно
////        assertThat("МП-ЧР selectTypeOfActivity: Кнопка 'Продолжить' НЕ должна быть активна", driver.findElementsByXPath(xpath.getString("Продолжить")).size(), lessThan(3));
////
////        // Нет активного атрибута для определения isChecked элемента (вероятно это "проблема" ios приложения), поэтому
////        // Свайпим до нужного элемента
////        scrollToElementByXpaths(Arrays.asList(MessageFormat.format(xpath.getString("ВидДеятельности"), data.getString("ВидДеятельности"))));
////        // Делаем click по элементу
////        clickElementByXPath("ВидДеятельности", "ВидДеятельности");
////
////        // ToDo проверить стоит ли галка после клика можно сравнением картинок... См. проект VitrinaGit класс ImageCompare
////        assertThat("МП-ЧР selectTypeOfActivity: Кнопка 'Продолжить' должна быть активна", driver.findElementsByXPath(xpath.getString("Продолжить")).size(), equalTo(3));
//    }
//
//    ////
//    public void goToSelectionAdditionalWork() {
//        // На данный момент, после обновления, элементы экрана не активны, делаем костыль:
//
//        TouchAction action = new TouchAction(driver);
//
//        // Кликаем по /Продолжить/
//        sleep(2);
//
//        action.tap(PointOption.point(displayWidth / 2, 550)).perform();
//    }
//
//    ////
//    public void selectAdditionalWork() {
//        // Атрибут enable у кнопки 'Продолжить' всегда true, поэтому проверяем косвенно
//        // !!!bug!!! Тк срабатывает, временно коммент
////        assertThat("МП-ЧР selectAdditionalWork: Кнопка 'Продолжить' НЕ должна быть активна", driver.findElementsByXPath(xpath.getString("Продолжить")).size(), lessThan(3));
//
//        //Вводим в поиск первую букву
//        sendKeyByXpath("Поиск", data.getString("ДополнительныйВидДеятельности").substring(0, 1));
//
//        // Нет активного атрибута для определения isChecked элемента (вероятно это "проблема" ios приложения), поэтому
//        // Свайпим до нужного элемента
//        scrollToElementByXpaths(Arrays.asList(MessageFormat.format(xpath.getString("ДополнительныйВидДеятельности"), data.getString("ДополнительныйВидДеятельности"))));
//        // Делаем click по элементу
//        clickElementByXPath("ДополнительныйВидДеятельности", "ДополнительныйВидДеятельности");
//
//        // ToDo проверить стоит ли галка после клика можно сравнением картинок... См. проект VitrinaGit класс ImageCompare
//        assertThat("МП-ЧР selectAdditionalWork: Кнопка 'Продолжить' должна быть активна", driver.findElementsByXPath(xpath.getString("Продолжить")).size(), equalTo(3));
//    }
//
//    ////
//    public void goToSelectionRegion() {
//        clickElementByXPath("Продолжить");
//        // На данный момент, после обновления, элементы экрана не активны, поэтому коммент
////        assertThat("Переход на 4-й шаг ЧР НЕ выполнен", isDisplayedByXPath("Шаг4"));
//    }
//
//    ////
//    public void selectRegionJob() {
//        // На данный момент, после обновления, элементы экрана не активны, делаем костыль:
//
//        TouchAction action = new TouchAction(driver);
//
//        // Кликаем по полю
//        sleep(1);
//        action.tap(PointOption.point(displayWidth / 2, 160)).perform();
//        sleep(2);
//
//        driver.getKeyboard().sendKeys(data.getString("ГородИРегион").substring(2,4));
//        sleep(2);
//
//        // Выбираем СпБ
//        action.tap(PointOption.point(displayWidth / 2, 200)).perform();
//
////        // Атрибут enable у кнопки 'Продолжить' всегда true, поэтому проверяем косвенно
////        assertThat("МП-ЧР selectRegionJob: Кнопка 'Продолжить' НЕ должна быть активна", driver.findElementsByXPath(xpath.getString("Продолжить")).size(), lessThan(3));
////
////        // Нет активного атрибута для определения isChecked элемента (вероятно это "проблема" ios приложения), поэтому
////        // Свайпим до нужного элемента
////        scrollToElementByXpaths(Arrays.asList(MessageFormat.format(xpath.getString("Регион"), data.getString("Регион"))));
////        // Делаем click по элементу
////        clickElementByXPath("Регион", "Регион");
////
////        assertThat("МП-ЧР selectRegionJob: Кнопка 'Продолжить' должна быть активна", driver.findElementsByXPath(xpath.getString("Продолжить")).size(), equalTo(3));
//    }
//
//    ////
//    public void goToSelectionCitiesAndRegionsForDeparture() {
//        // На данный момент, после обновления, элементы экрана не активны, делаем костыль:
//
//        TouchAction action = new TouchAction(driver);
//
//        // Кликаем по /Продолжить/
//        sleep(2);
//
//        action.tap(PointOption.point(displayWidth / 2, 460)).perform();
//        assertThat("Переход на 5-й шаг ЧР НЕ выполнен", isExistByXPath("Шаг5"));
//    }
//
//    ////
//    public void selectCitiesAndRegionsForDeparture() {
//        // Атрибут enable у кнопки 'Сохранить' всегда true, поэтому проверяем косвенно
//        // !!!bug!!! Тк срабатывает, временно коммент
////        assertThat("МП-ЧР selectCitiesAndRegionsForDeparture: Кнопка 'Сохранить' НЕ должна быть активна", driver.findElementsByXPath(xpath.getString("Сохранить")).size(), lessThan(3));
//
//        //Вводим в поиск буквы
//        sendKeyByXpath("Поиск", data.getString("ГородИРегион").substring(2, 3)); // !!!bug!!! при ubstring(0,4)
//
//        sleep(2);
//
//        clickElementByXPath("ГородИРегион", "ГородИРегион");
//
//        assertThat("МП-ЧР selectCitiesAndRegionsForDeparture: Кнопка 'Сохранить' должна быть активна", driver.findElementsByXPath(xpath.getString("Сохранить")).size(), equalTo(3));
//    }
//
//    ////
//    public void completeRegistration() {
//        // Закрываем клавиатуру, иначе кнопка сохранить не работает
//        driver.hideKeyboard();
//
//        clickElementByXPath("Сохранить");
//        assertThat("Переход на /Заполните профиль/ НЕ выполнен", isExistByXPath("ЗаполнитеПрофиль"));
//    }
//
//    ////
//    public void closeNotification() {
//        clickElementByXPath("ЗакрытьЗаполнитеПрофиль");
//        sleep(2);
//        assertThat("Окно /Заполните профиль/ НЕ закрыто", isNotExistByXPath("ЗаполнитеПрофиль"));
//    }
}
