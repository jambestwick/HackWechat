package com.tencent.mm.z;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bn extends a {
    public LinkedList<bm> hhC = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).d(1, 8, this.hhC);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.c(1, 8, this.hhC) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.hhC.clear();
                e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
                bn bnVar = (bn) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList Jl = aVar2.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a bmVar = new bm();
                            e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bmVar.a(aVar3, bmVar, a.a(aVar3))) {
                            }
                            bnVar.hhC.add(bmVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
