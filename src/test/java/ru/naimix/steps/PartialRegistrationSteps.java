package ru.naimix.steps;

import io.qameta.allure.Step;

public class PartialRegistrationSteps extends Steps {

    @Step("Открыть приложение")
    public void openApp() {
        device.testDeclaration.openApp();
    }

    @Step("Начать регистрацию")
    public void openMyOrders() {
        device.testDeclaration.openMyOrders();
    }

    @Step("Начать регистрацию")
    public void startRegistration() {
        device.testDeclaration.startRegistration();
    }

    @Step("Ввести номер телефона")
    public void enterPhoneNumber() {
        device.testDeclaration.enterPhoneNumber();
    }

    @Step("Подтвердить введенный номер телефона и перейти на страницу ввода кода подтверждения")
    public void goToEnterConfirmationCode() {
        device.testDeclaration.goToEnterConfirmationCode();
    }

    @Step("Ввести код подтверждения")
    public void enterConfirmationCode() {
        device.testDeclaration.enterConfirmationCode();
    }

    @Step("Ввести ФИО")
    public void enterYourName() {
        device.testDeclaration.enterYourName();
    }

    @Step("Ввести email")
    public void enterYourEmail() {
        device.testDeclaration.enterYourEmail();
    }

    @Step("Дать согласие на обработку данных")
    public void activateCheckBoxConsentProcessingData() {
        device.testDeclaration.activateCheckBoxConsentProcessingData();
    }

    @Step("Подтвердить введенные ФИО и email и перейти на страницу выбора вида деятельности")
    public void goToSelectionTypeOfWork() {
        device.testDeclaration.goToSelectionTypeOfWork();
    }

    @Step("Выбрать вид деятельности")
    public void selectTypeOfWork() {
        device.testDeclaration.selectTypeOfWork();
    }

    @Step("Перейти на страницу выбора дополнительного вида деятельности")
    public void goToSelectionAdditionalWork() {
        device.testDeclaration.goToSelectionAdditionalWork();
    }

    @Step("Выбрать дополнительный вид деятельности")
    public void selectAdditionalWork() {
        device.testDeclaration.selectAdditionalWork();
    }

    @Step("Подтвердить выбранный(ые) вид(ы) деятельности и перейти на страницу выбора региона")
    public void goToSelectionRegion() {
        device.testDeclaration.goToSelectionRegion();
    }

    @Step("Выбрать регион")
    public void selectRegionJob() {
        device.testDeclaration.selectRegionJob();
    }

    @Step("Перейти на страницу выбора регионов для выезда")
    public void goToSelectionCitiesAndRegionsForDeparture() {
        device.testDeclaration.goToSelectionCitiesAndRegionsForDeparture();
    }

    @Step("Выбрать регион для выезда")
    public void selectCitiesAndRegionsForDeparture() {
        device.testDeclaration.selectCitiesAndRegionsForDeparture();
    }

    @Step("Подтвердить выбранный регион и завершить регистрацию")
    public void completeRegistration() {
        device.testDeclaration.completeRegistration();
    }

    @Step("Закрыть уведомление")
    public void closeNotification() {
        device.testDeclaration.closeNotification();
    }
}
