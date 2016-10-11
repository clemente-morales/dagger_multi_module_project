package com.blogspot.cmf.android.dagger.app.models;

import com.blogspot.cmf.android.dagger.core.models.LogHandler;

/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */

public class EmptyLogHandler implements LogHandler {
    @Override
    public void e(String tag, String msg) {

    }

    @Override
    public void e(String tag, String msg, Throwable e) {

    }

    @Override
    public void d(String tag, String msg) {

    }

    @Override
    public void d(String tag, String msg, Throwable e) {

    }

    @Override
    public void v(String tag, String msg) {

    }

    @Override
    public void v(String tag, String msg, Throwable e) {

    }

    @Override
    public void w(String tag, String msg) {

    }

    @Override
    public void w(String tag, String msg, Throwable e) {

    }

    @Override
    public void i(String tag, String msg) {

    }

    @Override
    public void i(String tag, String msg, Throwable e) {

    }
}
