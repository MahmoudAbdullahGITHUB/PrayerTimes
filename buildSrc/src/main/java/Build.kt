object Build {

    private const val androidBuildToolsVersion = "7.1.0"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    const val hiltAndroid = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.hiltVersion}"

    const val saveArgsClassPath = "androidx.navigation:navigation-safe-args-gradle-plugin:${Navigation.nav_version}"

    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"

    private const val googleServicesVersion = "4.3.10"
    const val googleServices = "com.google.gms:google-services:$googleServicesVersion"

    private const val realmVersion = "10.10.1"
    const val realmGradle = "io.realm:realm-gradle-plugin:$realmVersion"

    private const val junit5GradleVersion = "1.8.2.0"
    const val junit5Gradle = "de.mannodermaus.gradle.plugins:android-junit5:$junit5GradleVersion"


}