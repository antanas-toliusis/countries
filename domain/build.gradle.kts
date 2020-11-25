import extensions.addCoreTestingDependencies

plugins {
    id(Plugins.KOTLIN)
    kotlin(Plugins.KAPT)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    addCoreTestingDependencies()
}
