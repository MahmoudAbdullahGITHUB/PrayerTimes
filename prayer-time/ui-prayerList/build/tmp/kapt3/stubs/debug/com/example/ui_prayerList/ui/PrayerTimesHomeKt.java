package com.example.ui_prayerList.ui;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a.\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\rH\u0007\u001a(\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0007\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0016\u00a8\u0006\u0017"}, d2 = {"DateAndLocation", "", "modifier", "Landroidx/compose/ui/Modifier;", "ImageFade", "dataClass", "Lcom/example/ui_prayerList/ui/PrayerTimesHomeState;", "PrayerListItem", "timings", "Lcom/example/domain/Timings;", "index", "", "onSelectItem", "Lkotlin/Function1;", "PrayerNameAndTime", "navigateToDetailScreen", "Lkotlin/Function0;", "PrayerTimesHome", "calculateTheRemaining", "", "scheduleAlarm", "context", "Landroid/content/Context;", "ui-prayerList_debug"})
public final class PrayerTimesHomeKt {
    
    @androidx.compose.runtime.Composable
    public static final void PrayerTimesHome(@org.jetbrains.annotations.NotNull
    com.example.ui_prayerList.ui.PrayerTimesHomeState dataClass, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateToDetailScreen) {
    }
    
    public static final void scheduleAlarm(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PrayerNameAndTime(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.Nullable
    com.example.domain.Timings timings, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateToDetailScreen) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PrayerListItem(@org.jetbrains.annotations.Nullable
    com.example.domain.Timings timings, int index, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onSelectItem) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ImageFade(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.example.ui_prayerList.ui.PrayerTimesHomeState dataClass) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DateAndLocation(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String calculateTheRemaining(@org.jetbrains.annotations.NotNull
    com.example.ui_prayerList.ui.PrayerTimesHomeState dataClass) {
        return null;
    }
}