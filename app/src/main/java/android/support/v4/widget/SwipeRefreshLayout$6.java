package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$6 extends Animation {
    final /* synthetic */ SwipeRefreshLayout EN;

    SwipeRefreshLayout$6(SwipeRefreshLayout swipeRefreshLayout) {
        this.EN = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.b(this.EN, f);
    }
}
