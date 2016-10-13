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
    private DebugApplicationComponents debugApplicationComponents;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        loadGraph();
    }

    public ApplicationComponents getObjectGraph() {
        loadGraph();

        return debugApplicationComponents;
    }

    private void loadGraph() {
        if (debugApplicationComponents == null) {
            debugApplicationComponents = DaggerDebugApplicationComponents.builder()
                    .debugDependencyModuleApplication(
                            new DebugDependencyModuleApplication(this))
                    .build();
        }
    }

    public static AppComponents getObjectGraph(Context context) {
        return (AppComponents) ((GraphProvider) context).getObjectGraph();
    }

    @Override
    public NewFeatureComponents getGraph() {
        loadGraph();

        // This line is creating new Module instance every time we request for the graph in the invokers.
        return debugApplicationComponents.getNewFeatureComponent(new NewFeatureModule(this));
    }
}
