package com.blogspot.cmf.android.dagger.newfeature.events;

import com.blogspot.cmf.android.dagger.newfeature.models.Joke;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public class NewJokeFetchedEvent {
    private final Joke joke;

    public NewJokeFetchedEvent(Joke joke) {
        this.joke = joke;
    }

    public Joke getJoke() {
        return joke;
    }
}
