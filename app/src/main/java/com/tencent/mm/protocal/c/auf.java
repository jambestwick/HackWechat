package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class auf extends a {
    public int vOI;
    public int vWK;
    public int wCg;
    public String wCh;
    public String wCj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vOI);
            if (this.wCj != null) {
                aVar.g(3, this.wCj);
            }
            aVar.fU(4, this.wCg);
            aVar.fU(5, this.vWK);
            if (this.wCh != null) {
                aVar.g(6, this.wCh);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vOI) + 0;
            if (this.wCj != null) {
                r0 += e.a.a.b.b.a.h(3, this.wCj);
            }
            r0 = (r0 + e.a.a.a.fR(4, this.wCg)) + e.a.a.a.fR(5, this.vWK);
            if (this.wCh != null) {
                return r0 + e.a.a.b.b.a.h(6, this.wCh);
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
            auf com_tencent_mm_protocal_c_auf = (auf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_auf.vOI = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auf.wCj = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auf.wCg = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_auf.vWK = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_auf.wCh = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
