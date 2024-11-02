package com.ekkatech.firebase.chat.activities.fcm;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

import com.ekkatech.firebase.chat.activities.managers.SessionManager;
import com.ekkatech.firebase.chat.activities.managers.Utils;


public class ApplicationLifecycleManager implements ActivityLifecycleCallbacks {


    private static int visibleActivityCount = 0;


    private static int foregroundActivityCount = 0;

    public static boolean isAppInForeground() {
        return foregroundActivityCount > 0;
    }


    public static boolean isAppVisible() {
        return visibleActivityCount > 0;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (SessionManager.get().isRTLOn()) {
            Utils.RTLSupport(activity.getWindow());
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        foregroundActivityCount++;
    }

    public void onActivityPaused(Activity activity) {
        foregroundActivityCount--;
    }


    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    public void onActivityStarted(Activity activity) {
        visibleActivityCount++;
    }

    public void onActivityStopped(Activity activity) {
        visibleActivityCount--;
    }
}