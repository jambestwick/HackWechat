package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lk extends bcv {
    public int nZd;
    public String vHq;
    public String vHr;
    public String vUk;
    public String vUl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vHq == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.vHr == null) {
                throw new b("Not all required fields were included: trans_id");
            } else if (this.vUl == null) {
                throw new b("Not all required fields were included: receiver_open_id");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.vHq != null) {
                    aVar.g(2, this.vHq);
                }
                if (this.vHr != null) {
                    aVar.g(3, this.vHr);
                }
                if (this.vUk != null) {
                    aVar.g(4, this.vUk);
                }
                if (this.vUl != null) {
                    aVar.g(5, this.vUl);
                }
                aVar.fU(6, this.nZd);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHq != null) {
                r0 += e.a.a.b.b.a.h(2, this.vHq);
            }
            if (this.vHr != null) {
                r0 += e.a.a.b.b.a.h(3, this.vHr);
            }
            if (this.vUk != null) {
                r0 += e.a.a.b.b.a.h(4, this.vUk);
            }
            if (this.vUl != null) {
                r0 += e.a.a.b.b.a.h(5, this.vUl);
            }
            return r0 + e.a.a.a.fR(6, this.nZd);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vHq == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.vHr == null) {
                throw new b("Not all required fields were included: trans_id");
            } else if (this.vUl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: receiver_open_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lk lkVar = (lk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        lkVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    lkVar.vHq = aVar3.Avy.readString();
                    return 0;
                case 3:
                    lkVar.vHr = aVar3.Avy.readString();
                    return 0;
                case 4:
                    lkVar.vUk = aVar3.Avy.readString();
                    return 0;
                case 5:
                    lkVar.vUl = aVar3.Avy.readString();
                    return 0;
                case 6:
                    lkVar.nZd = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
