# dagger_multi_module_project

This project is an example to configure dagger to split dependencies using debug and release build types.

Also includes how to use dagger to inject dependencies in a multi-module project.

This project is using [subcomponents](https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2 "Dagger subcomponents") to extend the object graph of the application.

## Adding a new module
Here are the steps to add a new module and extend the graph:


1. Add the new module to the project.

2. Add javax inject dependency
    provided "javax.inject:javax.inject:$rootProject.ext.javaxInjectVersion"

3. Create interface in new module to define the injection target.
    ```java
    public interface NewFeatureInjector {
        void inject(JokeProviderFragment jokeProviderFragment);
    }
    ```

4. Create graph provider interface to get access to the graph from the new module
    ```java
    public interface NewFeatureGraphProvider {
        NewFeatureInjector getGraph();
    }
    ```

5. Create Module class to solve the dependencies for the new module.
    ```java
    @Module(
    )
    public class NewFeatureModule {
        private final Application application;

        public NewFeatureModule(Application application) {
            this.application = application;
        }

        @Provides
        @ModuleScope
        public JokeProvider providesJokeProvider() {
            return new InMemoryJokeProvider();
        }
    }
    ```

6. Create subcomponent for the new module
    ```java
    @ModuleScope
    @Subcomponent(modules = NewFeatureModule.class)
    public interface NewFeatureComponents extends NewFeatureInjector {
    }
    ```

7. Make Application implement the new graph provider
    ```java
    public class SetupApplication extends Application implements NewFeatureGraphProvider {

        @Override
        public NewFeatureComponents getGraph() {
            loadGraph();

            return debugApplicationComponents.getNewFeatureComponent(new NewFeatureModule(this));
        }
    }
    ```

8. Inject required depencies in the new module using the graph provider
     ```java
     public class JokeProviderFragment extends BaseFragment {
         @Inject
         JokeProviderPresenter jokeProviderPresenter;

         @Inject
         EventBus eventBus;


         @Override
         public void injectDependencies() {
             NewFeatureInjector newFeatureComponents = geNewFeatureComponents();
             newFeatureComponents.inject(this);
         }

         private NewFeatureInjector geNewFeatureComponents() {
             NewFeatureGraphProvider graphProvider = getObjectGraphProvider();
             return graphProvider.getGraph();
         }

         private NewFeatureGraphProvider getObjectGraphProvider() {
             Context context = getActivity().getApplicationContext();

             if (context instanceof NewFeatureGraphProvider)
                 return (NewFeatureGraphProvider) context;

             throw new UnsupportedOperationException();
         }
     }
     ```