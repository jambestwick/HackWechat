package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bfz extends bcv {
    public String nfU;
    public String nfp;
    public String oPA;
    public String vIO;
    public String wKG;
    public String wKH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.nfU != null) {
                aVar.g(2, this.nfU);
            }
            if (this.wKG != null) {
                aVar.g(3, this.wKG);
            }
            if (this.oPA != null) {
                aVar.g(5, this.oPA);
            }
            if (this.nfp != null) {
                aVar.g(4, this.nfp);
            }
            if (this.vIO != null) {
                aVar.g(6, this.vIO);
            }
            if (this.wKH == null) {
                return 0;
            }
            aVar.g(7, this.wKH);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfU != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfU);
            }
            if (this.wKG != null) {
                r0 += e.a.a.b.b.a.h(3, this.wKG);
            }
            if (this.oPA != null) {
                r0 += e.a.a.b.b.a.h(5, this.oPA);
            }
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfp);
            }
            if (this.vIO != null) {
                r0 += e.a.a.b.b.a.h(6, this.vIO);
            }
            if (this.wKH != null) {
                r0 += e.a.a.b.b.a.h(7, this.wKH);
            }
            return r0;
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
            bfz com_tencent_mm_protocal_c_bfz = (bfz) objArr[1];
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
                        com_tencent_mm_protocal_c_bfz.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfz.nfU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfz.wKG = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfz.nfp = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfz.oPA = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfz.vIO = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfz.wKH = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
