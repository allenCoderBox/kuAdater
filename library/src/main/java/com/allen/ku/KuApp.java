package com.allen.ku;

import android.app.Application;

/**
 * Created by husongzhen on 17/10/19.
 */

public class KuApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdaptiveHelper.init(this);
    }
}
