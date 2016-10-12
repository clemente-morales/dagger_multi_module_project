package com.blogspot.cmf.android.dagger.app.views.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.blogspot.cmf.android.dagger.app.R;
import com.blogspot.cmf.android.dagger.app.di.AppComponents;
import com.blogspot.cmf.android.dagger.app.di.SetupApplication;
import com.blogspot.cmf.android.dagger.app.views.fragments.HomeFragment;
import com.blogspot.cmf.android.dagger.core.commands.ReplaceFragmentCommand;
import com.blogspot.cmf.android.dagger.core.events.ReplaceFragmentEvent;
import com.blogspot.cmf.android.dagger.core.models.DataFragment;
import com.blogspot.cmf.android.dagger.core.models.LogHandler;
import com.blogspot.cmf.android.dagger.core.views.FragmentManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;


public class HomeActivity extends AppCompatActivity implements FragmentManager {

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Inject
    LogHandler logHandler;

    @Inject
    EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AppComponents applicationComponents = SetupApplication.getObjectGraph(this.getApplication());
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
    public void onReplaceFragmentCommand(ReplaceFragmentCommand command) {
        eventBus.removeStickyEvent(command);
        command.execute(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReplaceFragmentEvent(ReplaceFragmentEvent event) {
        eventBus.removeStickyEvent(event);
        replaceCurrentFragment(event.getFragment(), event.isRequiredToAddInBackStack());
    }

    @Override
    public void addFragment(DataFragment dataFragment) {
        replaceCurrentFragment(dataFragment.getFragment(), dataFragment.isRequiresToAddInBackStack());
    }

    private void replaceCurrentFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction
                .replace(R.id.fragment_container, fragment);

        if (addToBackStack)
            transaction.addToBackStack(null);

        transaction.commit();
    }
}
