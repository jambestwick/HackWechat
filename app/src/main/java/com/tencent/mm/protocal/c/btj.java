package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class btj extends bdf {
    public int vJO;
    public LinkedList<btg> vJP = new LinkedList();
    public int wUB;
    public LinkedList<bup> wUC = new LinkedList();
    public int wUD;
    public int wUE;
    public int wUF;
    public int wUG;
    public int wUH;
    public int wUI;
    public int wUJ;
    public int wUK;
    public int wUL;
    public int wUM;
    public int wUN;
    public int wUO;
    public int wUP;
    public int wUQ;
    public int wUr;
    public buo wUs;
    public int wUt;
    public int wUu;
    public int wUv;
    public int wUw;
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wUs == null) {
                throw new b("Not all required fields were included: RelayData");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.fU(2, this.vJO);
                aVar.d(3, 8, this.vJP);
                aVar.fU(4, this.wbh);
                aVar.S(5, this.wbi);
                aVar.fU(6, this.wUr);
                if (this.wUs != null) {
                    aVar.fW(7, this.wUs.bke());
                    this.wUs.a(aVar);
                }
                aVar.fU(8, this.wUB);
                aVar.d(9, 8, this.wUC);
                aVar.fU(10, this.wUD);
                aVar.fU(11, this.wUE);
                aVar.fU(12, this.wUF);
                aVar.fU(13, this.wUG);
                aVar.fU(14, this.wUH);
                aVar.fU(15, this.wUI);
                aVar.fU(16, this.wUt);
                aVar.fU(17, this.wUJ);
                aVar.fU(18, this.wUK);
                aVar.fU(19, this.wUu);
                aVar.fU(20, this.wUL);
                aVar.fU(21, this.wUM);
                aVar.fU(22, this.wUN);
                aVar.fU(23, this.wUO);
                aVar.fU(24, this.wUv);
                aVar.fU(25, this.wUw);
                aVar.fU(26, this.wUP);
                aVar.fU(27, this.wUQ);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + e.a.a.a.fR(2, this.vJO)) + e.a.a.a.c(3, 8, this.vJP)) + e.a.a.a.fR(4, this.wbh)) + e.a.a.a.R(5, this.wbi)) + e.a.a.a.fR(6, this.wUr);
            if (this.wUs != null) {
                r0 += e.a.a.a.fT(7, this.wUs.bke());
            }
            return (((((((((((((((((((r0 + e.a.a.a.fR(8, this.wUB)) + e.a.a.a.c(9, 8, this.wUC)) + e.a.a.a.fR(10, this.wUD)) + e.a.a.a.fR(11, this.wUE)) + e.a.a.a.fR(12, this.wUF)) + e.a.a.a.fR(13, this.wUG)) + e.a.a.a.fR(14, this.wUH)) + e.a.a.a.fR(15, this.wUI)) + e.a.a.a.fR(16, this.wUt)) + e.a.a.a.fR(17, this.wUJ)) + e.a.a.a.fR(18, this.wUK)) + e.a.a.a.fR(19, this.wUu)) + e.a.a.a.fR(20, this.wUL)) + e.a.a.a.fR(21, this.wUM)) + e.a.a.a.fR(22, this.wUN)) + e.a.a.a.fR(23, this.wUO)) + e.a.a.a.fR(24, this.wUv)) + e.a.a.a.fR(25, this.wUw)) + e.a.a.a.fR(26, this.wUP)) + e.a.a.a.fR(27, this.wUQ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vJP.clear();
            this.wUC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wUs != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RelayData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btj com_tencent_mm_protocal_c_btj = (btj) objArr[1];
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
                        com_tencent_mm_protocal_c_btj.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_btj.vJO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new btg();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btj.vJP.add(feVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_btj.wbh = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_btj.wbi = aVar3.Avy.rz();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_btj.wUr = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new buo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btj.wUs = feVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_btj.wUB = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bup();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_btj.wUC.add(feVar);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_btj.wUD = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_btj.wUE = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_btj.wUF = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_btj.wUG = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_btj.wUH = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_btj.wUI = aVar3.Avy.ry();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_btj.wUt = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_btj.wUJ = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_btj.wUK = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_btj.wUu = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_btj.wUL = aVar3.Avy.ry();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_btj.wUM = aVar3.Avy.ry();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_btj.wUN = aVar3.Avy.ry();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_btj.wUO = aVar3.Avy.ry();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_btj.wUv = aVar3.Avy.ry();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_btj.wUw = aVar3.Avy.ry();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_btj.wUP = aVar3.Avy.ry();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_btj.wUQ = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
