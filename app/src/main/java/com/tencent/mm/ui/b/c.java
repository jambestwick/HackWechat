package com.tencent.mm.ui.b;

import android.app.Activity;
import android.support.v7.view.i;
import android.view.ActionMode;
import android.view.Window.Callback;

public final class c extends i {
    private Activity mActivity;

    public c(Callback callback, Activity activity) {
        super(callback);
        this.mActivity = activity;
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.mActivity.onWindowStartingActionMode(callback);
    }
}
