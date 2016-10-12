package com.blogspot.cmf.android.dagger.app.di;

import android.app.Application;

import com.blogspot.cmf.android.dagger.app.models.AndroidLogHandler;
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
public class DebugDependencyModuleApplication extends BaseModuleApplication {
    public DebugDependencyModuleApplication(Application application) {
        super(application);
    }

    @Provides
    @Singleton
    public LogHandler providesLogHandler(){
        return new AndroidLogHandler();
    }

    @Provides
    @Singleton
    public EventBus providesEventBus() {
        return EventBus.builder().throwSubscriberException(true).
                logNoSubscriberMessages(true).sendNoSubscriberEvent(true).
                build();
    }
}
