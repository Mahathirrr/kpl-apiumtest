package com.example.appiumtest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

    public static void main(String[] args) throws MalformedURLException {
        // Lokasi file APK
        File appDir = new File("src/main/resources");
        File app = new File(appDir, "ApiDemos-debug.apk");

        // Set desired capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35"); // Nama emulator
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        // Inisialisasi AndroidDriver
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(
                new URL("http://127.0.0.1:4723/wd/hub"), cap);

        System.out.println("Application started...");
    }
}
