package com.imholynx.dynamiciconsexample.presentation.di.components;

import android.content.Context;

import com.imholynx.dynamiciconsexample.domain.repository.IconRepository;
import com.imholynx.dynamiciconsexample.presentation.di.modules.ApplicationModule;
import com.imholynx.dynamiciconsexample.presentation.di.modules.NetworkModule;
import com.imholynx.dynamiciconsexample.presentation.view.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    Context context();

    IconRepository iconRepository();
}
