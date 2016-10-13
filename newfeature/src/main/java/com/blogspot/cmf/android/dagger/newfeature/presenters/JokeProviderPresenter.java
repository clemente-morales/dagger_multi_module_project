package com.blogspot.cmf.android.dagger.newfeature.presenters;

import com.blogspot.cmf.android.dagger.core.presenters.BasePresenter;
import com.blogspot.cmf.android.dagger.newfeature.events.NewJokeFetchedEvent;
import com.blogspot.cmf.android.dagger.newfeature.models.Joke;
import com.blogspot.cmf.android.dagger.newfeature.models.JokeProvider;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public class JokeProviderPresenter extends BasePresenter {

    private final JokeProvider jokeProvider;

    @Inject
    public JokeProviderPresenter(EventBus eventBus, JokeProvider jokeProvider) {
        super(eventBus);
        this.jokeProvider = jokeProvider;
    }

    public void retrieveJoke() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Joke joke = jokeProvider.getRandomJoke();
                eventBus.post(new NewJokeFetchedEvent(joke));
            }
        }).start();
    }
}
