package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bvp extends a {
    public String wWW;
    public int wWX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wWW != null) {
                aVar.g(1, this.wWW);
            }
            aVar.fU(2, this.wWX);
            return 0;
        } else if (i == 1) {
            if (this.wWW != null) {
                r0 = e.a.a.b.b.a.h(1, this.wWW) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.fR(2, this.wWX);
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
            bvp com_tencent_mm_protocal_c_bvp = (bvp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bvp.wWW = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bvp.wWX = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
