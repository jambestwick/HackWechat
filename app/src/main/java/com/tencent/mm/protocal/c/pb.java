package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class pb extends a {
    public String fon;
    public String nfX;
    public String nfe;
    public int vYc;
    public LinkedList<aqr> vYd = new LinkedList();
    public int vYe;
    public String vYf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfe != null) {
                aVar.g(1, this.nfe);
            }
            aVar.fU(2, this.vYc);
            if (this.fon != null) {
                aVar.g(3, this.fon);
            }
            if (this.nfX != null) {
                aVar.g(4, this.nfX);
            }
            aVar.d(5, 8, this.vYd);
            aVar.fU(6, this.vYe);
            if (this.vYf == null) {
                return 0;
            }
            aVar.g(7, this.vYf);
            return 0;
        } else if (i == 1) {
            if (this.nfe != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfe) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vYc);
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(3, this.fon);
            }
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfX);
            }
            r0 = (r0 + e.a.a.a.c(5, 8, this.vYd)) + e.a.a.a.fR(6, this.vYe);
            if (this.vYf != null) {
                r0 += e.a.a.b.b.a.h(7, this.vYf);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vYd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            pb pbVar = (pb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    pbVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 2:
                    pbVar.vYc = aVar3.Avy.ry();
                    return 0;
                case 3:
                    pbVar.fon = aVar3.Avy.readString();
                    return 0;
                case 4:
                    pbVar.nfX = aVar3.Avy.readString();
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_aqr = new aqr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aqr.a(aVar4, com_tencent_mm_protocal_c_aqr, a.a(aVar4))) {
                        }
                        pbVar.vYd.add(com_tencent_mm_protocal_c_aqr);
                    }
                    return 0;
                case 6:
                    pbVar.vYe = aVar3.Avy.ry();
                    return 0;
                case 7:
                    pbVar.vYf = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
