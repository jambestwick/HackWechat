package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static final int mfE = 1;
    private static final /* synthetic */ int[] mfF = new int[]{mfE};

    public static a a(Context context, e eVar, int i, Bundle bundle) {
        x.i("MicroMsg.FaceDetectControllerFactory", "alvinluo getController serverScene: %d", Integer.valueOf(i));
        switch (i) {
            case 0:
            case 1:
            case 3:
            case 4:
                return new c(context, eVar, i);
            case 2:
            case 5:
                return new d(context, eVar, i, bundle);
            default:
                return null;
        }
    }
}
