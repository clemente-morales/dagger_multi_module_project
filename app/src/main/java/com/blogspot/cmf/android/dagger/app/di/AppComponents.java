package com.blogspot.cmf.android.dagger.app.di;

import com.blogspot.cmf.android.dagger.app.views.activities.HomeActivity;
import com.blogspot.cmf.android.dagger.app.views.fragments.HomeFragment;
import com.blogspot.cmf.android.dagger.core.di.ApplicationComponents;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public interface AppComponents extends ApplicationComponents {
    void inject(HomeActivity homeActivity);
    void inject(HomeFragment homeFragment);

    NewFeatureComponents getNewFeatureComponent(NewFeatureModule newFeatureModule);
}
