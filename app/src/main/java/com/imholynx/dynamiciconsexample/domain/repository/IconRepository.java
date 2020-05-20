package com.imholynx.dynamiciconsexample.domain.repository;

import com.imholynx.dynamiciconsexample.domain.Icon;

import io.reactivex.Observable;

public interface IconRepository {

    Observable<Icon> item();
}
