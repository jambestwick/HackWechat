package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class ga extends a {
    public String vLs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLs == null) {
                throw new b("Not all required fields were included: Mac");
            } else if (this.vLs == null) {
                return 0;
            } else {
                aVar.g(1, this.vLs);
                return 0;
            }
        } else if (i == 1) {
            if (this.vLs != null) {
                r0 = e.a.a.b.b.a.h(1, this.vLs) + 0;
            } else {
                r0 = 0;
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vLs != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Mac");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ga gaVar = (ga) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gaVar.vLs = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
