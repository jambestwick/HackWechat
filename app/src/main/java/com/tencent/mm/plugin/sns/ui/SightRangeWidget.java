package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.i.g;

public class SightRangeWidget extends RangeWidget {
    public SightRangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightRangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int getLayoutResource() {
        return g.qGH;
    }

    protected final int bzZ() {
        return 10;
    }

    public final boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        super.a(i, i2, intent, atContactWidget);
        if (atContactWidget != null) {
            if (this.rwt == 1) {
                atContactWidget.setVisibility(4);
                atContactWidget.byZ();
            } else {
                atContactWidget.setVisibility(0);
            }
        }
        return true;
    }
}
