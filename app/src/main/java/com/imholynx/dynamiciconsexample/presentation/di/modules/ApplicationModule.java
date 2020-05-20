package com.imholynx.dynamiciconsexample.presentation.di.modules;

import android.app.Application;
import android.content.Context;

import com.imholynx.dynamiciconsexample.data.repository.IconDataRepository;
import com.imholynx.dynamiciconsexample.domain.repository.IconRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    IconRepository provideIconRepository(IconDataRepository iconDataRepository) {
        return iconDataRepository;
    }
}
