package com.blogspot.cmf.android.dagger.newfeature.models;

/**
 * @author Clemente Morales Fernandez
 * @since 10/13/2016.
 */

public interface JokeProvider {
    Joke getRandomJoke();
    Joke getJoke(String category);
}
