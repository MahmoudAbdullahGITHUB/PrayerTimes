apply {
    from("$rootDir/library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.domain))

// retrofit dependencies
    //    "implementation"("com.squareup.retrofit2:retrofit:2.9.0") // insert latest version here
    //    "implementation" ("com.squareup.retrofit2:converter-gson:2.9.0")

    "implementation"(Retrofit.retrofitCore)
    "implementation"(Retrofit.retrofitConverter)

    "implementation"(Retrofit.okHTTPInterceptor)
}