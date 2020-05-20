package com.imholynx.dynamiciconsexample.presentation.presenter;

import java.lang.ref.WeakReference;

public abstract class Presenter<V> {

    private WeakReference<V> view;

    public V getView() {
        return view.get();
    }

    public void init(V view) {
        this.view = new WeakReference<>(view);
    }

    public void destroy() {
        view.clear();
    }
}
