package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class FindMContactIntroUI$7 implements OnClickListener {
    final /* synthetic */ FindMContactIntroUI ymj;

    FindMContactIntroUI$7(FindMContactIntroUI findMContactIntroUI) {
        this.ymj = findMContactIntroUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(true));
        FindMContactIntroUI.f(this.ymj);
    }
}