package ru.naimix.steps;

import ru.naimix.device.Device;
import ru.naimix.device.DeviceFactory;

public class Steps {
    Device device = DeviceFactory.getDeviceInstance(System.getProperty("DeviceVersion"));
}

