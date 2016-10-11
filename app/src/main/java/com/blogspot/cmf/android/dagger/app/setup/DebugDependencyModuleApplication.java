package com.blogspot.cmf.android.dagger.app.setup;

import android.app.Application;

import com.blogspot.cmf.android.dagger.app.models.AndroidLogHandler;
import com.blogspot.cmf.android.dagger.core.models.LogHandler;

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
}
