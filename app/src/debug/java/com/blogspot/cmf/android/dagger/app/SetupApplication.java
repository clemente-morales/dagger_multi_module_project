package com.blogspot.cmf.android.dagger.app;

import android.app.Application;
import android.content.Context;

import com.blogspot.cmf.android.dagger.app.di.DaggerDebugApplicationComponents;
import com.blogspot.cmf.android.dagger.app.di.DebugApplicationComponents;
import com.blogspot.cmf.android.dagger.app.di.DebugDependencyModuleApplication;


/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */

public class SetupApplication extends Application {
    private DebugApplicationComponents debugApplicationComponents;

    public ApplicationComponents getObjectGraph() {
        if (debugApplicationComponents == null) {
            debugApplicationComponents = DaggerDebugApplicationComponents.builder()
                    .debugDependencyModuleApplication(
                            new DebugDependencyModuleApplication(this)).build();
        }

        return debugApplicationComponents;
    }

    public static ApplicationComponents getObjectGraph(Context context) {
        return ((SetupApplication) context).getObjectGraph();
    }
}
