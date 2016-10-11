package com.blogspot.cmf.android.dagger.app.models;

import android.util.Log;

import com.blogspot.cmf.android.dagger.core.models.LogHandler;

/**
 * @author Clemente Morales Fernandez
 * @since 10/11/2016.
 */

public class AndroidLogHandler implements LogHandler {
    @Override
    public void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    @Override
    public void e(String tag, String msg, Throwable e) {
        Log.e(tag, msg, e);
    }

    @Override
    public void d(String tag, String msg) {
        if (msg == null) return;

        Log.d(tag, msg);
    }

    @Override
    public void d(String tag, String msg, Throwable e) {
        Log.d(tag, msg, e);
    }

    @Override
    public void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    @Override
    public void v(String tag, String msg, Throwable e) {
        Log.v(tag, msg, e);
    }

    @Override
    public void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    @Override
    public void w(String tag, String msg, Throwable e) {
        Log.w(tag, msg, e);
    }

    @Override
    public void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    @Override
    public void i(String tag, String msg, Throwable e) {
        Log.i(tag, msg, e);
    }
}
