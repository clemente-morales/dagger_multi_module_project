package com.vzw.mobilefirst.core.models;

/**
 * Created by mallakr on 12/21/2015.
 */
public interface LogHandler {
    void e(String tag, String msg);
    void e(String tag, String msg, Throwable e);
    void d(String tag, String msg);
    void d(String tag, String msg, Throwable e);
    void v(String tag, String msg);
    void v(String tag, String msg, Throwable e);
    void w(String tag, String msg);
    void w(String tag, String msg, Throwable e);
    void i(String tag, String msg);
    void i(String tag, String msg, Throwable e);
}
