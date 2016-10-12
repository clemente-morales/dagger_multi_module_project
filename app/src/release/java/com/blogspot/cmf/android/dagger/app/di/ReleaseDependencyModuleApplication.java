package com.blogspot.cmf.android.dagger.app.di;

import android.app.Application;

import com.blogspot.cmf.android.dagger.app.models.EmptyLogHandler;
import com.blogspot.cmf.android.dagger.core.models.LogHandler;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */
@Module
public class ReleaseDependencyModuleApplication extends BaseModuleApplication {

    public ReleaseDependencyModuleApplication(Application application) {
        super(application);
    }

    @Provides
    @Singleton
    public LogHandler providesLogHandler() {
        return new EmptyLogHandler();
    }

    @Provides
    @Singleton
    public EventBus providesEventBus() {
        return EventBus.builder().
                logNoSubscriberMessages(true).sendNoSubscriberEvent(true).
                build();
    }
}
