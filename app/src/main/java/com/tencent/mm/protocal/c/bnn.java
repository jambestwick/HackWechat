package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bnn extends bcv {
    public int ngq;
    public int vIB;
    public int vIC;
    public bdn vYb;
    public int vZy;
    public int wEq;
    public String wxk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vYb == null) {
                throw new b("Not all required fields were included: Content");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.ngq);
            aVar.fU(3, this.wEq);
            if (this.vYb != null) {
                aVar.fW(4, this.vYb.bke());
                this.vYb.a(aVar);
            }
            aVar.fU(5, this.vIC);
            aVar.fU(6, this.vIB);
            if (this.wxk != null) {
                aVar.g(7, this.wxk);
            }
            aVar.fU(8, this.vZy);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.ngq)) + e.a.a.a.fR(3, this.wEq);
            if (this.vYb != null) {
                r0 += e.a.a.a.fT(4, this.vYb.bke());
            }
            r0 = (r0 + e.a.a.a.fR(5, this.vIC)) + e.a.a.a.fR(6, this.vIB);
            if (this.wxk != null) {
                r0 += e.a.a.b.b.a.h(7, this.wxk);
            }
            return r0 + e.a.a.a.fR(8, this.vZy);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vYb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Content");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnn com_tencent_mm_protocal_c_bnn = (bnn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnn.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnn.ngq = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bnn.wEq = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnn.vYb = fdVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bnn.vIC = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bnn.vIB = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bnn.wxk = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bnn.vZy = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
