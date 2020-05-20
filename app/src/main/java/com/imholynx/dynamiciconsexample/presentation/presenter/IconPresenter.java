package com.imholynx.dynamiciconsexample.presentation.presenter;

import com.imholynx.dynamiciconsexample.domain.interactor.GetIconInteractor;
import com.imholynx.dynamiciconsexample.presentation.di.PerActivity;
import com.imholynx.dynamiciconsexample.presentation.mapper.IconModelDataMapper;
import com.imholynx.dynamiciconsexample.presentation.view.IconView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@PerActivity
public class IconPresenter extends Presenter<IconView> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private final GetIconInteractor getIconInteractor;
    private final IconModelDataMapper iconModelDataMapper;

    @Inject
    public IconPresenter(GetIconInteractor getIconInteractor,
                         IconModelDataMapper iconModelDataMapper) {
        this.getIconInteractor = getIconInteractor;
        this.iconModelDataMapper = iconModelDataMapper;
    }

    @Override
    public void init(IconView view) {
        super.init(view);
        loadData();
    }

    public void onRetry(){
        loadData();
    }

    private void loadData() {
        compositeDisposable.clear();
        compositeDisposable.add(getIconInteractor.getItem()
                .map(iconModelDataMapper::transform)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> getView().showLoading())
                .doFinally(() -> getView().hideLoading())
                .subscribe(icon -> getView().showIcon(icon),
                        throwable -> getView().showNoDataError()));
    }

    @Override
    public void destroy() {
        compositeDisposable.clear();
        super.destroy();
    }
}
