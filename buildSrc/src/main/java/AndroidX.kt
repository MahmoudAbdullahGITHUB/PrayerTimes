object AndroidX {
    private const val coreKtxVersion = "1.7.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.4.1"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val lifecycleVmKtxVersion = "2.4.1"
    const val lifecycleVmKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVmKtxVersion"

    private const val work_version = "2.7.1"
    const val workManagerRuntimeKtx = "androidx.work:work-runtime-ktx:$work_version"

}

object AndroidXTest {
    private const val version = "1.4.0"
    const val runner = "androidx.test:runner:$version"
    const val core = "androidx.test:core-ktx:$version"
    const val arch ="androidx.arch.core:core-testing:2.1.0"
}