package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactSearchUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ ContactSearchUI rYw;

    ContactSearchUI$4(ContactSearchUI contactSearchUI) {
        this.rYw = contactSearchUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rYw.aWs();
        this.rYw.finish();
        return true;
    }
}
