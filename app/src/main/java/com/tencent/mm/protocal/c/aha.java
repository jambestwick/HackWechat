package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aha extends bdf {
    public brl vYS;
    public b wor;
    public LinkedList<brj> wos = new LinkedList();
    public int wot;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            if (this.vYS != null) {
                aVar.fW(2, this.vYS.bke());
                this.vYS.a(aVar);
            }
            aVar.d(3, 8, this.wos);
            if (this.wor != null) {
                aVar.b(4, this.wor);
            }
            aVar.fU(5, this.wot);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vYS != null) {
                r0 += e.a.a.a.fT(2, this.vYS.bke());
            }
            r0 += e.a.a.a.c(3, 8, this.wos);
            if (this.wor != null) {
                r0 += e.a.a.a.a(4, this.wor);
            }
            return r0 + e.a.a.a.fR(5, this.wot);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wos.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aha com_tencent_mm_protocal_c_aha = (aha) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aha.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new brl();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aha.vYS = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new brj();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aha.wos.add(feVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aha.wor = aVar3.cJD();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aha.wot = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
