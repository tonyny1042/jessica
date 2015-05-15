package com.player.jessica;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;

/**
 * Created by ggm on 5/12/15.
 */
public class JessicaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "Y1mI8UilGKM4h6Ya1SutbLDnh6khPcoqy3pHvglV", "b4Bib9eqIplpVZDprnzIsaOF7RWuglFQvQoaBCxQ");



    }
}