plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.coachingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coachingapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests {
            // Prevents the invocation of methods in Android framework classes that might cause runtime exceptions during unit testing.
//            includeAndroidResources = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("com.android.volley:volley:1.2.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

    // Unit testing
    testImplementation("junit:junit:4.13.2")

    // AndroidX Test - Instrumentation Testing
    androidTestImplementation("androidx.test:core:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")

    // AndroidX Test - JUnit Support
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    // Espresso for UI testing
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Include these for unit tests
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("androidx.test:core:1.5.0")
    testImplementation("androidx.test:rules:1.5.0")
    testImplementation("androidx.test:runner:1.5.2")
    testImplementation("androidx.test.espresso:espresso-core:3.5.1")





    testImplementation ("org.mockito:mockito-core:3.12.4")
    testImplementation ("org.mockito:mockito-core:4.2.0")
    testImplementation ("org.mockito:mockito-inline:4.2.0")

    implementation ("com.google.firebase:firebase-auth:21.0.1")
    testImplementation ("org.powermock:powermock-api-mockito2:2.0.7")


    testImplementation ("org.mockito:mockito-inline:4.2.0")
    testImplementation ("org.powermock:powermock-api-mockito2:2.0.7")


}




















//plugins {
//    id("com.android.application")
//    id("com.google.gms.google-services")
//}
//
//android {
//    namespace = "com.example.coachingapp"
//    compileSdk = 34
//
//    defaultConfig {
//        applicationId = "com.example.coachingapp"
//        minSdk = 24
//        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//}
//
//dependencies {
//
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.11.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation("com.google.firebase:firebase-database:20.3.1")
//    implementation("com.google.firebase:firebase-auth:22.3.1")
//    implementation("com.android.volley:volley:1.2.1")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//
//
//
//    // AndroidX Test - Instrumentation Testing
//
//
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
//
//    // AndroidX Test - Instrumentation Testing
//    androidTestImplementation("androidx.test:core:1.4.0")
//    androidTestImplementation("androidx.test:runner:1.4.0")
//    androidTestImplementation("androidx.test:rules:1.4.0")
//
//    // AndroidX Test - JUnit Support
//    androidTestImplementation("androidx.test.ext:junit:1.1.3")
//
//    // Espresso for UI testing
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
//
//}