package com.example.appiumtest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class Base {
    private AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        // Lokasi file APK
        File appDir = new File("src/test/resources");
        File app = new File(appDir, "ApiDemos-debug.apk");

        // Set capabilities using UiAutomator2Options
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Medium Phone API 35")
                .setApp(app.getAbsolutePath())
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);

        // Inisialisasi AndroidDriver
        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Application started...");
    }

    @Test
    public void sampleTest() {
        // Tambahkan logika test di sini
        System.out.println("Test is running...");
        // contoh: driver.findElement(By.id("some_id")).click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
