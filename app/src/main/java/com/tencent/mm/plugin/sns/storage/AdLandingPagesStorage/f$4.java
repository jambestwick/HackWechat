package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$4 implements a {
    final /* synthetic */ p rof;
    final /* synthetic */ f rog;

    f$4(f fVar, p pVar) {
        this.rog = fVar;
        this.rof = pVar;
    }

    public final void bxc() {
    }

    public final void bxd() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.rof.rgz + "is error");
        f.a(this.rog, this.rof.rgz);
    }

    public final void KY(String str) {
        f.a(this.rog, this.rof.rgz);
    }
}
