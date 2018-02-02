package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ProductScrollView extends ScrollView {
    a pVP;

    public ProductScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProductScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.pVP != null) {
            this.pVP.aFi();
        }
    }
}
