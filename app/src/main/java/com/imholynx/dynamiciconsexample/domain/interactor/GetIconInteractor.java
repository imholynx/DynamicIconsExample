package com.imholynx.dynamiciconsexample.domain.interactor;

import com.imholynx.dynamiciconsexample.domain.Icon;
import com.imholynx.dynamiciconsexample.domain.repository.IconRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetIconInteractor {

    private final IconRepository iconRepository;

    @Inject
    public GetIconInteractor(IconRepository iconRepository) {
        this.iconRepository = iconRepository;
    }

    public Observable<Icon> getItem() {
        return iconRepository.item();
    }
}
