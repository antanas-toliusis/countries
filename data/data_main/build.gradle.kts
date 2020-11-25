import extensions.addCoreTestingDependencies

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
    implementation(project(Modules.CORE))

    api(Libs.RETROFIT)
    implementation(Libs.RETROFIT_CONVERTER_GSON)

    implementation(Libs.OK_HTTP_3)
    implementation(Libs.OKHTTP_LOGGING)

    implementation(Libs.HILT_GOOGLE)
    kapt(Libs.HILT_GOOGLE_COMPILER_CAPT)

    implementation(Libs.HILT_ANDROIDX_LIFECYCLE_VIEW_MODEL)
    kapt(Libs.HILT_ANDROIDX_COMPILER)

    addCoreTestingDependencies()
}
