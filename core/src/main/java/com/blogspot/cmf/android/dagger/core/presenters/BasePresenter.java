package com.blogspot.cmf.android.dagger.core.presenters;

import com.blogspot.cmf.android.dagger.core.events.ReplaceFragmentEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public abstract class BasePresenter {
    protected final EventBus eventBus;

    protected BasePresenter(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void openNextView(ReplaceFragmentEvent replaceFragmentEvent) {
        eventBus.postSticky(replaceFragmentEvent);
    }
}
