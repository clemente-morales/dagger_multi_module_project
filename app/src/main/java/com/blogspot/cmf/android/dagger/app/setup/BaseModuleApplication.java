package com.blogspot.cmf.android.dagger.app.setup;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */
@Module(
)
public abstract class BaseModuleApplication {
    private final Application application;

    public BaseModuleApplication(Application application) {
        this.application = application;
    }

    @Provides
    public final Context providesApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    public final SharedPreferences providesSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    public EventBus providesEventBus() {
        return de.greenrobot.event.EventBus.builder().
                logNoSubscriberMessages(true).sendNoSubscriberEvent(true).
                build();
    }
}
