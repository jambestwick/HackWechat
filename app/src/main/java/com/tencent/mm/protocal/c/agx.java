package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class agx extends bcv {
    public int vDY;
    public int vIB;
    public int vIC;
    public int wof;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wof);
            aVar.fU(3, this.vIB);
            aVar.fU(4, this.vIC);
            aVar.fU(5, this.vDY);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + e.a.a.a.fR(2, this.wof)) + e.a.a.a.fR(3, this.vIB)) + e.a.a.a.fR(4, this.vIC)) + e.a.a.a.fR(5, this.vDY);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            agx com_tencent_mm_protocal_c_agx = (agx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_agx.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agx.wof = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agx.vIB = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agx.vIC = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agx.vDY = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
