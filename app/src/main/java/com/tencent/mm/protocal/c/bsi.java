package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bsi extends bcv {
    public String fFm;
    public String frP;
    public String oZz;
    public String sPk;
    public String vJt;
    public LinkedList<Integer> wKL = new LinkedList();
    public String wKM;
    public String wKO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.fFm != null) {
                aVar.g(2, this.fFm);
            }
            aVar.d(3, 2, this.wKL);
            if (this.wKM != null) {
                aVar.g(4, this.wKM);
            }
            if (this.vJt != null) {
                aVar.g(5, this.vJt);
            }
            if (this.frP != null) {
                aVar.g(6, this.frP);
            }
            if (this.sPk != null) {
                aVar.g(7, this.sPk);
            }
            if (this.wKO != null) {
                aVar.g(8, this.wKO);
            }
            if (this.oZz == null) {
                return 0;
            }
            aVar.g(9, this.oZz);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(2, this.fFm);
            }
            r0 += e.a.a.a.c(3, 2, this.wKL);
            if (this.wKM != null) {
                r0 += e.a.a.b.b.a.h(4, this.wKM);
            }
            if (this.vJt != null) {
                r0 += e.a.a.b.b.a.h(5, this.vJt);
            }
            if (this.frP != null) {
                r0 += e.a.a.b.b.a.h(6, this.frP);
            }
            if (this.sPk != null) {
                r0 += e.a.a.b.b.a.h(7, this.sPk);
            }
            if (this.wKO != null) {
                r0 += e.a.a.b.b.a.h(8, this.wKO);
            }
            if (this.oZz != null) {
                r0 += e.a.a.b.b.a.h(9, this.oZz);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wKL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsi com_tencent_mm_protocal_c_bsi = (bsi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsi.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bsi.fFm = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bsi.wKL.add(Integer.valueOf(aVar3.Avy.ry()));
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bsi.wKM = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bsi.vJt = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bsi.frP = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bsi.sPk = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bsi.wKO = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bsi.oZz = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
