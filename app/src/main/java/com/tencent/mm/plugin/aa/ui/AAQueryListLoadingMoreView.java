package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.v;

public class AAQueryListLoadingMoreView extends LinearLayout {
    public AAQueryListLoadingMoreView(Context context) {
        super(context);
        init(context);
    }

    public AAQueryListLoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AAQueryListLoadingMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        v.fv(context).inflate(g.uAU, this, true);
    }
}
