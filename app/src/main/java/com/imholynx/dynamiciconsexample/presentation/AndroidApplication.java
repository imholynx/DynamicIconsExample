package com.imholynx.dynamiciconsexample.presentation;

import android.app.Application;

import com.imholynx.dynamiciconsexample.BuildConfig;
import com.imholynx.dynamiciconsexample.presentation.di.components.ApplicationComponent;
import com.imholynx.dynamiciconsexample.presentation.di.components.DaggerApplicationComponent;
import com.imholynx.dynamiciconsexample.presentation.di.modules.ApplicationModule;
import com.imholynx.dynamiciconsexample.presentation.di.modules.NetworkModule;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(BuildConfig.BASE_URL))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
