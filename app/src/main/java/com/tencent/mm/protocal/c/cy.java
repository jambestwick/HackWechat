package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cy extends a {
    public int vIb;
    public String vIc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vIb);
            if (this.vIc != null) {
                aVar.g(2, this.vIc);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vIb) + 0;
            if (this.vIc != null) {
                return r0 + e.a.a.b.b.a.h(2, this.vIc);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cy cyVar = (cy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyVar.vIb = aVar3.Avy.ry();
                    return 0;
                case 2:
                    cyVar.vIc = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
