package com.blogspot.cmf.android.dagger.app.views.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.blogspot.cmf.android.dagger.app.R;
import com.blogspot.cmf.android.dagger.app.di.ApplicationComponents;
import com.blogspot.cmf.android.dagger.app.di.SetupApplication;
import com.blogspot.cmf.android.dagger.app.events.ReplaceFragmentEvent;
import com.blogspot.cmf.android.dagger.app.views.fragments.HomeFragment;
import com.blogspot.cmf.android.dagger.core.models.LogHandler;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;


public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Inject
    LogHandler logHandler;

    @Inject
    EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ApplicationComponents applicationComponents = SetupApplication.getObjectGraph(this.getApplication());
        applicationComponents.inject(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new HomeFragment()).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        logHandler.d(TAG, "onResume");

        if (!eventBus.isRegistered(this))
            eventBus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        logHandler.d(TAG, "onPause");
        if (eventBus.isRegistered(this))
            eventBus.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReplaceFragmentEvent(ReplaceFragmentEvent event) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction
                .replace(R.id.fragment_container, event.getFragment());

        if (event.isRequiredToAddInBackStack())
            transaction.addToBackStack(null);

        transaction.commit();
    }

}
