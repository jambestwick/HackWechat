package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class EmojiDetailScrollView extends ScrollView {
    boolean lCp;

    public EmojiDetailScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiDetailScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lCp = true;
        setFadingEdgeLength(0);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    public void requestLayout() {
        this.lCp = false;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.lCp = false;
        super.onLayout(z, i, i2, i3, i4);
    }

    public void scrollTo(int i, int i2) {
        this.lCp = true;
    }

    public void scrollBy(int i, int i2) {
    }

    public void requestChildFocus(View view, View view2) {
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.lCp) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }
}
