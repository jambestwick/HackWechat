package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class buf extends a {
    public int ksO;
    public int vOI;
    public LinkedList<bue> wVm = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ksO);
            aVar.d(2, 8, this.wVm);
            aVar.fU(3, this.vOI);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fR(1, this.ksO) + 0) + e.a.a.a.c(2, 8, this.wVm)) + e.a.a.a.fR(3, this.vOI);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wVm.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                buf com_tencent_mm_protocal_c_buf = (buf) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_buf.ksO = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_bue = new bue();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bue.a(aVar4, com_tencent_mm_protocal_c_bue, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_buf.wVm.add(com_tencent_mm_protocal_c_bue);
                        }
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_buf.vOI = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
