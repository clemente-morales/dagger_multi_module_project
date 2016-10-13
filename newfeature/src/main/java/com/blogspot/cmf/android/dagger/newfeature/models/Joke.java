package com.blogspot.cmf.android.dagger.newfeature.models;

/**
 * @author Clemente Morales Fernandez
 * @since 10/13/2016.
 */

public class Joke {
    private final String category;
    private final String description;

    public Joke(String category, String description) {
        this.category = category;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}
