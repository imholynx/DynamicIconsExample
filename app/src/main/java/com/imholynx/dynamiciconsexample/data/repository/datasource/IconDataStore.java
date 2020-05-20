package com.imholynx.dynamiciconsexample.data.repository.datasource;

import com.imholynx.dynamiciconsexample.data.entity.IconEntity;

import io.reactivex.Observable;

public interface IconDataStore {

    Observable<IconEntity> iconEntity();
}
