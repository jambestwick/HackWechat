package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aiz extends a {
    public String fon;
    public String nfT;
    public String nfe;
    public String wqx;
    public String wqy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wqx != null) {
                aVar.g(1, this.wqx);
            }
            if (this.nfT != null) {
                aVar.g(2, this.nfT);
            }
            if (this.fon != null) {
                aVar.g(3, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(4, this.nfe);
            }
            if (this.wqy == null) {
                return 0;
            }
            aVar.g(5, this.wqy);
            return 0;
        } else if (i == 1) {
            if (this.wqx != null) {
                r0 = e.a.a.b.b.a.h(1, this.wqx) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfT);
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(3, this.fon);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfe);
            }
            if (this.wqy != null) {
                r0 += e.a.a.b.b.a.h(5, this.wqy);
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
            aiz com_tencent_mm_protocal_c_aiz = (aiz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aiz.wqx = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aiz.nfT = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aiz.fon = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aiz.nfe = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aiz.wqy = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
