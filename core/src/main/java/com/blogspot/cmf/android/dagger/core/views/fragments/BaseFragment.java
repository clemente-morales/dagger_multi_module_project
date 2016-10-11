package com.blogspot.cmf.android.dagger.core.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by mallakr on 1/4/2016.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        loadFragmentArguments();
        initFragmentCreation(savedInstanceState);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater,
                                   @Nullable ViewGroup container,
                                   @Nullable Bundle savedInstanceState) {

        View rootView = buildRootView(inflater, container);
        initFragment(rootView);
        return rootView;
    }

    protected View buildRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(getLayout(), container, false);
    }

    protected void initFragmentCreation(Bundle savedInstanceState) {
    }

    protected void loadFragmentArguments() {

    }

    protected void initFragment(View rootView) {

    }

    protected abstract int getLayout();

    public void injectDependencies() {
    }
}
