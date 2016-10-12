package com.blogspot.cmf.android.dagger.app.di;

import android.app.Application;
import android.content.Context;

import com.blogspot.cmf.android.dagger.core.di.ApplicationComponents;
import com.blogspot.cmf.android.dagger.core.di.GraphProvider;


/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */

public class SetupApplication extends Application implements GraphProvider {
    private DebugApplicationComponents debugApplicationComponents;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        loadGraph();
    }

    public ApplicationComponents getObjectGraph() {
        if (debugApplicationComponents == null) {
            loadGraph();
        }

        return debugApplicationComponents;
    }

    private void loadGraph() {
        debugApplicationComponents = DaggerDebugApplicationComponents.builder()
                .debugDependencyModuleApplication(
                        new DebugDependencyModuleApplication(this)).build();
    }

    public static AppComponents getObjectGraph(Context context) {
        return (AppComponents) ((GraphProvider) context).getObjectGraph();
    }
}
