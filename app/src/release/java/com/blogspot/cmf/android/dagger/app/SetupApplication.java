package com.blogspot.cmf.android.dagger.app;

import android.app.Application;
import android.content.Context;

import com.blogspot.cmf.android.dagger.app.di.ReleaseApplicationComponents;
import com.blogspot.cmf.android.dagger.app.di.ReleaseDependencyModuleApplication;


/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */

public class SetupApplication extends Application {
    private ReleaseApplicationComponents releaseApplicationComponents;

    public ApplicationComponents getObjectGraph() {if (releaseApplicationComponents == null) {
        releaseApplicationComponents = DaggerReleaseApplicationComponents.builder()
                .releaseDependencyModuleApplication(
                        new ReleaseDependencyModuleApplication(this)).build();
    }

        return releaseApplicationComponents;
    }

    public static ApplicationComponents getObjectGraph(Context context) {
        return ((SetupApplication) context).getObjectGraph();
    }

}
