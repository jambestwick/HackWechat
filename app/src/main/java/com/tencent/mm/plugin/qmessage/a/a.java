package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ay.n;
import com.tencent.mm.g.a.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

final class a extends c<af> {
    a() {
        this.xen = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            x.f("MicroMsg.QMsg.EventListener", "not bind qq event");
        } else if (afVar.fnY.foa == 0) {
            try {
                int Gd = q.Gd() | 32;
                ar.Hg();
                com.tencent.mm.z.c.CU().set(34, Integer.valueOf(Gd));
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new n("", "", "", "", "", "", "", "", Gd, "", ""));
                g.bka();
                x.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.QMsg.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
