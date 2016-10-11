package com.blogspot.cmf.android.dagger.app.setup;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */
@Singleton
@Component(modules = {ReleaseDependencyModuleApplication.class})
public interface ReleaseApplicationComponents extends ApplicationComponents {
}
