package com.blogspot.cmf.android.dagger.newfeature.views.fragments;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.cmf.android.dagger.core.di.GraphProvider;
import com.blogspot.cmf.android.dagger.core.views.fragments.BaseFragment;
import com.blogspot.cmf.android.dagger.newfeature.R;
import com.blogspot.cmf.android.dagger.newfeature.di.NewFeatureComponents;
import com.blogspot.cmf.android.dagger.newfeature.events.NewJokeFetchedEvent;
import com.blogspot.cmf.android.dagger.newfeature.presenters.JokeProviderPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public class JokeProviderFragment extends BaseFragment {
    @Inject
    JokeProviderPresenter jokeProviderPresenter;

    @Inject
    EventBus eventBus;

    private TextView jokeDescription;

    @Override
    protected int getLayout() {
        return R.layout.fragment_joke_provider;
    }

    @Override
    public void injectDependencies() {
        NewFeatureComponents newFeatureComponents = geNewFeatureComponents();
        newFeatureComponents.inject(this);
    }

    @Override
    protected void initFragment(View rootView) {
        jokeDescription = (TextView) rootView.findViewById(R.id.jokeDescriptionTextView);

        Button openJokesModule = (Button) rootView.findViewById(R.id.getJokeButton);
        openJokesModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jokeProviderPresenter.retrieveJoke();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!eventBus.isRegistered(this))
            eventBus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        if (eventBus.isRegistered(this))
            eventBus.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewJokeFetchedEvent(NewJokeFetchedEvent event) {
        jokeDescription.setText(event.getJoke());
    }

    public GraphProvider getGraphProvider() {
        Context context = getActivity().getApplicationContext();

        if (context instanceof GraphProvider)
            return (GraphProvider) context;

        throw new UnsupportedOperationException();
    }

    private NewFeatureComponents geNewFeatureComponents() {
        GraphProvider graphProvider = getGraphProvider();
        return (NewFeatureComponents) graphProvider.getObjectGraph();
    }


}
