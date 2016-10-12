package com.blogspot.cmf.android.dagger.core.events;

import android.support.v4.app.Fragment;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public class ReplaceFragmentEvent {
    private final Fragment fragment;
    private final boolean requiredToAddInBackStack;

    public ReplaceFragmentEvent(Fragment fragment, boolean requiredToAddInBackStack) {
        this.fragment = fragment;
        this.requiredToAddInBackStack = requiredToAddInBackStack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public boolean isRequiredToAddInBackStack() {
        return requiredToAddInBackStack;
    }
}
