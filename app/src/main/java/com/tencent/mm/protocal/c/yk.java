package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class yk extends bdf {
    public int kLO;
    public String kLP;
    public int wiE;
    public String wiF;
    public String wiG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.kLO);
            if (this.kLP != null) {
                aVar.g(3, this.kLP);
            }
            aVar.fU(4, this.wiE);
            if (this.wiF != null) {
                aVar.g(5, this.wiF);
            }
            if (this.wiG == null) {
                return 0;
            }
            aVar.g(6, this.wiG);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.kLO);
            if (this.kLP != null) {
                r0 += e.a.a.b.b.a.h(3, this.kLP);
            }
            r0 += e.a.a.a.fR(4, this.wiE);
            if (this.wiF != null) {
                r0 += e.a.a.b.b.a.h(5, this.wiF);
            }
            if (this.wiG != null) {
                r0 += e.a.a.b.b.a.h(6, this.wiG);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yk ykVar = (yk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        ykVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    ykVar.kLO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ykVar.kLP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ykVar.wiE = aVar3.Avy.ry();
                    return 0;
                case 5:
                    ykVar.wiF = aVar3.Avy.readString();
                    return 0;
                case 6:
                    ykVar.wiG = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
