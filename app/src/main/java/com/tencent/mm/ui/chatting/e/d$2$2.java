package com.tencent.mm.ui.chatting.e;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.e.d.2;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class d$2$2 implements p$d {
    final /* synthetic */ b yHe;
    final /* synthetic */ 2 yHt;

    d$2$2(2 2, b bVar) {
        this.yHt = 2;
        this.yHe = bVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        ar.Hg();
        this.yHt.yHr.d(i, c.Fa().dH(this.yHe.fqm));
    }
}
