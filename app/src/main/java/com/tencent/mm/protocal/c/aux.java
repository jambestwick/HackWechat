package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aux extends a {
    public String desc;
    public String peD;
    public String title;
    public String vZl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            if (this.vZl != null) {
                aVar.g(3, this.vZl);
            }
            if (this.peD == null) {
                return 0;
            }
            aVar.g(4, this.peD);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(2, this.desc);
            }
            if (this.vZl != null) {
                r0 += e.a.a.b.b.a.h(3, this.vZl);
            }
            if (this.peD != null) {
                r0 += e.a.a.b.b.a.h(4, this.peD);
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
            aux com_tencent_mm_protocal_c_aux = (aux) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aux.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aux.desc = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aux.vZl = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aux.peD = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
