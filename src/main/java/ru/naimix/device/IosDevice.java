package ru.naimix.device;

public abstract class IosDevice /*extends Device*/ {

//    public IOSDriver<WebElement> driver;
//
//    public IosDevice() {
//        //        String deviceConfigPath = System.getenv("DeviceConfigPath") ;
//        String deviceConfigPath =
//                StringUtils.isNotEmpty(System.getenv("DeviceConfigPath"))
//                        ? System.getenv("DeviceConfigPath")
//                        : this.getClass().getClassLoader().getResource("config/ios.json").getPath();
////                        : "/Users/mmtr/IdeaProjects/_Namemix/naimix/src/test/resources/config/ios.json";
//
//        JSONObject appiumJson = JsonService.readJsonFromFile(deviceConfigPath);
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "iOS");
//        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
//        capabilities.setCapability("automationName", "XCUITest");
//
//        JSONObject capabilitiesStr = JsonService.getCapabilities(appiumJson);
//        capabilitiesStr.keySet().forEach(keyStr -> capabilities.setCapability(keyStr, capabilitiesStr.get(keyStr)));
//
//        try {
//            driver = new IOSDriver<>(new URL(JsonService.getUrl(appiumJson)), capabilities);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        driver.manage().timeouts().implicitlyWait(JsonService.getImplicitlyWait(appiumJson), TimeUnit.SECONDS);
//    }
}
