package com.blogspot.cmf.android.dagger.app.di;

import com.blogspot.cmf.android.dagger.core.di.ModuleScope;
import com.blogspot.cmf.android.dagger.newfeature.di.NewFeatureInjector;

import dagger.Subcomponent;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */
@ModuleScope
@Subcomponent(modules = NewFeatureModule.class)
public interface NewFeatureComponents extends NewFeatureInjector {
}
