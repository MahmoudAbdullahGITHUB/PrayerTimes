apply {
    from("$rootDir/library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.datasource))

    "implementation"(project(Modules.domain))

    "implementation"(Coroutines.coroutine)

}