package ru.naimix.service;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

public class WebService {
    @SneakyThrows
    public static boolean checkColorElement(String xPath) {

        //ожидание времени на прорисовку анимации
        TimeUnit.SECONDS.sleep(2);

        Point point = $(By.xpath(xPath)).getLocation();
        File srcFile2 = screenshot(OutputType.FILE);
        BufferedImage image2 = ImageIO.read(srcFile2);

        int color = image2.getRGB(point.getX(), point.getY());

        int red = (color & 0x00ff0000) >> 16;
        int green = (color & 0x0000ff00) >> 8;
        int blue = color & 0x000000ff;

        return (red < 90 && red > 60) && (green < 185 && green > 155) && (blue < 70 && blue > 20);
    }
}
