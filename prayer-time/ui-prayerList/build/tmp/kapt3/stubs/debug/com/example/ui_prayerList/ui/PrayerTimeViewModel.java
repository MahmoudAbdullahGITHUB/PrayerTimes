package com.example.ui_prayerList.ui;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/example/ui_prayerList/ui/PrayerTimeViewModel;", "Landroidx/lifecycle/ViewModel;", "getPrayerTimesUC", "Lcom/example/interactors/GetPrayerTimesUseCase;", "(Lcom/example/interactors/GetPrayerTimesUseCase;)V", "logger", "Lcom/example/core/Logger;", "getLogger", "()Lcom/example/core/Logger;", "state", "Landroidx/compose/runtime/MutableState;", "Lcom/example/ui_prayerList/ui/PrayerTimesHomeState;", "getState", "()Landroidx/compose/runtime/MutableState;", "getPrayerTimes", "", "onTriggerEvents", "event", "Lcom/example/ui_prayerList/ui/PrayerTimeEvents;", "ui-prayerList_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PrayerTimeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.interactors.GetPrayerTimesUseCase getPrayerTimesUC = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.core.Logger logger = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<com.example.ui_prayerList.ui.PrayerTimesHomeState> state = null;
    
    @javax.inject.Inject
    public PrayerTimeViewModel(@org.jetbrains.annotations.NotNull
    com.example.interactors.GetPrayerTimesUseCase getPrayerTimesUC) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.core.Logger getLogger() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<com.example.ui_prayerList.ui.PrayerTimesHomeState> getState() {
        return null;
    }
    
    public final void onTriggerEvents(@org.jetbrains.annotations.NotNull
    com.example.ui_prayerList.ui.PrayerTimeEvents event) {
    }
    
    public final void getPrayerTimes() {
    }
}