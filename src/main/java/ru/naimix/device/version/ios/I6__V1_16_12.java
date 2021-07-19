package ru.naimix.device.version.ios;


import ru.naimix.device.IosDevice;

import java.util.ResourceBundle;

public final class I6__V1_16_12 extends IosDevice {

//    private ResourceBundle xpath = ResourceBundle.getBundle("version/I6_V1_16_12/xpath");
//    private ResourceBundle data = ResourceBundle.getBundle("version/I6_V1_16_12/data");
//
//    I6__V1_16_12() {
//        super();
//        partialRegistrationImpl = new PartialRegistrationImpl(new Version(driver, xpath, data));
//        fullRegistrationImpl = new FullRegistrationImpl(new Version(driver, xpath, data));
//        sendAndConfirmRequestImpl = new SendAndConfirmRequestAppImpl(new Version(driver, xpath, data));
//    }
//
    public static abstract class SingletonHolder {
        private final static I6__V1_16_12 instance = new I6__V1_16_12();
    }

    public static I6__V1_16_12 getInstance() {
        return SingletonHolder.instance;
    }
//
//    private PartialRegistrationImpl partialRegistrationImpl;
//
//    @Override
//    public PartialRegistration partialRegistration() {
//        return partialRegistrationImpl;
//    }
//
//    private FullRegistrationImpl fullRegistrationImpl;
//
//    @Override
//    public FullRegistration fullRegistration() {
//        return fullRegistrationImpl;
//    }
//
//    private SendAndConfirmRequestAppImpl sendAndConfirmRequestImpl;
//
//    @Override
//    public SendAndConfirmRequestApp sendAndConfirmRequestApp() {
//        return sendAndConfirmRequestImpl;
//    }
//
//    private SendAndConfirmRequestWebImpl sendAndConfirmRequestWebImpl;
//
//    @Override
//    public SendAndConfirmRequestWeb sendAndConfirmRequestWeb() {
//        return sendAndConfirmRequestWebImpl;
//    }
//
//    private GettingStatusVerificationPassed gettingStatusVerificationPassed;
//
//    @Override
//    public GettingStatusVerificationPassed gettingStatusVerificationPassed() {
//        return gettingStatusVerificationPassed;
//    }
//
//
//    @Override
//    public void openApp() {
//
//    }
//
//    @Override
//    public String getTestPhone() {
//        return "7" + data.getString("Телефон");
//    }

}
