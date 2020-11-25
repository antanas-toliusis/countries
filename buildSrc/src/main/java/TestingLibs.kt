object TestingLibs {

    private object TestVersions {
        const val JUNIT = "4.13"
        const val TRUTH = "1.0"
        const val ANDROIDX_ARCH_CORE = "2.1.0"
        const val LIVE_DATA_TESTING_JRASKA = "1.1.2"
        const val MOCKITO_KOTLIN_2_NHAARAM = "2.2.0"
        const val MOCKITO_INLINE = "3.6.0"
    }

    const val JUNIT = "junit:junit:${TestVersions.JUNIT}"
    const val KOTLIN_JUNIT = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.KOTLIN}"
    const val TRUTH_TEST = "com.google.truth:truth:${TestVersions.TRUTH}"
    const val ANDROIDX_ARCH_CORE = "androidx.arch.core:core-testing:${TestVersions.ANDROIDX_ARCH_CORE}"
    const val KOTLINX_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
    const val LIVE_DATA_TESTING_JRASKA = "com.jraska.livedata:testing-ktx:${TestVersions.LIVE_DATA_TESTING_JRASKA}"

    const val MOCKITO_KOTLIN_2_NHAARAM = "com.nhaarman.mockitokotlin2:mockito-kotlin:${TestVersions.MOCKITO_KOTLIN_2_NHAARAM}"
    const val MOCKITO_INLINE = "org.mockito:mockito-inline:${TestVersions.MOCKITO_INLINE}"
}
