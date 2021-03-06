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

public final class alu extends c {
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
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a = c.a(i2, looper);
                a.setColor(-9473160);
                Path j = c.j(looper);
                j.moveTo(48.0f, 0.0f);
                j.cubicTo(74.509674f, 0.0f, 96.0f, 21.49033f, 96.0f, 48.0f);
                j.cubicTo(96.0f, 74.509674f, 74.509674f, 96.0f, 48.0f, 96.0f);
                j.cubicTo(21.49033f, 96.0f, 0.0f, 74.509674f, 0.0f, 48.0f);
                j.cubicTo(0.0f, 21.49033f, 21.49033f, 0.0f, 48.0f, 0.0f);
                j.close();
                canvas.saveLayerAlpha(null, 25, 4);
                canvas.drawPath(j, c.a(a, looper));
                canvas.restore();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-9473160);
                canvas.save();
                a = c.a(a2, looper);
                j = c.j(looper);
                j.moveTo(48.0f, 96.0f);
                j.cubicTo(74.50967f, 96.0f, 96.0f, 74.50967f, 96.0f, 48.0f);
                j.cubicTo(96.0f, 21.490332f, 74.50967f, 0.0f, 48.0f, 0.0f);
                j.cubicTo(21.490332f, 0.0f, 0.0f, 21.490332f, 0.0f, 48.0f);
                j.cubicTo(0.0f, 74.50967f, 21.490332f, 96.0f, 48.0f, 96.0f);
                j.close();
                j.moveTo(48.0f, 94.0f);
                j.cubicTo(73.4051f, 94.0f, 94.0f, 73.4051f, 94.0f, 48.0f);
                j.cubicTo(94.0f, 22.594902f, 73.4051f, 2.0f, 48.0f, 2.0f);
                j.cubicTo(22.594902f, 2.0f, 2.0f, 22.594902f, 2.0f, 48.0f);
                j.cubicTo(2.0f, 73.4051f, 22.594902f, 94.0f, 48.0f, 94.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-9473160);
                j = c.j(looper);
                j.moveTo(26.0f, 32.9981f);
                j.cubicTo(26.0f, 31.89458f, 26.886707f, 31.0f, 27.998102f, 31.0f);
                j.lineTo(32.0019f, 31.0f);
                j.cubicTo(33.10542f, 31.0f, 34.0f, 31.886707f, 34.0f, 32.9981f);
                j.lineTo(34.0f, 37.0019f);
                j.cubicTo(34.0f, 38.10542f, 33.113293f, 39.0f, 32.0019f, 39.0f);
                j.lineTo(27.998102f, 39.0f);
                j.cubicTo(26.89458f, 39.0f, 26.0f, 38.113293f, 26.0f, 37.0019f);
                j.lineTo(26.0f, 32.9981f);
                j.lineTo(26.0f, 32.9981f);
                j.close();
                j.moveTo(26.0f, 44.9981f);
                j.cubicTo(26.0f, 43.89458f, 26.886707f, 43.0f, 27.998102f, 43.0f);
                j.lineTo(32.0019f, 43.0f);
                j.cubicTo(33.10542f, 43.0f, 34.0f, 43.886707f, 34.0f, 44.9981f);
                j.lineTo(34.0f, 49.0019f);
                j.cubicTo(34.0f, 50.10542f, 33.113293f, 51.0f, 32.0019f, 51.0f);
                j.lineTo(27.998102f, 51.0f);
                j.cubicTo(26.89458f, 51.0f, 26.0f, 50.113293f, 26.0f, 49.0019f);
                j.lineTo(26.0f, 44.9981f);
                j.lineTo(26.0f, 44.9981f);
                j.close();
                j.moveTo(50.0f, 32.9981f);
                j.cubicTo(50.0f, 31.89458f, 50.886707f, 31.0f, 51.9981f, 31.0f);
                j.lineTo(56.0019f, 31.0f);
                j.cubicTo(57.10542f, 31.0f, 58.0f, 31.886707f, 58.0f, 32.9981f);
                j.lineTo(58.0f, 37.0019f);
                j.cubicTo(58.0f, 38.10542f, 57.113293f, 39.0f, 56.0019f, 39.0f);
                j.lineTo(51.9981f, 39.0f);
                j.cubicTo(50.89458f, 39.0f, 50.0f, 38.113293f, 50.0f, 37.0019f);
                j.lineTo(50.0f, 32.9981f);
                j.lineTo(50.0f, 32.9981f);
                j.close();
                j.moveTo(50.0f, 44.9981f);
                j.cubicTo(50.0f, 43.89458f, 50.886707f, 43.0f, 51.9981f, 43.0f);
                j.lineTo(56.0019f, 43.0f);
                j.cubicTo(57.10542f, 43.0f, 58.0f, 43.886707f, 58.0f, 44.9981f);
                j.lineTo(58.0f, 49.0019f);
                j.cubicTo(58.0f, 50.10542f, 57.113293f, 51.0f, 56.0019f, 51.0f);
                j.lineTo(51.9981f, 51.0f);
                j.cubicTo(50.89458f, 51.0f, 50.0f, 50.113293f, 50.0f, 49.0019f);
                j.lineTo(50.0f, 44.9981f);
                j.lineTo(50.0f, 44.9981f);
                j.close();
                j.moveTo(38.0f, 32.9981f);
                j.cubicTo(38.0f, 31.89458f, 38.886707f, 31.0f, 39.9981f, 31.0f);
                j.lineTo(44.0019f, 31.0f);
                j.cubicTo(45.10542f, 31.0f, 46.0f, 31.886707f, 46.0f, 32.9981f);
                j.lineTo(46.0f, 37.0019f);
                j.cubicTo(46.0f, 38.10542f, 45.113293f, 39.0f, 44.0019f, 39.0f);
                j.lineTo(39.9981f, 39.0f);
                j.cubicTo(38.89458f, 39.0f, 38.0f, 38.113293f, 38.0f, 37.0019f);
                j.lineTo(38.0f, 32.9981f);
                j.lineTo(38.0f, 32.9981f);
                j.close();
                j.moveTo(38.0f, 44.9981f);
                j.cubicTo(38.0f, 43.89458f, 38.886707f, 43.0f, 39.9981f, 43.0f);
                j.lineTo(44.0019f, 43.0f);
                j.cubicTo(45.10542f, 43.0f, 46.0f, 43.886707f, 46.0f, 44.9981f);
                j.lineTo(46.0f, 49.0019f);
                j.cubicTo(46.0f, 50.10542f, 45.113293f, 51.0f, 44.0019f, 51.0f);
                j.lineTo(39.9981f, 51.0f);
                j.cubicTo(38.89458f, 51.0f, 38.0f, 50.113293f, 38.0f, 49.0019f);
                j.lineTo(38.0f, 44.9981f);
                j.lineTo(38.0f, 44.9981f);
                j.close();
                j.moveTo(62.0f, 32.9981f);
                j.cubicTo(62.0f, 31.89458f, 62.886707f, 31.0f, 63.9981f, 31.0f);
                j.lineTo(68.0019f, 31.0f);
                j.cubicTo(69.10542f, 31.0f, 70.0f, 31.886707f, 70.0f, 32.9981f);
                j.lineTo(70.0f, 37.0019f);
                j.cubicTo(70.0f, 38.10542f, 69.1133f, 39.0f, 68.0019f, 39.0f);
                j.lineTo(63.9981f, 39.0f);
                j.cubicTo(62.89458f, 39.0f, 62.0f, 38.113293f, 62.0f, 37.0019f);
                j.lineTo(62.0f, 32.9981f);
                j.lineTo(62.0f, 32.9981f);
                j.close();
                j.moveTo(62.0f, 44.9981f);
                j.cubicTo(62.0f, 43.89458f, 62.886707f, 43.0f, 63.9981f, 43.0f);
                j.lineTo(68.0019f, 43.0f);
                j.cubicTo(69.10542f, 43.0f, 70.0f, 43.886707f, 70.0f, 44.9981f);
                j.lineTo(70.0f, 49.0019f);
                j.cubicTo(70.0f, 50.10542f, 69.1133f, 51.0f, 68.0019f, 51.0f);
                j.lineTo(63.9981f, 51.0f);
                j.cubicTo(62.89458f, 51.0f, 62.0f, 50.113293f, 62.0f, 49.0019f);
                j.lineTo(62.0f, 44.9981f);
                j.lineTo(62.0f, 44.9981f);
                j.close();
                j.moveTo(34.0f, 58.9981f);
                j.cubicTo(34.0f, 57.89458f, 34.8999f, 57.0f, 35.991245f, 57.0f);
                j.lineTo(60.008755f, 57.0f);
                j.cubicTo(61.10849f, 57.0f, 62.0f, 57.886707f, 62.0f, 58.9981f);
                j.lineTo(62.0f, 63.0019f);
                j.cubicTo(62.0f, 64.10542f, 61.1001f, 65.0f, 60.008755f, 65.0f);
                j.lineTo(35.991245f, 65.0f);
                j.cubicTo(34.89151f, 65.0f, 34.0f, 64.1133f, 34.0f, 63.0019f);
                j.lineTo(34.0f, 58.9981f);
                j.lineTo(34.0f, 58.9981f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
