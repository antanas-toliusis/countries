import Modules.DATABASE
import Modules.DOMAIN
import Modules.NETWORK
import extensions.addCoreTestingDependencies

plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.NAVIGATION_SAFEARGS)
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(DOMAIN))
    api(project(NETWORK))
    api(project(DATABASE))

    api(Libs.CORE_KTX)
    api(Libs.APPCOMPAT)

    api(Libs.CONSTRAINT_LAYOUT)
    api(Libs.MATERIAL_DESIGN)

    api(Libs.NAV_FRAGMENT_KTX)
    api(Libs.NAV_UI_KTX)

    api(Libs.LIFECYCLE_CORE_KTX)
    api(Libs.LIFECYCLE_RUNTIME_KTX)
    api(Libs.LIFECYCLE_LIVEDATA_KTX)
    api(Libs.LIFECYCLE_VIEW_MODEL_KTX)
    api(Libs.LIFECYCLE_VIEW_MODEL_SAVED_STATE)
    api(Libs.LIFECYCLE_COMMON_JAVA_8)

    api(Libs.COROUTINES_ANDROID)
    api(Libs.COLLECTIONS_KTX)
    api(Libs.TIMBER_KT)
    api(Libs.GSON)

    implementation(Libs.GLIDE)
    api(Libs.GLIDE_TO_VECTOR_YOU)
    kapt(Libs.GLIDE_COMPILER)

    addCoreTestingDependencies()
}
