package extensions

import TestingLibs.TRUTH_TEST
import TestingLibs.JUNIT
import TestingLibs.KOTLIN_JUNIT
import TestingLibs.KOTLINX_COROUTINES
import TestingLibs.ANDROIDX_ARCH_CORE
import TestingLibs.MOCKITO_INLINE
import TestingLibs.MOCKITO_KOTLIN_2_NHAARAM
import TestingLibs.LIVE_DATA_TESTING_JRASKA
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addCoreTestingDependencies() {
    testImplementation(TRUTH_TEST)
    testImplementation(JUNIT)
    testImplementation(KOTLIN_JUNIT)

    testImplementation(ANDROIDX_ARCH_CORE)
    testImplementation(KOTLINX_COROUTINES)
    testImplementation(LIVE_DATA_TESTING_JRASKA)

    testImplementation(MOCKITO_KOTLIN_2_NHAARAM)
    testImplementation(MOCKITO_INLINE)
}

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

