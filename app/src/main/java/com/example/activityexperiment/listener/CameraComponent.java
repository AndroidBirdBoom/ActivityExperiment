package com.example.activityexperiment.listener;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

class CameraComponent implements LifecycleObserver {

    public Context mContext;

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void initializeCamera() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void releaseCamera() {

    }
}
