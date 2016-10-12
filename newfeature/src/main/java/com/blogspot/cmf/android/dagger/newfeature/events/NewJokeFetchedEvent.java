package com.blogspot.cmf.android.dagger.newfeature.events;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public class NewJokeFetchedEvent {
    private final String joke;

    public NewJokeFetchedEvent(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }
}
