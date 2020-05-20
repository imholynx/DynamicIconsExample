package com.imholynx.dynamiciconsexample.presentation.view;

import android.os.Bundle;

import com.imholynx.dynamiciconsexample.R;
import com.imholynx.dynamiciconsexample.presentation.AndroidApplication;
import com.imholynx.dynamiciconsexample.presentation.di.HasComponent;
import com.imholynx.dynamiciconsexample.presentation.di.components.DaggerIconComponent;
import com.imholynx.dynamiciconsexample.presentation.di.components.IconComponent;
import com.imholynx.dynamiciconsexample.presentation.view.base.BaseActivity;
import com.imholynx.dynamiciconsexample.presentation.view.icon.IconFragment;

public class MainActivity extends BaseActivity implements HasComponent<IconComponent> {

    private IconComponent iconComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initDagger();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, IconFragment.newInstance())
                    .commitNow();
        }
    }

    private void initDagger() {
        iconComponent = DaggerIconComponent.builder()
                .applicationComponent(((AndroidApplication) getApplication()).getApplicationComponent())
                .build();
    }

    @Override
    public IconComponent getComponent() {
        return iconComponent;
    }
}
