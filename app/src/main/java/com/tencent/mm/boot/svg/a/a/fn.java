package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class fn extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Paint a = c.a(i2, looper);
                a.setColor(-9473160);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                float[] a2 = c.a(e, -1.0f, 0.0f, 80.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(45.0513f, 58.846f);
                j.lineTo(48.5133f, 60.0f);
                j.lineTo(32.4863f, 60.0f);
                j.lineTo(35.9483f, 58.846f);
                j.lineTo(38.0003f, 58.162f);
                j.lineTo(38.0003f, 56.0f);
                j.lineTo(38.0003f, 52.0f);
                j.lineTo(43.0003f, 52.0f);
                j.lineTo(43.0003f, 56.0f);
                j.lineTo(43.0003f, 58.162f);
                j.lineTo(45.0513f, 58.846f);
                j.close();
                j.moveTo(35.0003f, 49.0f);
                j.lineTo(3.0003f, 49.0f);
                j.lineTo(3.0003f, 3.0f);
                j.lineTo(77.0003f, 3.0f);
                j.lineTo(77.0003f, 18.0f);
                j.lineTo(80.0003f, 18.0f);
                j.lineTo(80.0003f, 2.87f);
                j.cubicTo(80.0003f, 1.285f, 78.7143f, 0.0f, 77.1293f, 0.0f);
                j.lineTo(2.8713f, 0.0f);
                j.cubicTo(1.2893f, 0.0f, 3.0E-4f, 1.285f, 3.0E-4f, 2.87f);
                j.lineTo(3.0E-4f, 49.13f);
                j.cubicTo(3.0E-4f, 50.715f, 1.2853f, 52.0f, 2.8713f, 52.0f);
                j.lineTo(35.0003f, 52.0f);
                j.lineTo(35.0003f, 56.0f);
                j.lineTo(23.0003f, 60.0f);
                j.lineTo(23.0003f, 63.0f);
                j.lineTo(58.0003f, 63.0f);
                j.lineTo(58.0003f, 60.0f);
                j.lineTo(46.0003f, 56.0f);
                j.lineTo(46.0003f, 52.0f);
                j.lineTo(61.5f, 52.0f);
                j.lineTo(61.5f, 49.0f);
                j.lineTo(46.0003f, 49.0f);
                j.lineTo(35.0003f, 49.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                e = c.a(a2, -1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(3.0f, 59.028194f);
                j.lineTo(3.0f, 24.971806f);
                j.cubicTo(3.0f, 24.435892f, 3.40374f, 24.0f, 3.9f, 24.0f);
                j.lineTo(20.1f, 24.0f);
                j.cubicTo(20.59626f, 24.0f, 21.0f, 24.435892f, 21.0f, 24.971806f);
                j.lineTo(21.0f, 59.028194f);
                j.cubicTo(21.0f, 59.56411f, 20.59626f, 60.0f, 20.1f, 60.0f);
                j.lineTo(3.9f, 60.0f);
                j.cubicTo(3.40374f, 60.0f, 3.0f, 59.56411f, 3.0f, 59.028194f);
                j.lineTo(3.0f, 59.028194f);
                j.close();
                j.moveTo(22.188679f, 63.0f);
                j.cubicTo(23.188982f, 63.0f, 24.0f, 62.212334f, 24.0f, 61.242157f);
                j.lineTo(24.0f, 22.757843f);
                j.cubicTo(24.0f, 21.787004f, 23.187622f, 21.0f, 22.188679f, 21.0f);
                j.lineTo(1.8113208f, 21.0f);
                j.cubicTo(0.8110189f, 21.0f, 0.0f, 21.787664f, 0.0f, 22.757843f);
                j.lineTo(0.0f, 61.242157f);
                j.cubicTo(0.0f, 62.212994f, 0.81237733f, 63.0f, 1.8113208f, 63.0f);
                j.lineTo(22.188679f, 63.0f);
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
