package com.blogspot.cmf.android.dagger.newfeature.presenters;

import com.blogspot.cmf.android.dagger.core.presenters.BasePresenter;
import com.blogspot.cmf.android.dagger.newfeature.events.NewJokeFetchedEvent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public class JokeProviderPresenter extends BasePresenter {


    @Inject
    protected JokeProviderPresenter(EventBus eventBus) {
        super(eventBus);
    }

    public void retrieveJoke() {
        eventBus.post(new NewJokeFetchedEvent("Jajajajajajajajaja"));
    }
}
