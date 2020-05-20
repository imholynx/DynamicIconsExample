package com.imholynx.dynamiciconsexample.presentation.view.icon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;
import com.imholynx.dynamiciconsexample.R;
import com.imholynx.dynamiciconsexample.presentation.di.components.IconComponent;
import com.imholynx.dynamiciconsexample.presentation.model.IconModel;
import com.imholynx.dynamiciconsexample.presentation.presenter.IconPresenter;
import com.imholynx.dynamiciconsexample.presentation.view.IconView;
import com.imholynx.dynamiciconsexample.presentation.view.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IconFragment extends BaseFragment implements IconView {

    @Inject
    IconPresenter iconPresenter;

    @BindView(R.id.icon_iv)
    ImageView icon_iv;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public static IconFragment newInstance() {
        return new IconFragment();
    }

    public IconFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(IconComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.icon_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        iconPresenter.init(this);
    }

    @Override
    public void onDestroy() {
        iconPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void showIcon(IconModel iconModel) {
        icon_iv.setImageDrawable(requireContext().getDrawable(IconHelper.get(iconModel)));
    }

    @Override
    public void showNoDataError() {
        final Snackbar connectionError = Snackbar.make(requireView(), R.string.connection_error,
                Snackbar.LENGTH_INDEFINITE);
        connectionError.setAction(R.string.retry, v -> iconPresenter.onRetry());
        connectionError.show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }
}
