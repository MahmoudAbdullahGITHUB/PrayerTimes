package com.example.ui_prayerList.ui;

import com.example.interactors.GetPrayerTimesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PrayerTimeViewModel_Factory implements Factory<PrayerTimeViewModel> {
  private final Provider<GetPrayerTimesUseCase> getPrayerTimesUCProvider;

  public PrayerTimeViewModel_Factory(Provider<GetPrayerTimesUseCase> getPrayerTimesUCProvider) {
    this.getPrayerTimesUCProvider = getPrayerTimesUCProvider;
  }

  @Override
  public PrayerTimeViewModel get() {
    return newInstance(getPrayerTimesUCProvider.get());
  }

  public static PrayerTimeViewModel_Factory create(
      Provider<GetPrayerTimesUseCase> getPrayerTimesUCProvider) {
    return new PrayerTimeViewModel_Factory(getPrayerTimesUCProvider);
  }

  public static PrayerTimeViewModel newInstance(GetPrayerTimesUseCase getPrayerTimesUC) {
    return new PrayerTimeViewModel(getPrayerTimesUC);
  }
}
