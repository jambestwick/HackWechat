package com.tencent.mm.bm;

import com.tencent.mm.sdk.platformtools.x;

class d$3 implements b {
    final /* synthetic */ String vzO;

    d$3(String str) {
        this.vzO = str;
    }

    public final void c(Exception exception) {
        x.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", this.vzO);
        x.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
    }
}
