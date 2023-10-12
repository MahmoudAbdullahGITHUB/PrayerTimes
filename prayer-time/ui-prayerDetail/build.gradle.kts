apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.interactors))

    // dagger - hilt
    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)
    "implementation"(Hilt.hiltNavigationCompose)

}