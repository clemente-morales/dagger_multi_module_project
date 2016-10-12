package com.blogspot.cmf.android.dagger.app.di;

import android.app.Application;
import android.content.Context;


/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */

public class SetupApplication extends Application {
    private ReleaseApplicationComponents releaseApplicationComponents;

    @Override
    public void onCreate() {
        super.onCreate();
        loadGraph();
    }

    public ApplicationComponents getObjectGraph() {
        if (releaseApplicationComponents == null) {
            loadGraph();
        }

        return releaseApplicationComponents;
    }

    private void loadGraph() {
        releaseApplicationComponents = DaggerReleaseApplicationComponents.builder()
                .releaseDependencyModuleApplication(
                        new ReleaseDependencyModuleApplication(this)).build();
    }

    public static ApplicationComponents getObjectGraph(Context context) {
        return ((SetupApplication) context).getObjectGraph();
    }

}
