package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xa extends bdf {
    public int lOr;
    public String lOs;
    public String whq;
    public String whr;

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
            if (this.whq != null) {
                aVar.g(2, this.whq);
            }
            if (this.whr != null) {
                aVar.g(3, this.whr);
            }
            aVar.fU(4, this.lOr);
            if (this.lOs == null) {
                return 0;
            }
            aVar.g(5, this.lOs);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.whq != null) {
                r0 += e.a.a.b.b.a.h(2, this.whq);
            }
            if (this.whr != null) {
                r0 += e.a.a.b.b.a.h(3, this.whr);
            }
            r0 += e.a.a.a.fR(4, this.lOr);
            if (this.lOs != null) {
                r0 += e.a.a.b.b.a.h(5, this.lOs);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
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
            xa xaVar = (xa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        xaVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    xaVar.whq = aVar3.Avy.readString();
                    return 0;
                case 3:
                    xaVar.whr = aVar3.Avy.readString();
                    return 0;
                case 4:
                    xaVar.lOr = aVar3.Avy.ry();
                    return 0;
                case 5:
                    xaVar.lOs = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
