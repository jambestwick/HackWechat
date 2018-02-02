package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aiv extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = e.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return e.CTRL_INDEX;
            case 1:
                return e.CTRL_INDEX;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
                Paint i2 = c.i(looper);
                i2.setFlags(385);
                i2.setStyle(Style.FILL);
                Paint i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.STROKE);
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                c.a(i3, looper).setStrokeWidth(1.0f);
                i3 = c.a(i2, looper);
                i3.setColor(-2565928);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(6.0f, 51.08541f);
                j.cubicTo(5.843611f, 51.030075f, 5.675318f, 51.0f, 5.5f, 51.0f);
                j.cubicTo(4.665797f, 51.0f, 4.0f, 51.674454f, 4.0f, 52.50644f);
                j.lineTo(4.0f, 60.49356f);
                j.cubicTo(4.0f, 61.32846f, 4.6715727f, 62.0f, 5.5f, 62.0f);
                j.cubicTo(5.6756845f, 62.0f, 5.8439f, 61.970085f, 6.0f, 61.915085f);
                j.lineTo(6.0f, 62.0f);
                j.lineTo(9.0f, 62.0f);
                j.lineTo(9.0f, 51.0f);
                j.lineTo(6.0f, 51.0f);
                j.lineTo(6.0f, 51.08541f);
                j.close();
                j.moveTo(103.0f, 62.0f);
                j.lineTo(132.0f, 44.0f);
                j.lineTo(132.0f, 101.0f);
                j.lineTo(103.0f, 84.0f);
                j.lineTo(103.0f, 62.0f);
                j.close();
                j.moveTo(11.0f, 42.00439f);
                j.cubicTo(11.0f, 37.583687f, 14.586183f, 34.0f, 19.00362f, 34.0f);
                j.lineTo(90.99638f, 34.0f);
                j.cubicTo(95.41666f, 34.0f, 99.0f, 37.584976f, 99.0f, 42.00439f);
                j.lineTo(99.0f, 102.995605f);
                j.cubicTo(99.0f, 107.41631f, 95.41382f, 111.0f, 90.99638f, 111.0f);
                j.lineTo(19.00362f, 111.0f);
                j.cubicTo(14.583343f, 111.0f, 11.0f, 107.41502f, 11.0f, 102.995605f);
                j.lineTo(11.0f, 42.00439f);
                j.close();
                j.moveTo(134.0f, 43.0f);
                j.lineTo(139.0f, 43.0f);
                j.lineTo(139.0f, 103.0f);
                j.lineTo(134.0f, 103.0f);
                j.lineTo(134.0f, 43.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(6.0f, 51.08541f);
                j.cubicTo(5.843611f, 51.030075f, 5.675318f, 51.0f, 5.5f, 51.0f);
                j.cubicTo(4.665797f, 51.0f, 4.0f, 51.674454f, 4.0f, 52.50644f);
                j.lineTo(4.0f, 60.49356f);
                j.cubicTo(4.0f, 61.32846f, 4.6715727f, 62.0f, 5.5f, 62.0f);
                j.cubicTo(5.6756845f, 62.0f, 5.8439f, 61.970085f, 6.0f, 61.915085f);
                j.lineTo(6.0f, 62.0f);
                j.lineTo(9.0f, 62.0f);
                j.lineTo(9.0f, 51.0f);
                j.lineTo(6.0f, 51.0f);
                j.lineTo(6.0f, 51.08541f);
                j.close();
                j.moveTo(103.0f, 62.0f);
                j.lineTo(132.0f, 44.0f);
                j.lineTo(132.0f, 101.0f);
                j.lineTo(103.0f, 84.0f);
                j.lineTo(103.0f, 62.0f);
                j.close();
                j.moveTo(11.0f, 42.00439f);
                j.cubicTo(11.0f, 37.583687f, 14.586183f, 34.0f, 19.00362f, 34.0f);
                j.lineTo(90.99638f, 34.0f);
                j.cubicTo(95.41666f, 34.0f, 99.0f, 37.584976f, 99.0f, 42.00439f);
                j.lineTo(99.0f, 102.995605f);
                j.cubicTo(99.0f, 107.41631f, 95.41382f, 111.0f, 90.99638f, 111.0f);
                j.lineTo(19.00362f, 111.0f);
                j.cubicTo(14.583343f, 111.0f, 11.0f, 107.41502f, 11.0f, 102.995605f);
                j.lineTo(11.0f, 42.00439f);
                j.close();
                j.moveTo(134.0f, 43.0f);
                j.lineTo(139.0f, 43.0f);
                j.lineTo(139.0f, 103.0f);
                j.lineTo(134.0f, 103.0f);
                j.lineTo(134.0f, 43.0f);
                j.close();
                Paint i4 = c.i(looper);
                i4.setFlags(385);
                i4.setStyle(Style.FILL);
                Paint i5 = c.i(looper);
                i5.setFlags(385);
                i5.setStyle(Style.STROKE);
                i4.setColor(WebView.NIGHT_MODE_COLOR);
                i5.setStrokeWidth(1.0f);
                i5.setStrokeCap(Cap.BUTT);
                i5.setStrokeJoin(Join.MITER);
                i5.setStrokeMiter(4.0f);
                i5.setPathEffect(null);
                float[] a2 = c.a(e, 139.0f, 0.0f, 4.0f, 0.0f, 111.0f, 34.0f);
                f.reset();
                f.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-9772465, -6687207}, new float[]{0.0f, 1.0f}, f, 0);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
