/**
 * Created by Khomiak Ivan on 12,May,2022
 */
object BuildAndroidConfig {
    const val APPLICATION_ID = "com.scientifichamster.libertytv"

    const val BUILD_TOOLS_VERSION = "31.0.0"
    const val COMPILE_SDK_VERSION = 31
    const val MIN_SDK_VERSION = 26
    const val TARGET_SDK_VERSION = 31

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    val TEST_INSTRUMENTATION_RUNNER_ARGUMENTS = mapOf(
        "leakcanary.FailTestOnLeakRunListener" to "listener"
    )
    //TODO check
}