package com.blogspot.cmf.android.dagger.app.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blogspot.cmf.android.dagger.app.R;
import com.blogspot.cmf.android.dagger.app.di.ApplicationComponents;
import com.blogspot.cmf.android.dagger.app.di.SetupApplication;
import com.blogspot.cmf.android.dagger.core.models.LogHandler;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Inject
    LogHandler logHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ApplicationComponents applicationComponents = SetupApplication.getObjectGraph(this.getApplication());
        applicationComponents.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        logHandler.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logHandler.d(TAG, "onPause");
    }
}
