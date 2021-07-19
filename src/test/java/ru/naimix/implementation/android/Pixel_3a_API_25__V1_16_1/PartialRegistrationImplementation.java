package ru.naimix.implementation.android.Pixel_3a_API_25__V1_16_1;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import lombok.SneakyThrows;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.naimix.declaration.partialRegistration.PartialRegistration;
import ru.naimix.device.AndroidDevice;
import ru.naimix.util.StringFunctions;

import java.util.concurrent.TimeUnit;

import static com.google.common.base.Predicates.equalTo;
//import static org.assertj.core.api.Assertions.assertThat;
import static ru.naimix.service.AndroidService.*;

public class PartialRegistrationImplementation extends AndroidDevice implements PartialRegistration {

    @Override
    public void openApp() {

    }

    @Override
    public void startRegistration() {
        clickElementByXPath("Регистрация");
//        assertThat("Переход на страницу авторизации НЕ выполнен",
//                isDisplayedByXPath("Поле_ввода_номера_телефона"), equalTo(true));
//        assertThat(isDisplayedByXPath("Поле_ввода_номера_телефона")).isTrue();
    }

    @SneakyThrows
    @Override
    public void enterPhoneNumber() {
        if (System.getenv("PhoneNumber") != null)
            sendKeysIntoElementByXPath("Поле_ввода_номера_телефона", System.getenv("PhoneNumber"));
        else
            sendKeysIntoElementByXPath("Поле_ввода_номера_телефона", data.getString("Номер_телефона"));

//        assertThat("МП-ЧР enterPhoneNumber: Кнопка 'Регистрация' НЕ стала активна",
//                checkColorElement("Регистрация", 1), equalTo(true));
    }

    @Override
    public void goToEnterConfirmationCode() {
        clickElementByXPath("Регистрация", 1);

        // TODO: 19.02.2021 необходимо проверить отправку сообщения с кодом на указанный номер телефона
//        assertThat("Смс с кодом НЕ отправлено на указанный номер", , );

//        assertThat("Переход на страницу подтверждения номера телефона НЕ выполнен",
//                isDisplayedByXPath("Страница_подтверждения_номера_телефона"), equalTo(true));
    }

    @Override
    public void enterConfirmationCode() {
        //не получается завязаться на элементах, поэтому здесь костыль в виде отсчета времени и нажатия по координатам
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TouchAction<?> action = new TouchAction<>(driver);

        Dimension size = driver.manage().window().getSize();

        for (int i = 0; i < 4; i++) {
            /* Относительные координаты по ширине должны соблюдаться для всех разрешений экрана
            По высоте координаты должны также сохраняться для любой высоты экрана, т.к. цифровая клавиатура
            должна иметь заданный размер от низа экрана */
            action.tap(PointOption.point((int) (size.width / 2.5), size.height - 35)).perform();
        }

//        assertThat("Переход на страницу заполнения ФИО и Email НЕ выполнен",
//                isDisplayedByXPath("Фамилия_Имя_Отчество"), equalTo(true));
    }

    @Override
    public void enterYourName() {
        sendKeysIntoElementByXPath("Фамилия_Имя_Отчество", StringFunctions.randomFio());
//        sendKeysIntoElementByXPath("Фамилия_Имя_Отчество", "LatinskiyeBukvi");
//        driver.navigate().back();
//        assertThat("Кнопка 'Продолжить' активна",
//                checkColorElement("Продолжить[кнопка]"), equalTo(false));
    }

    @Override
    public void enterYourEmail() {
        sendKeysIntoElementByXPath("Email", StringFunctions.randomEmail(10));
//        driver.navigate().back();
//        assertThat("Кнопка 'Продолжить' активна",
//                checkColorElement("Продолжить[кнопка]"), equalTo(false));
    }

    @Override
    public void activateCheckBoxConsentProcessingData() {
        clickElementByXPath("Даю_согласие_на_обработку_персональных_данных");
//        assertThat("Кнопка 'Продолжить' НЕактивна",
//                checkColorElement("Продолжить[кнопка]"), equalTo(true));
    }

    @Override
    public void goToSelectionTypeOfWork() {
        clickElementByXPath("Продолжить[кнопка]");
//        assertThat("Переход на страницу выбора вида деятельности НЕ выполнен",
//                isDisplayedByXPath("Укажите_ваш_основной_вид_деятельности[надпись]"), equalTo(true));
    }

    @Override
    public void selectTypeOfWork() {
        clickElementByXPath("Выберите_вид_деятельности[поле]");
        clickElementByXPath("Выбрать_вид_деятельности", "Вид_деятельности");
        // TODO: 19.02.2021 реализовать скроллинг? или будет так работать?
//        assertThat("Кнопка 'Продолжить' НЕ активна",
//                checkColorElement("Продолжить[кнопка]", 1), equalTo(true));
    }

    @Override
    public void goToSelectionAdditionalWork() {
        clickElementByXPath("Продолжить[кнопка]", 1);
//        assertThat("Переход на страницу выбора дополнительного вида деятельности НЕ выполнен",
//                isDisplayedByXPath("Укажите_ваш_дополнительный_вид_деятельности[надпись]"), equalTo(true));
    }

    @Override
    public void selectAdditionalWork() {
        sendKeysIntoElementByXPath("Поиск[поле]", data.getString("Дополнительный_вид_деятельности"));
        clickElementByXPath("Выбрать_вид_деятельности", "Дополнительный_вид_деятельности");
//        assertThat("Кнопка 'Продолжить' НЕактивна",
//                checkColorElement("Продолжить[кнопка]", 1), equalTo(true));
    }

    @Override
    public void goToSelectionRegion() {
        clickElementByXPath("Продолжить[кнопка]", 1);
//        assertThat("Переход на страницу выбора города и региона НЕ выполнен",
//                isDisplayedByXPath("Укажите_город_где_ведете_деятельность[надпись]"), equalTo(true));
    }

    @SneakyThrows
    @Override
    public void selectRegionJob() {
//        if (driver.findElementByXPath(xpath.getString("Не_удалось_определить_ваше_местоположение[надпись]")) != null)
//            clickElementByXPath("Ок");
        try {
//                sleep(3);
            driver.findElementByXPath(xpath.getString("Отмена[кнопка]")).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
//        if (driver.findElementByXPath(xpath.getString("Отмена[кнопка]")) != null)
//            clickElementByXPath("Отмена[кнопка]");
        if (data.getString("Работаю_удаленно").equals("Работаю удаленно"))
            clickElementByXPath("Выбрать_регион_и_город_где_ведете_деятельность", "Работаю_удаленно");

        WebElement searchField = driver.findElementByXPath(xpath.getString("Поиск[поле]"));
        ((AndroidElement) searchField).setValue(data.getString("Регион_и_город_где_ведете_деятельность"));
        TimeUnit.SECONDS.sleep(2);
        searchField.click();
        TimeUnit.SECONDS.sleep(2);

        clickElementByXPath("Первый_предложенный_вариант_из_списка_городов_и_регионов");

//        assertThat("Кнопка 'Продолжить' НЕактивна",
//                checkColorElement("Продолжить[кнопка]", 1), equalTo(true));
    }

    @Override
    public void goToSelectionCitiesAndRegionsForDeparture() {
        clickElementByXPath("Продолжить[кнопка]", 1);
//        assertThat("Переход на страницу выбора городов и регионов для выезда НЕ выполнен",
//                isDisplayedByXPath("Укажите_города_для_выезда[надпись]"), equalTo(true));
    }

    @Override
    public void selectCitiesAndRegionsForDeparture() {
        WebElement searchField = driver.findElementByXPath(xpath.getString("Поиск[поле]"));
        ((AndroidElement) searchField).setValue(data.getString("Дополнительный_регион_и_город_где_ведете_деятельность"));
        searchField.click();

        clickElementByXPath("Первый_предложенный_вариант_из_списка_городов_и_регионов");

//        assertThat("Кнопка 'Сохранить' НЕактивна",
//                checkColorElement("Сохранить[кнопка]"), equalTo(true));
    }


    @Override
    public void completeRegistration() {
        clickElementByXPath("Сохранить[кнопка]");
//        assertThat("Частичная регистрация не завершена, окно с предложение заполнить профиль не вылезло",
//                checkColorElement("Заполните_профиль[кнопка]"), equalTo(true));
    }

    @Override
    public void closeNotification() {
        clickElementByXPath("Закрыть_уведомление");
    }
}
