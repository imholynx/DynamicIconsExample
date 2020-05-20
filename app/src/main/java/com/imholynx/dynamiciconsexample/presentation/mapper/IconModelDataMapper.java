package com.imholynx.dynamiciconsexample.presentation.mapper;

import com.imholynx.dynamiciconsexample.domain.Icon;
import com.imholynx.dynamiciconsexample.presentation.model.IconModel;

import javax.inject.Inject;

public class IconModelDataMapper {

    @Inject
    public IconModelDataMapper() {
    }

    public Icon transform(IconModel iconModel) {

        if (iconModel == null) {
            return null;
        }

        switch (iconModel) {
            case HOME:
                return Icon.HOME;
            case BACK:
                return Icon.BACK;
            case SETTINGS:
                return Icon.SETTINGS;
            default:
                return null;
        }
    }

    public IconModel transform(Icon icon) {

        if (icon == null) {
            return null;
        }

        switch (icon) {
            case HOME:
                return IconModel.HOME;
            case BACK:
                return IconModel.BACK;
            case SETTINGS:
                return IconModel.SETTINGS;
            default:
                return null;
        }
    }
}
