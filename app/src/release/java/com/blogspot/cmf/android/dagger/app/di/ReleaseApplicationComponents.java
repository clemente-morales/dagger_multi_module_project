package com.blogspot.cmf.android.dagger.app.di;

import com.blogspot.cmf.android.dagger.newfeature.di.NewFeatureComponents;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */
@Singleton
@Component(modules = {ReleaseDependencyModuleApplication.class})
public interface ReleaseApplicationComponents extends AppComponents, NewFeatureComponents {
}
