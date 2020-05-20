package com.imholynx.dynamiciconsexample.data.repository.datasource;

import com.imholynx.dynamiciconsexample.data.entity.IconEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class FakeIconDataStore implements IconDataStore {

    @Override
    public Observable<IconEntity> iconEntity() {
        return Observable.just(randomIconEntity())
                .delay(3, TimeUnit.SECONDS);
    }

    private IconEntity randomIconEntity() {
        final Random random = new Random();
        final List<IconEntity> iconEntities = Arrays.asList(IconEntity.values());
        return iconEntities.get(random.nextInt(iconEntities.size()));
    }
}
