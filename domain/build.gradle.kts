

plugins {
    id(Plugins.KOTLIN)
    kotlin(Plugins.KAPT)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Libs.HILT_GOOGLE)
    kapt(Libs.HILT_GOOGLE_COMPILER_CAPT)

    implementation(Libs.COROUTINES_ANDROID)

    testImplementation(TestingLibs.JUNIT)
    testImplementation(TestingLibs.TRUTH_TEST)
}
