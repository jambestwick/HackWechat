package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class nm extends bdf {
    public String fGU;
    public String fGV;

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
            if (this.fGU != null) {
                aVar.g(2, this.fGU);
            }
            if (this.fGV == null) {
                return 0;
            }
            aVar.g(3, this.fGV);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fGU != null) {
                r0 += e.a.a.b.b.a.h(2, this.fGU);
            }
            if (this.fGV != null) {
                r0 += e.a.a.b.b.a.h(3, this.fGV);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            nm nmVar = (nm) objArr[1];
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
                        nmVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    nmVar.fGU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    nmVar.fGV = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
