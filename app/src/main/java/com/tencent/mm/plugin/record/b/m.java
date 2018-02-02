package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ae.g;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.g.b;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;

public final class m implements a, b, SensorController.a {
    public static SensorController kCP;
    private int fvx;
    public List<a> gxL = new LinkedList();
    private boolean kCS = true;
    private ay kCT;
    long kCU = -1;
    private boolean kCV;
    private boolean kCZ = false;
    public g mql = ((o) com.tencent.mm.kernel.g.h(o.class)).un();
    public String path;

    public m() {
        ar.Hg();
        Boolean bool = (Boolean) c.CU().get(26, Boolean.valueOf(false));
        this.kCV = bool.booleanValue();
        this.kCS = !bool.booleanValue();
        if (this.mql != null) {
            this.mql.a(this);
            this.mql.a(this);
            this.mql.aM(this.kCS);
        } else {
            x.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (kCP == null) {
            kCP = new SensorController(ac.getContext());
        }
        if (this.kCT == null) {
            this.kCT = new ay(ac.getContext());
        }
    }

    public final boolean startPlay(String str, int i) {
        if (this.mql == null) {
            x.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.mql.stop();
        for (a Il : this.gxL) {
            Il.Il(str);
        }
        if (!(kCP == null || kCP.xic)) {
            kCP.a(this);
            if (this.kCT.O(new Runnable(this) {
                final /* synthetic */ m pFz;

                {
                    this.pFz = r1;
                }

                public final void run() {
                    this.pFz.kCU = bh.Wq();
                }
            })) {
                this.kCU = 0;
            } else {
                this.kCU = -1;
            }
        }
        this.path = str;
        this.fvx = i;
        if (bh.ov(str) || !this.mql.a(str, this.kCS, true, i)) {
            return false;
        }
        ae.Vc("keep_app_silent");
        return true;
    }

    public final boolean aIA() {
        if (this.mql != null) {
            return this.mql.isPlaying();
        }
        x.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
        return false;
    }

    public final void stopPlay() {
        x.d("MicroMsg.RecordVoiceHelper", "stop play");
        ae.Vd("keep_app_silent");
        if (this.mql != null) {
            this.mql.stop();
        }
        arT();
    }

    public final void onError() {
        x.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
        for (a onFinish : this.gxL) {
            onFinish.onFinish();
        }
    }

    public final void vh() {
        x.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
        for (a onFinish : this.gxL) {
            onFinish.onFinish();
        }
    }

    public final void arT() {
        if (kCP != null) {
            kCP.cgf();
        }
        if (this.kCT != null) {
            this.kCT.cgg();
        }
    }

    public final void dT(boolean z) {
        boolean z2 = true;
        if (!bh.ov(this.path)) {
            if (this.kCZ) {
                if (z) {
                    z2 = false;
                }
                this.kCZ = z2;
            } else if (z || this.kCU == -1 || bh.bA(this.kCU) <= 400) {
                this.kCZ = false;
                if (this.mql != null && this.mql.vd()) {
                    return;
                }
                if (this.kCV) {
                    if (this.mql != null) {
                        this.mql.aM(false);
                    }
                    this.kCS = false;
                } else if (this.mql == null || this.mql.isPlaying()) {
                    if (this.mql != null) {
                        this.mql.aM(z);
                    }
                    this.kCS = z;
                    if (!z) {
                        startPlay(this.path, this.fvx);
                    }
                } else {
                    this.mql.aM(true);
                    this.kCS = true;
                }
            } else {
                this.kCZ = true;
            }
        }
    }
}
