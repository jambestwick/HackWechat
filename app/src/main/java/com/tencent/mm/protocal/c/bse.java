package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bse extends bcv {
    public int vDW;
    public bdn vKR;
    public String vMB;
    public bdo vMF;
    public bdn vMG;
    public int wLk;
    public String wTy;
    public bdo wTz;
    public bdo woX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vDW);
            if (this.wTy != null) {
                aVar.g(3, this.wTy);
            }
            if (this.vMB != null) {
                aVar.g(4, this.vMB);
            }
            if (this.woX != null) {
                aVar.fW(5, this.woX.bke());
                this.woX.a(aVar);
            }
            if (this.wTz != null) {
                aVar.fW(6, this.wTz.bke());
                this.wTz.a(aVar);
            }
            if (this.vMF != null) {
                aVar.fW(7, this.vMF.bke());
                this.vMF.a(aVar);
            }
            if (this.vMG != null) {
                aVar.fW(8, this.vMG.bke());
                this.vMG.a(aVar);
            }
            aVar.fU(9, this.wLk);
            if (this.vKR == null) {
                return 0;
            }
            aVar.fW(10, this.vKR.bke());
            this.vKR.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vDW);
            if (this.wTy != null) {
                r0 += e.a.a.b.b.a.h(3, this.wTy);
            }
            if (this.vMB != null) {
                r0 += e.a.a.b.b.a.h(4, this.vMB);
            }
            if (this.woX != null) {
                r0 += e.a.a.a.fT(5, this.woX.bke());
            }
            if (this.wTz != null) {
                r0 += e.a.a.a.fT(6, this.wTz.bke());
            }
            if (this.vMF != null) {
                r0 += e.a.a.a.fT(7, this.vMF.bke());
            }
            if (this.vMG != null) {
                r0 += e.a.a.a.fT(8, this.vMG.bke());
            }
            r0 += e.a.a.a.fR(9, this.wLk);
            if (this.vKR != null) {
                r0 += e.a.a.a.fT(10, this.vKR.bke());
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
            bse com_tencent_mm_protocal_c_bse = (bse) objArr[1];
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
                        com_tencent_mm_protocal_c_bse.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bse.vDW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bse.wTy = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bse.vMB = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bse.woX = fdVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bse.wTz = fdVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bse.vMF = fdVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bse.vMG = fdVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bse.wLk = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bse.vKR = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
