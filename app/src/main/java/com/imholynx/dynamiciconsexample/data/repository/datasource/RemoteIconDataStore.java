package com.imholynx.dynamiciconsexample.data.repository.datasource;

import com.imholynx.dynamiciconsexample.data.api.RestApi;
import com.imholynx.dynamiciconsexample.data.entity.IconEntity;
import com.imholynx.dynamiciconsexample.data.entity.IconResponse;

import io.reactivex.Observable;

public class RemoteIconDataStore implements IconDataStore {

    private final RestApi restApi;

    public RemoteIconDataStore(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<IconEntity> iconEntity() {
        return restApi.getIcon().map(IconResponse::getIconEntity);
    }
}
