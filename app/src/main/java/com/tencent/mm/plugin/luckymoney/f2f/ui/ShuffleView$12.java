package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ShuffleView$12 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView obk;

    ShuffleView$12(ShuffleView shuffleView) {
        this.obk = shuffleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue == 0.0f) {
            ShuffleView.b(this.obk).clear();
            ShuffleView.c(this.obk).clear();
            for (int i = 0; i < ShuffleView.d(this.obk); i++) {
                ShuffleView.b(this.obk).add(Float.valueOf(((View) ShuffleView.e(this.obk).get(i)).getTranslationX()));
                ShuffleView.c(this.obk).add(Float.valueOf(((View) ShuffleView.e(this.obk).get(i)).getTranslationY()));
            }
            return;
        }
        ((View) ShuffleView.e(this.obk).get(0)).setTranslationX((((Float) ShuffleView.b(this.obk).get(0)).floatValue() * (1.0f - floatValue)) + (this.obk.rV(0) * floatValue));
        ((View) ShuffleView.e(this.obk).get(0)).setTranslationY((((Float) ShuffleView.c(this.obk).get(0)).floatValue() * (1.0f - floatValue)) + (this.obk.rW(0) * floatValue));
        for (int i2 = 1; i2 < ShuffleView.d(this.obk); i2++) {
            ((View) ShuffleView.e(this.obk).get(i2)).setTranslationX((((Float) ShuffleView.b(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (this.obk.rV(i2) * floatValue));
            ((View) ShuffleView.e(this.obk).get(i2)).setTranslationY((((Float) ShuffleView.c(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (this.obk.rW(i2) * floatValue));
        }
    }
}
