plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.HILT)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
}

android {
    compileSdkVersion(Config.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(Config.MIN_SDK)
        targetSdkVersion(Config.TARGET_SDK)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(Libs.ROOM_RUNTIME)
    implementation(Libs.ROOM_KTX)

    implementation(Libs.HILT_GOOGLE)
    kapt(Libs.HILT_GOOGLE_COMPILER_CAPT)
}
