package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ahd extends bcv {
    public String nfn;
    public int rYW;
    public LinkedList<bdo> vLm = new LinkedList();
    public int wkd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.nfn != null) {
                aVar.g(2, this.nfn);
            }
            aVar.fU(3, this.wkd);
            aVar.d(4, 8, this.vLm);
            aVar.fU(5, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfn != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfn);
            }
            return ((r0 + e.a.a.a.fR(3, this.wkd)) + e.a.a.a.c(4, 8, this.vLm)) + e.a.a.a.fR(5, this.rYW);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vLm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahd com_tencent_mm_protocal_c_ahd = (ahd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahd.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahd.nfn = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahd.wkd = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahd.vLm.add(fdVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahd.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
