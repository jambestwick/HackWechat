package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class c$16 implements OnClickListener {
    final /* synthetic */ c jgI;

    c$16(c cVar) {
        this.jgI = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "cancel to bind phone number");
        dialogInterface.dismiss();
        this.jgI.jgr.E(this.jgI.jcN, this.jgI.e("fail:cancel to bind phone", null));
        g.pQN.h(14249, new Object[]{this.jgI.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jgI.jgF), Integer.valueOf(this.jgI.jgG), Integer.valueOf(this.jgI.jgE)});
    }
}
