package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class f$11 implements OnClickListener {
    final /* synthetic */ int fmb;
    final /* synthetic */ WalletBaseUI sEm;

    f$11(WalletBaseUI walletBaseUI, int i) {
        this.sEm = walletBaseUI;
        this.fmb = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.c(this.sEm, this.sEm.vf, this.fmb);
        if (this.sEm.aYf()) {
            this.sEm.finish();
        }
    }
}
