plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.appiumtest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.appiumtest"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        getByName("main") {
            resources.srcDir("src/main/resources")
        }
        getByName("test") {
            java.srcDir("src/test/java")
            resources.srcDir("src/test/resources")
        }
    }

    testOptions {
        unitTests.all {
            it.useTestNG()
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)

    // Pindahkan Appium dan Selenium ke testImplementation
    testImplementation(libs.appium.java.client)
    testImplementation(libs.selenium.java)
    testImplementation(libs.testng)

    // Dependency bawaan Android
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
