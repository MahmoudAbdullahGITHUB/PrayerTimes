apply {
    from("$rootDir/android-library-build.gradle")
}
apply(plugin = "org.jetbrains.kotlin.android")

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.domain))
    "implementation"(project(Modules.interactors))

    // dagger - hilt
    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)
    "implementation"(Hilt.hiltNavigationCompose)

}