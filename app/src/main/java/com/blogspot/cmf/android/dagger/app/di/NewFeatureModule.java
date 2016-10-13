package com.blogspot.cmf.android.dagger.app.di;

import android.app.Application;

import com.blogspot.cmf.android.dagger.core.di.ModuleScope;
import com.blogspot.cmf.android.dagger.newfeature.models.InMemoryJokeProvider;
import com.blogspot.cmf.android.dagger.newfeature.models.JokeProvider;

import dagger.Module;
import dagger.Provides;

/**
 * @author Clemente Morales Fernandez
 * @since 10/13/2016.
 */
@Module(
)
public class NewFeatureModule {
    private final Application application;

    public NewFeatureModule(Application application) {
        this.application = application;
    }

    @Provides
    @ModuleScope
    public JokeProvider providesJokeProvider() {
        return new InMemoryJokeProvider();
    }
}
