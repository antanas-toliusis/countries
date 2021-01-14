import extensions.addCoreTestingDependencies

plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.NAVIGATION_SAFEARGS)
    id(Plugins.HILT)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
}

android {
    compileSdkVersion(Config.COMPILE_SDK)

    defaultConfig {
        minSdkVersion(Config.MIN_SDK)
        targetSdkVersion(Config.TARGET_SDK)
        applicationId = Config.APPLICATION_ID
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(project(Modules.CORE))
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.DATA_MAIN))
    implementation(project(Modules.DATABASE))
    implementation(project(Modules.NETWORK))

    implementation(Libs.APP_STARTUP)

    implementation(Libs.HILT_GOOGLE)
    kapt(Libs.HILT_GOOGLE_COMPILER_CAPT)

    implementation(Libs.HILT_ANDROIDX_LIFECYCLE_VIEW_MODEL)
    kapt(Libs.HILT_ANDROIDX_COMPILER)

    addCoreTestingDependencies()
}
