package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pointers.PBool;

class b$10 implements OnCancelListener {
    final /* synthetic */ PBool yWn;

    b$10(PBool pBool) {
        this.yWn = pBool;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.yWn.value = true;
    }
}
