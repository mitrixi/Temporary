package ru.naimix.util;

import com.codeborne.selenide.logevents.SelenideLog;
import com.codeborne.selenide.logevents.SelenideLogger;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.logevents.LogEvent.EventStatus.PASS;

public class Common {

    @SneakyThrows
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void allureLogValue(String name, String value) {
        SelenideLog log = SelenideLogger.beginStep("[info] " + name, value);
        SelenideLogger.commitStep(log, PASS);
    }

    /**
     * Создает локатор By из паттерна XPath, подставляя туда substitutions (некоторые объекты)
     *
     * @param locatorPattern Строка, может включать %s и прочие спец. последовательности, поддерживаемые String.format
     * @param substitutions  Некоторый объект, обычно строка
     * @return By
     */
    public static By xPathPatternToBy(String locatorPattern, Object... substitutions) {
        return new By.ByXPath(String.format(locatorPattern, substitutions));
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int randomInt(int maxNotIncluded) {
        return ThreadLocalRandom.current().nextInt(maxNotIncluded);
    }

    public static long randomLong(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    public static long randomLong(long maxNotIncluded) {
        return ThreadLocalRandom.current().nextLong(maxNotIncluded);
    }

    public static double randomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public static double randomDouble(double max) {
        return ThreadLocalRandom.current().nextDouble(max);
    }

}
