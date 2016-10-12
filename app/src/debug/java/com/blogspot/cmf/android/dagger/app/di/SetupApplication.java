package com.blogspot.cmf.android.dagger.app.di;

import android.app.Application;
import android.content.Context;


/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */

public class SetupApplication extends Application {
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

    public static ApplicationComponents getObjectGraph(Context context) {
        return ((SetupApplication) context).getObjectGraph();
    }
}
