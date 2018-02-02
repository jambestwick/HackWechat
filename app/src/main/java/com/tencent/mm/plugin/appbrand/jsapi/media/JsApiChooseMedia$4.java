package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class JsApiChooseMedia$4 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ JsApiChooseMedia jmY;

    JsApiChooseMedia$4(JsApiChooseMedia jsApiChooseMedia, j jVar, JSONObject jSONObject, int i) {
        this.jmY = jsApiChooseMedia;
        this.iZy = jVar;
        this.jel = jSONObject;
        this.gOK = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 119) {
            x.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
        } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            x.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
            this.iZy.E(this.gOK, this.jmY.e("fail:system permission denied", null));
        } else {
            x.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
            this.jmY.a(this.iZy, this.jel, this.gOK);
        }
    }
}
