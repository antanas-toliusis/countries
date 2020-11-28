object Plugins {

    private const val ANDROID_PLUGIN_GRADLE_VERSION = "4.1.1"
    private const val NAV_SAFE_ARGS_PLUGIN_VERSION = "2.3.0"
    private const val KT_LINT_VERSION = "9.4.0"

    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val ANDROID = "android"
    const val NAVIGATION_SAFEARGS = "androidx.navigation.safeargs"
    const val KAPT = "kapt"
    const val KOTLIN = "kotlin"
    const val HILT = "dagger.hilt.android.plugin"

    const val ANDROID_PLUGIN_GRADLE_CLASSPATH = "com.android.tools.build:gradle:${ANDROID_PLUGIN_GRADLE_VERSION}"
    const val NAV_SAFE_ARGS_PLUGIN_CLASSPATH = "androidx.navigation:navigation-safe-args-gradle-plugin:${NAV_SAFE_ARGS_PLUGIN_VERSION}"
    const val KOTLIN_PLUGIN_CLASSPATH = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val HILT_CLASSPATH = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT_GOOGLE}"

    const val KT_LINT_PLUGIN = "org.jlleitschuh.gradle.ktlint"
    const val KT_LINT_CLASSPATH = "org.jlleitschuh.gradle:ktlint-gradle:$KT_LINT_VERSION"
}