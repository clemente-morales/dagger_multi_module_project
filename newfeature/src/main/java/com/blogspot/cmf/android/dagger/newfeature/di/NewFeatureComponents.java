package com.blogspot.cmf.android.dagger.newfeature.di;

import com.blogspot.cmf.android.dagger.core.di.ApplicationComponents;
import com.blogspot.cmf.android.dagger.newfeature.views.fragments.JokeProviderFragment;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public interface NewFeatureComponents extends ApplicationComponents {
    void inject(JokeProviderFragment jokeProviderFragment);
}
