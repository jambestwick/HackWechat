package com.tencent.mm.compatible.b;

import android.media.AudioTrack;

public final class d extends AudioTrack {
    public d(int i, int i2, int i3, int i4, int i5) {
        super(i, i2, i3, 2, i5, 1);
        f.fA(hashCode());
    }

    public final void release() {
        super.release();
        f.fB(hashCode());
    }
}
