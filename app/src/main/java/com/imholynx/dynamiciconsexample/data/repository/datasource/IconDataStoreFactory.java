package com.imholynx.dynamiciconsexample.data.repository.datasource;

import com.imholynx.dynamiciconsexample.data.api.RestApi;

import javax.inject.Inject;

public class IconDataStoreFactory {

    private final RestApi restApi;

    @Inject
    public IconDataStoreFactory(RestApi restApi) {
        this.restApi = restApi;
    }

    public IconDataStore create() {
        return new RemoteIconDataStore(restApi);
    }
}
