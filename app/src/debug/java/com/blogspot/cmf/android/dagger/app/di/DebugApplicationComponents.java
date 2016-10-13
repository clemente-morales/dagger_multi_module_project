package com.blogspot.cmf.android.dagger.app.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */
@Singleton
@Component(modules = {DebugDependencyModuleApplication.class})
public interface DebugApplicationComponents extends AppComponents {
}
