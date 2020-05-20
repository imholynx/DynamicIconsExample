package com.imholynx.dynamiciconsexample.presentation.view.icon;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.imholynx.dynamiciconsexample.R;
import com.imholynx.dynamiciconsexample.presentation.model.IconModel;

public final class IconHelper {

    @DrawableRes
    public static int get(@NonNull IconModel iconModel) {
        switch (iconModel) {
            case HOME:
                return R.drawable.ic_home_black_24dp;
            case BACK:
                return R.drawable.ic_arrow_back_black_24dp;
            case SETTINGS:
                return R.drawable.ic_settings_black_24dp;
            default:
                return 0;
        }
    }

    private IconHelper() {
        throw new AssertionError("No instances.");
    }
}
