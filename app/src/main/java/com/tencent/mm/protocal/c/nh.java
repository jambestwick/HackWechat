package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class nh extends bcv {
    public String ksU;
    public String ngo;
    public String nkx;
    public int vGR;
    public String vLX;
    public au vQS;
    public String vVu;
    public String vWg;
    public String vWh;
    public String vWi;
    public String vWj;
    public int vWk;
    public String vWl;
    public int vWm;
    public String vWn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            if (this.vWg != null) {
                aVar.g(3, this.vWg);
            }
            if (this.vLX != null) {
                aVar.g(4, this.vLX);
            }
            if (this.vWh != null) {
                aVar.g(5, this.vWh);
            }
            if (this.vWi != null) {
                aVar.g(6, this.vWi);
            }
            if (this.vWj != null) {
                aVar.g(7, this.vWj);
            }
            if (this.vVu != null) {
                aVar.g(8, this.vVu);
            }
            aVar.fU(9, this.vWk);
            if (this.vQS != null) {
                aVar.fW(10, this.vQS.bke());
                this.vQS.a(aVar);
            }
            if (this.vWl != null) {
                aVar.g(11, this.vWl);
            }
            if (this.ksU != null) {
                aVar.g(12, this.ksU);
            }
            if (this.nkx != null) {
                aVar.g(13, this.nkx);
            }
            aVar.fU(14, this.vGR);
            aVar.fU(15, this.vWm);
            if (this.vWn == null) {
                return 0;
            }
            aVar.g(16, this.vWn);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            if (this.vWg != null) {
                r0 += e.a.a.b.b.a.h(3, this.vWg);
            }
            if (this.vLX != null) {
                r0 += e.a.a.b.b.a.h(4, this.vLX);
            }
            if (this.vWh != null) {
                r0 += e.a.a.b.b.a.h(5, this.vWh);
            }
            if (this.vWi != null) {
                r0 += e.a.a.b.b.a.h(6, this.vWi);
            }
            if (this.vWj != null) {
                r0 += e.a.a.b.b.a.h(7, this.vWj);
            }
            if (this.vVu != null) {
                r0 += e.a.a.b.b.a.h(8, this.vVu);
            }
            r0 += e.a.a.a.fR(9, this.vWk);
            if (this.vQS != null) {
                r0 += e.a.a.a.fT(10, this.vQS.bke());
            }
            if (this.vWl != null) {
                r0 += e.a.a.b.b.a.h(11, this.vWl);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(12, this.ksU);
            }
            if (this.nkx != null) {
                r0 += e.a.a.b.b.a.h(13, this.nkx);
            }
            r0 = (r0 + e.a.a.a.fR(14, this.vGR)) + e.a.a.a.fR(15, this.vWm);
            if (this.vWn != null) {
                r0 += e.a.a.b.b.a.h(16, this.vWn);
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
            nh nhVar = (nh) objArr[1];
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
                        nhVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    nhVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    nhVar.vWg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    nhVar.vLX = aVar3.Avy.readString();
                    return 0;
                case 5:
                    nhVar.vWh = aVar3.Avy.readString();
                    return 0;
                case 6:
                    nhVar.vWi = aVar3.Avy.readString();
                    return 0;
                case 7:
                    nhVar.vWj = aVar3.Avy.readString();
                    return 0;
                case 8:
                    nhVar.vVu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    nhVar.vWk = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new au();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        nhVar.vQS = fdVar;
                    }
                    return 0;
                case 11:
                    nhVar.vWl = aVar3.Avy.readString();
                    return 0;
                case 12:
                    nhVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 13:
                    nhVar.nkx = aVar3.Avy.readString();
                    return 0;
                case 14:
                    nhVar.vGR = aVar3.Avy.ry();
                    return 0;
                case 15:
                    nhVar.vWm = aVar3.Avy.ry();
                    return 0;
                case 16:
                    nhVar.vWn = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
