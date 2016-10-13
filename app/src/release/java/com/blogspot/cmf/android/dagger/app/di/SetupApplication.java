package com.blogspot.cmf.android.dagger.app.di;

import android.app.Application;
import android.content.Context;

import com.blogspot.cmf.android.dagger.core.di.ApplicationComponents;
import com.blogspot.cmf.android.dagger.core.di.GraphProvider;
import com.blogspot.cmf.android.dagger.newfeature.di.NewFeatureGraphProvider;


/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */

public class SetupApplication extends Application implements GraphProvider, NewFeatureGraphProvider {
    private ReleaseApplicationComponents releaseApplicationComponents;

    @Override
    public void onCreate() {
        super.onCreate();
        loadGraph();
    }

    public ApplicationComponents getObjectGraph() {
        loadGraph();

        return releaseApplicationComponents;
    }

    private void loadGraph() {
        if (releaseApplicationComponents == null) {
            releaseApplicationComponents = DaggerReleaseApplicationComponents.builder()
                    .releaseDependencyModuleApplication(
                            new ReleaseDependencyModuleApplication(this)).build();
        }
    }

    public static AppComponents getObjectGraph(Context context) {
        return (AppComponents) ((GraphProvider) context).getObjectGraph();
    }

    @Override
    public NewFeatureComponents getGraph() {
        loadGraph();

        // This line is creating new Module instance every time we request for the graph in the invokers.
        return releaseApplicationComponents.getNewFeatureComponent(new NewFeatureModule(this));
    }

}
