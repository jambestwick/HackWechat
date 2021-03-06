package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class tz extends bcv {
    public double latitude;
    public double longitude;
    public long timestamp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.b(2, this.latitude);
            aVar.b(3, this.longitude);
            aVar.S(4, this.timestamp);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + (e.a.a.b.b.a.dX(2) + 8)) + (e.a.a.b.b.a.dX(3) + 8)) + e.a.a.a.R(4, this.timestamp);
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
            tz tzVar = (tz) objArr[1];
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
                        tzVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    tzVar.latitude = aVar3.Avy.readDouble();
                    return 0;
                case 3:
                    tzVar.longitude = aVar3.Avy.readDouble();
                    return 0;
                case 4:
                    tzVar.timestamp = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
