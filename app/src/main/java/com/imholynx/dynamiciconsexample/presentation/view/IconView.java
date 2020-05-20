package com.imholynx.dynamiciconsexample.presentation.view;

import com.imholynx.dynamiciconsexample.presentation.model.IconModel;

public interface IconView {
    void showIcon(IconModel icon);
    void showNoDataError();
    void showLoading();
    void hideLoading();
}
