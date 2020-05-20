package com.imholynx.dynamiciconsexample.presentation.di.components;

import com.imholynx.dynamiciconsexample.presentation.di.PerActivity;
import com.imholynx.dynamiciconsexample.presentation.di.modules.IconModule;
import com.imholynx.dynamiciconsexample.presentation.view.icon.IconFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {IconModule.class})
public interface IconComponent {
    void inject(IconFragment iconFragment);
}
