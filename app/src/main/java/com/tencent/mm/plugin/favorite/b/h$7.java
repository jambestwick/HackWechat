package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.protocal.c.uq;

class h$7 implements Runnable {
    final /* synthetic */ String hVU;
    final /* synthetic */ f mpD;
    final /* synthetic */ uq mpE;
    final /* synthetic */ boolean mrz;

    h$7(boolean z, String str, f fVar, uq uqVar) {
        this.mrz = z;
        this.hVU = str;
        this.mpD = fVar;
        this.mpE = uqVar;
    }

    public final void run() {
        if (this.mrz || h.Al(this.hVU)) {
            j.a(this.mpD, this.mpE, this.mrz);
        }
    }

    public final String toString() {
        return super.toString() + "|reDownload";
    }
}
