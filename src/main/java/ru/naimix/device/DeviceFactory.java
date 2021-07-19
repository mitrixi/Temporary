package ru.naimix.device;

import ru.naimix.device.version.android.Pixel_3a_API_25__V1_16_1;
import ru.naimix.device.version.ios.I6__V1_16_12;

import java.util.Arrays;
import java.util.function.Supplier;

public enum DeviceFactory {
//    I6_V1_16_12(I6__V1_16_12::getInstance),
    Pixel3a_API25_V1_16_1(Pixel_3a_API_25__V1_16_1::getInstance);

    private final Supplier<Device> instantiator;

    DeviceFactory(Supplier<Device> instantiator) {
        this.instantiator = instantiator;
    }

    private Device getInstance() {
        return instantiator.get();
    }

    public static Device getDeviceInstance(String deviceName) {
        return Arrays.stream(DeviceFactory.values()).anyMatch(val -> val.name().equals(deviceName))
                ? DeviceFactory.valueOf(deviceName).getInstance()
                : null;
    }
}