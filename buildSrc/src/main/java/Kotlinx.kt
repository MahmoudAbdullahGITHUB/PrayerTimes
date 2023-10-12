object Kotlinx {
    private const val kotlinxDatetimeVersion = "0.4.0"
    const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion"

    private const val coroutinesCoreVersion = "1.6.4"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesCoreVersion"

    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesCoreVersion"

    // Need for tests. Plugin doesn't work.
    private const val serializationVersion = "1.4.0"
    const val serialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion"

    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:1.8.0"
}