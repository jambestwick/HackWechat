package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class cz extends a {
    public int njA;
    public String njB;
    public String njC;
    public boolean njD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.njC == null) {
                throw new b("Not all required fields were included: MediaURL");
            }
            aVar.fU(1, this.njA);
            if (this.njB != null) {
                aVar.g(2, this.njB);
            }
            if (this.njC != null) {
                aVar.g(3, this.njC);
            }
            aVar.al(4, this.njD);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.njA) + 0;
            if (this.njB != null) {
                r0 += e.a.a.b.b.a.h(2, this.njB);
            }
            if (this.njC != null) {
                r0 += e.a.a.b.b.a.h(3, this.njC);
            }
            return r0 + (e.a.a.b.b.a.dX(4) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.njC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: MediaURL");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cz czVar = (cz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czVar.njA = aVar3.Avy.ry();
                    return 0;
                case 2:
                    czVar.njB = aVar3.Avy.readString();
                    return 0;
                case 3:
                    czVar.njC = aVar3.Avy.readString();
                    return 0;
                case 4:
                    czVar.njD = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
