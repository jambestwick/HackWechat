package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class o extends a {
    public String nfZ;
    public String nfe;
    public String nfg;
    public String nfp;
    public int nga;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfZ != null) {
                aVar.g(1, this.nfZ);
            }
            if (this.nfp != null) {
                aVar.g(2, this.nfp);
            }
            if (this.nfe != null) {
                aVar.g(3, this.nfe);
            }
            if (this.nfg != null) {
                aVar.g(4, this.nfg);
            }
            aVar.fU(5, this.nga);
            return 0;
        } else if (i == 1) {
            if (this.nfZ != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfZ) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfp);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfe);
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfg);
            }
            return r0 + e.a.a.a.fR(5, this.nga);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.nfZ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    oVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    oVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 4:
                    oVar.nfg = aVar3.Avy.readString();
                    return 0;
                case 5:
                    oVar.nga = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
