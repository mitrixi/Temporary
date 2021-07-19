package ru.naimix.declaration.partialRegistration;

/**
 * В чек-листе: "Частичная регистрация"
 */
public interface PartialRegistration {

    void openApp();
    void startRegistration();
    void enterPhoneNumber();
    void goToEnterConfirmationCode();
    void enterConfirmationCode();
    void enterYourName();
    void enterYourEmail();
    void activateCheckBoxConsentProcessingData();
    void goToSelectionTypeOfWork();
    void selectTypeOfWork();
    void goToSelectionAdditionalWork();
    void selectAdditionalWork();
    void goToSelectionRegion();
    void selectRegionJob();
    void goToSelectionCitiesAndRegionsForDeparture();
    void selectCitiesAndRegionsForDeparture();
    void completeRegistration();
    void closeNotification();
}


