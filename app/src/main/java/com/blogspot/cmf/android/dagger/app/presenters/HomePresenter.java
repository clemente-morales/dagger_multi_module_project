package com.blogspot.cmf.android.dagger.app.presenters;

import com.blogspot.cmf.android.dagger.core.presenters.BasePresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author Clemente Morales Fernandez
 * @since 10/12/2016.
 */

public class HomePresenter extends BasePresenter {
    @Inject
    public HomePresenter(EventBus eventBus) {
        super(eventBus);
    }
}
