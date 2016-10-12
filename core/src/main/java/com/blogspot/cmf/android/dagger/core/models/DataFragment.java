package com.blogspot.cmf.android.dagger.core.models;

import android.support.v4.app.Fragment;

/**
 * @author Clemente Morales Fernandez
 * @since 10/7/2016.
 */

public class DataFragment {
    private final String tag;
    private final Fragment fragment;
    private boolean requiresToAddInBackStack = false;

    public DataFragment(String tag, Fragment fragment) {
        this.tag = tag;
        this.fragment = fragment;
    }

    public String getTag() {
        return tag;
    }

    public boolean isRequiresToAddInBackStack() {
        return requiresToAddInBackStack;
    }

    public void setRequiresToAddInBackStack(boolean requiresToAddInBackStack) {
        this.requiresToAddInBackStack = requiresToAddInBackStack;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
