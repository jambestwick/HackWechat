package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;
import com.tencent.mm.z.q;

final class p implements a {
    private Context context;

    public p(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(R.l.dUU);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.hk((q.Gd() & 8192) == 0);
    }
}
