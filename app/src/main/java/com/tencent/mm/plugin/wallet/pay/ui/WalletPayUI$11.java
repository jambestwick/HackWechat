package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletPayUI$11 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$11(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.sGh.aYf()) {
            this.sGh.finish();
        }
    }
}
