package com.tencent.mm.plugin.webview.wepkg.model;

class h$11 implements Runnable {
    final /* synthetic */ a tNo;
    final /* synthetic */ WepkgCrossProcessTask tNr;

    h$11(a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.tNo = aVar;
        this.tNr = wepkgCrossProcessTask;
    }

    public final void run() {
        if (this.tNo != null) {
            this.tNo.a(this.tNr);
        }
        this.tNr.afj();
    }
}
