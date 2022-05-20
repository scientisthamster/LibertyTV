import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import extensions.buildConfigStringField
import extensions.implementation
import extensions.kapt

plugins {
    id("commons.android-library")
}

android {
    buildTypes.forEach {
        try {
            it.buildConfigStringField("API_BASE_URL", "https://todo.com")
        } catch (ignored: Exception) {
            throw InvalidUserDataException(
                "You should define 'marvel.key.public' and " +
                        "'marvel.key.private' in local.properties. Visit 'https://developer.marvel.com' " +
                        "to obtain them."
            )
        }
    }
}

dependencies {
    implementation(Dependencies.ROOM)
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER)
    implementation(Dependencies.LOGGING)
    implementation(Dependencies.MOSHI)
    implementation(Dependencies.MOSHI_KTX)

    kapt(AnnotationProcessorsDependencies.ROOM)
}