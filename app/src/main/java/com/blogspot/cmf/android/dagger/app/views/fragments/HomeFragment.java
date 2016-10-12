package com.blogspot.cmf.android.dagger.app.views.fragments;

import android.view.View;
import android.widget.Button;

import com.blogspot.cmf.android.dagger.app.R;
import com.blogspot.cmf.android.dagger.app.di.AppComponents;
import com.blogspot.cmf.android.dagger.app.presenters.HomePresenter;
import com.blogspot.cmf.android.dagger.core.di.GraphProvider;
import com.blogspot.cmf.android.dagger.core.events.ReplaceFragmentEvent;
import com.blogspot.cmf.android.dagger.core.views.fragments.BaseFragment;
import com.blogspot.cmf.android.dagger.newfeature.views.fragments.JokeProviderFragment;

import javax.inject.Inject;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public class HomeFragment extends BaseFragment {
    @Inject
    HomePresenter homePresenter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void injectDependencies() {
        getAppComponents().inject(this);
    }

    @Override
    protected void initFragment(View rootView) {
        Button openJokesModule = (Button) rootView.findViewById(R.id.openJokesModuleButton);
        openJokesModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePresenter.openNextView(new ReplaceFragmentEvent(new JokeProviderFragment(), false));
            }
        });
    }

    private AppComponents getAppComponents() {
        GraphProvider graphProvider = getGraphProvider();
        return (AppComponents) graphProvider.getObjectGraph();
    }
}
