package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class x extends bdf {
    public int liH = 268513600;
    public String liI = "请求不成功，请稍候再试";
    public String vDK;
    public int vDL;
    public int vDM;
    public String vDN;
    public LinkedList<k> vDO = new LinkedList();
    public String vDP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.liH);
            if (this.liI != null) {
                aVar.g(3, this.liI);
            }
            aVar.d(4, 8, this.vDO);
            if (this.vDP != null) {
                aVar.g(5, this.vDP);
            }
            if (this.vDK != null) {
                aVar.g(6, this.vDK);
            }
            aVar.fU(7, this.vDL);
            aVar.fU(8, this.vDM);
            if (this.vDN == null) {
                return 0;
            }
            aVar.g(9, this.vDN);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.liH);
            if (this.liI != null) {
                r0 += e.a.a.b.b.a.h(3, this.liI);
            }
            r0 += e.a.a.a.c(4, 8, this.vDO);
            if (this.vDP != null) {
                r0 += e.a.a.b.b.a.h(5, this.vDP);
            }
            if (this.vDK != null) {
                r0 += e.a.a.b.b.a.h(6, this.vDK);
            }
            r0 = (r0 + e.a.a.a.fR(7, this.vDL)) + e.a.a.a.fR(8, this.vDM);
            if (this.vDN != null) {
                r0 += e.a.a.b.b.a.h(9, this.vDN);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vDO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
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
                        xVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    xVar.liH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    xVar.liI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new k();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        xVar.vDO.add(feVar);
                    }
                    return 0;
                case 5:
                    xVar.vDP = aVar3.Avy.readString();
                    return 0;
                case 6:
                    xVar.vDK = aVar3.Avy.readString();
                    return 0;
                case 7:
                    xVar.vDL = aVar3.Avy.ry();
                    return 0;
                case 8:
                    xVar.vDM = aVar3.Avy.ry();
                    return 0;
                case 9:
                    xVar.vDN = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
