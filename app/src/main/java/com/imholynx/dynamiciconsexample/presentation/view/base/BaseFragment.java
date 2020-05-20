package com.imholynx.dynamiciconsexample.presentation.view.base;

import androidx.fragment.app.Fragment;

import com.imholynx.dynamiciconsexample.presentation.di.HasComponent;

public class BaseFragment extends Fragment {

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
