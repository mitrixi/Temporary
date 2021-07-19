package ru.naimix.tests.partialRegistration;

import org.testng.annotations.Test;
import ru.naimix.steps.PartialRegistrationSteps;

public class PartialRegistrationTest  {
    PartialRegistrationSteps steps = new PartialRegistrationSteps();

    @Test(groups = "PartialRegistrationTest.partialRegistration", enabled = true)
    public void partialRegistration() {

        steps.openApp();
        steps.startRegistration();
        steps.enterPhoneNumber();
        steps.goToEnterConfirmationCode();
        steps.enterConfirmationCode();
        steps.enterYourName();
        steps.enterYourEmail();
        steps.activateCheckBoxConsentProcessingData();
        steps.goToSelectionTypeOfWork();
        steps.selectTypeOfWork();
        steps.goToSelectionAdditionalWork();
        steps.selectAdditionalWork();
        steps.goToSelectionRegion();
        steps.selectRegionJob();
        steps.goToSelectionCitiesAndRegionsForDeparture();
        steps.selectCitiesAndRegionsForDeparture();
        steps.completeRegistration();
        steps.closeNotification();
    }
}
