package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class avx extends bcv {
    public String ngo;
    public String nkB;
    public int vDY;
    public String vLX;
    public String vVu;
    public String vWg;
    public String vWh;
    public String vWi;
    public String vWj;
    public String whp;

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
            if (this.whp != null) {
                aVar.g(9, this.whp);
            }
            aVar.fU(10, this.vDY);
            if (this.nkB == null) {
                return 0;
            }
            aVar.g(11, this.nkB);
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
            if (this.whp != null) {
                r0 += e.a.a.b.b.a.h(9, this.whp);
            }
            r0 += e.a.a.a.fR(10, this.vDY);
            if (this.nkB != null) {
                r0 += e.a.a.b.b.a.h(11, this.nkB);
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
            avx com_tencent_mm_protocal_c_avx = (avx) objArr[1];
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
                        com_tencent_mm_protocal_c_avx.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avx.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avx.vWg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avx.vLX = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avx.vWh = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avx.vWi = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avx.vWj = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avx.vVu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_avx.whp = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_avx.vDY = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_avx.nkB = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
