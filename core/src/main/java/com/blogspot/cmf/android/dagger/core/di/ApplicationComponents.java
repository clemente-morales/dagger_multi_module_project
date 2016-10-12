package com.blogspot.cmf.android.dagger.core.di;

import com.blogspot.cmf.android.dagger.core.views.fragments.BaseFragment;

/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */
public interface ApplicationComponents {
    void inject(BaseFragment baseFragment);
}
