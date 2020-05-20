package com.imholynx.dynamiciconsexample.presentation.view.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.imholynx.dynamiciconsexample.presentation.AndroidApplication;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AndroidApplication) getApplication()).getApplicationComponent().inject(this);
    }
}
