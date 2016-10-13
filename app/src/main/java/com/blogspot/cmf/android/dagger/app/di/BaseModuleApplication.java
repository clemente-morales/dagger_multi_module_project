package com.blogspot.cmf.android.dagger.app.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */
@Module
public abstract class BaseModuleApplication {
    private final Application application;

    public BaseModuleApplication(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public final SharedPreferences providesSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
