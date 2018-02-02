package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;

public final class c implements i {
    private static final String kLD = (e.bnF + "wallet");
    private String url;

    public c(String str) {
        this.url = str;
    }

    public final b We() {
        return null;
    }

    public final String Wf() {
        return Hu(this.url);
    }

    public final String Wg() {
        return this.url;
    }

    public final String Wh() {
        return this.url;
    }

    public final String Wi() {
        return this.url;
    }

    public final boolean Wj() {
        return true;
    }

    public final boolean Wk() {
        return false;
    }

    public final Bitmap Wl() {
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.ice == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Hu(this.url), false);
            } catch (IOException e) {
                try {
                    File file = new File(kLD);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    x.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                    d.a(bitmap, 100, CompressFormat.PNG, Hu(this.url), false);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
                    x.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                }
            }
        }
        x.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[]{aVar.toString()});
        return bitmap;
    }

    public final void Wm() {
    }

    public final void N(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public static String Hu(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{kLD, g.s(str.getBytes())});
    }
}
