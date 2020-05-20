package com.imholynx.dynamiciconsexample.data.entity.mapper;

import com.imholynx.dynamiciconsexample.data.entity.IconEntity;
import com.imholynx.dynamiciconsexample.domain.Icon;

import javax.inject.Inject;

public class IconEntityDataMapper {

    @Inject
    IconEntityDataMapper() {
    }

    public Icon transform(IconEntity iconEntity) {

        if (iconEntity == null) {
            return null;
        }

        switch (iconEntity) {
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

    public IconEntity transform(Icon icon) {

        if (icon == null) {
            return null;
        }

        switch (icon) {
            case HOME:
                return IconEntity.HOME;
            case BACK:
                return IconEntity.BACK;
            case SETTINGS:
                return IconEntity.SETTINGS;
            default:
                return null;
        }
    }
}
