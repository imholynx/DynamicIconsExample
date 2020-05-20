package com.imholynx.dynamiciconsexample.data.entity;

import com.google.gson.annotations.SerializedName;

public class IconResponse {

    @SerializedName("icon")
    private IconEntity iconEntity;

    public IconEntity getIconEntity() {
        return iconEntity;
    }
}
