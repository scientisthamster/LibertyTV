import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import extensions.*

plugins {
    id("commons.android-library")
}

android {
    buildTypes.forEach {
        try {
            it.buildConfigStringField("TMDB_API_BASE_URL", "https://api.themoviedb.org/3/")
            it.buildConfigStringField("TMDB_API_KEY", getLocalProperty("moviedb.key"))

            it.buildConfigBooleanField("MOVIE_DATABASE_EXPORT_SCHEMA", false)
            it.buildConfigStringField("MOVIE_DATABASE_NAME", "movie-db")
            it.buildConfigIntField("MOVIE_DATABASE_VERSION", 1)
        } catch (ignored: Exception) {
            throw InvalidUserDataException(
                "You should define 'moviedb.key' in local.properties. Visit 'https://www.themoviedb.org/' " +
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