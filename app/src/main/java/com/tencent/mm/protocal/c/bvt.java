package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bvt extends a {
    public LinkedList<bvn> wWZ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).d(1, 8, this.wWZ);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.c(1, 8, this.wWZ) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wWZ.clear();
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
                bvt com_tencent_mm_protocal_c_bvt = (bvt) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList Jl = aVar2.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_bvn = new bvn();
                            e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bvn.a(aVar3, com_tencent_mm_protocal_c_bvn, a.a(aVar3))) {
                            }
                            com_tencent_mm_protocal_c_bvt.wWZ.add(com_tencent_mm_protocal_c_bvn);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
