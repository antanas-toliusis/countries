buildscript {

    repositories {
        google()
        jcenter()
        gradlePluginPortal()
    }
    dependencies {
        classpath(Plugins.KOTLIN_PLUGIN_CLASSPATH)
        classpath(Plugins.ANDROID_PLUGIN_CLASSPATH)
        classpath(Plugins.NAV_SAFE_ARGS_PLUGIN_CLASSPATH)
        classpath(Plugins.HILT_CLASSPATH)
        classpath(Plugins.KT_LINT_CLASSPATH)
    }
}

allprojects {
    apply(plugin = Plugins.KT_LINT_PLUGIN)

    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
