package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static int rSk = -1;
    private static int rSl = -1;

    public static void xZ(int i) {
        rSk = i;
    }

    public static void bCL() {
        if (rSk == -1) {
            x.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        g.pQN.h(12925, new Object[]{Integer.valueOf(rSk)});
    }

    public static void bCM() {
        if (rSk == -1) {
            x.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        g.pQN.h(12926, new Object[]{Integer.valueOf(rSk)});
    }

    public static void c(int i, int i2, int i3, String str) {
        if (rSk == -1) {
            x.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        g.pQN.h(13413, new Object[]{Integer.valueOf(rSk), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
    }

    public static void bCN() {
        rSl = (int) (System.currentTimeMillis() / 1000);
    }

    public static void ya(int i) {
        if (rSl == -1) {
            x.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            return;
        }
        g.pQN.h(12927, new Object[]{Integer.valueOf(rSl), Integer.valueOf(i)});
        rSk = -1;
    }

    public static boolean bCO() {
        return rSk >= 0;
    }

    public static void dL(int i, int i2) {
        x.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        g.pQN.h(14381, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void dM(int i, int i2) {
        int i3;
        switch (i2) {
            case 4:
                i3 = 1;
                break;
            case 5:
                i3 = 3;
                break;
            case 9:
                i3 = 2;
                break;
            case 10:
                i3 = 4;
                break;
            case 26:
                if (i != 3) {
                    i3 = -1;
                    break;
                } else {
                    i3 = 0;
                    break;
                }
            case 1001:
                i3 = 5;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            x.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[]{Integer.valueOf(672), Integer.valueOf(i3), Long.valueOf(1)});
            g.pQN.a(672, (long) i3, 1, false);
        }
    }

    public static void yb(int i) {
        x.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[]{Integer.valueOf(3), Integer.valueOf(i), bh.i(new Throwable())});
        Map hashMap = new HashMap();
        hashMap.put("sceneType", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        hashMap.put("scene", String.valueOf(i));
        g.pQN.c("Soter", "Fingerprint pay add authentication task failed: " + r0, hashMap);
    }
}
