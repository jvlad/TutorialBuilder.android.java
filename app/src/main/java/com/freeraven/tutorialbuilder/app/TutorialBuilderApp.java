package com.freeraven.tutorialbuilder.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public class TutorialBuilderApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
