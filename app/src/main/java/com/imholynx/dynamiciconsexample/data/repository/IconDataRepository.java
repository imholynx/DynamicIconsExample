package com.imholynx.dynamiciconsexample.data.repository;

import com.imholynx.dynamiciconsexample.data.entity.mapper.IconEntityDataMapper;
import com.imholynx.dynamiciconsexample.data.repository.datasource.IconDataStore;
import com.imholynx.dynamiciconsexample.data.repository.datasource.IconDataStoreFactory;
import com.imholynx.dynamiciconsexample.domain.Icon;
import com.imholynx.dynamiciconsexample.domain.repository.IconRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class IconDataRepository implements IconRepository {

    private final IconDataStoreFactory iconDataStoreFactory;
    private final IconEntityDataMapper iconEntityDataMapper;

    @Inject
    public IconDataRepository(IconDataStoreFactory iconDataStoreFactory, IconEntityDataMapper iconEntityDataMapper) {
        this.iconDataStoreFactory = iconDataStoreFactory;
        this.iconEntityDataMapper = iconEntityDataMapper;
    }

    @Override
    public Observable<Icon> item() {
        final IconDataStore iconDataStore = iconDataStoreFactory.create();
        return iconDataStore.iconEntity().map(iconEntityDataMapper::transform);
    }
}
