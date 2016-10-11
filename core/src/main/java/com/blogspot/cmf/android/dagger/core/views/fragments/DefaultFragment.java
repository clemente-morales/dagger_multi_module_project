package com.blogspot.cmf.android.dagger.core.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.blogspot.cmf.android.dagger.core.R;


/**
 * Created by clerks on 1/15/16.
 */
public class DefaultFragment extends BaseFragment {
    private static final String TAG = DefaultFragment.class.getSimpleName();

    public static DefaultFragment newInstance() {

        Bundle args = new Bundle();

        DefaultFragment fragment = new DefaultFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.default_fragment;
    }
}

