package com.example.ui_prayerList.di;

import com.example.interactors.GetPrayerTimesUseCase;
import com.example.interactors.PrayerInteractors;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class prayerListModule_ProvideUseCaseFactory implements Factory<GetPrayerTimesUseCase> {
  private final Provider<PrayerInteractors> interactorsProvider;

  public prayerListModule_ProvideUseCaseFactory(Provider<PrayerInteractors> interactorsProvider) {
    this.interactorsProvider = interactorsProvider;
  }

  @Override
  public GetPrayerTimesUseCase get() {
    return provideUseCase(interactorsProvider.get());
  }

  public static prayerListModule_ProvideUseCaseFactory create(
      Provider<PrayerInteractors> interactorsProvider) {
    return new prayerListModule_ProvideUseCaseFactory(interactorsProvider);
  }

  public static GetPrayerTimesUseCase provideUseCase(PrayerInteractors interactors) {
    return Preconditions.checkNotNullFromProvides(prayerListModule.INSTANCE.provideUseCase(interactors));
  }
}
