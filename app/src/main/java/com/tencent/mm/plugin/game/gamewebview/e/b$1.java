package com.tencent.mm.plugin.game.gamewebview.e;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements ValueCallback<String> {
    final /* synthetic */ b naI;

    b$1(b bVar) {
        this.naI = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.GameWebView", "injectJavaScript, ret = %s", (String) obj);
        if (bh.ov((String) obj)) {
            g.pQN.a(609, 2, 1, false);
        } else {
            g.pQN.a(609, 3, 1, false);
        }
    }
}
