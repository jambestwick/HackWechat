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

public final class na extends c {
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
                a.setColor(-9538696);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(46.0f, 55.0f);
                j.lineTo(46.0f, 55.578f);
                j.lineTo(46.215f, 56.114f);
                j.lineTo(47.769f, 60.0f);
                j.lineTo(33.231f, 60.0f);
                j.lineTo(34.785f, 56.114f);
                j.lineTo(35.0f, 55.578f);
                j.lineTo(35.0f, 55.0f);
                j.lineTo(46.0f, 55.0f);
                j.lineTo(46.0f, 55.0f);
                j.close();
                j.moveTo(3.0f, 4.44f);
                j.cubicTo(3.0f, 3.645f, 3.64f, 3.0f, 4.445f, 3.0f);
                j.lineTo(75.555f, 3.0f);
                j.cubicTo(76.353f, 3.0f, 77.0f, 3.637f, 77.0f, 4.44f);
                j.lineTo(77.0f, 29.0f);
                j.lineTo(80.0f, 29.0f);
                j.lineTo(80.0f, 4.316f);
                j.cubicTo(80.0f, 1.925f, 78.068f, 0.0f, 75.685f, 0.0f);
                j.lineTo(4.315f, 0.0f);
                j.cubicTo(1.938f, 0.0f, 0.0f, 1.932f, 0.0f, 4.316f);
                j.lineTo(0.0f, 50.684f);
                j.cubicTo(0.0f, 53.075f, 1.932f, 55.0f, 4.315f, 55.0f);
                j.lineTo(32.0f, 55.0f);
                j.lineTo(30.0f, 60.0f);
                j.lineTo(26.0f, 62.0f);
                j.lineTo(26.0f, 63.0f);
                j.lineTo(55.0f, 63.0f);
                j.lineTo(55.0f, 62.0f);
                j.lineTo(51.0f, 60.0f);
                j.lineTo(49.0f, 55.0f);
                j.lineTo(59.0f, 55.0f);
                j.lineTo(59.0f, 52.0f);
                j.lineTo(49.0f, 52.0f);
                j.lineTo(32.0f, 52.0f);
                j.lineTo(4.445f, 52.0f);
                j.cubicTo(3.647f, 52.0f, 3.0f, 51.363f, 3.0f, 50.56f);
                j.lineTo(3.0f, 43.0f);
                j.lineTo(59.0f, 43.0f);
                j.lineTo(59.0f, 40.0f);
                j.lineTo(3.0f, 40.0f);
                j.lineTo(3.0f, 4.44f);
                j.lineTo(3.0f, 4.44f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(65.0f, 60.0f);
                j.lineTo(84.0f, 60.0f);
                j.lineTo(84.0f, 46.0f);
                j.lineTo(65.0f, 46.0f);
                j.lineTo(65.0f, 60.0f);
                j.close();
                j.moveTo(69.0f, 37.0f);
                j.cubicTo(69.0f, 35.895f, 69.9f, 35.0f, 70.992f, 35.0f);
                j.lineTo(78.008f, 35.0f);
                j.cubicTo(79.108f, 35.0f, 80.0f, 35.887f, 80.0f, 37.0f);
                j.lineTo(80.0f, 43.0f);
                j.lineTo(69.0f, 43.0f);
                j.lineTo(69.0f, 37.0f);
                j.close();
                j.moveTo(84.132f, 43.0f);
                j.lineTo(83.0f, 43.0f);
                j.lineTo(83.0f, 37.754f);
                j.cubicTo(83.0f, 34.574f, 80.423f, 32.0f, 77.245f, 32.0f);
                j.lineTo(71.755f, 32.0f);
                j.cubicTo(68.582f, 32.0f, 66.0f, 34.576f, 66.0f, 37.754f);
                j.lineTo(66.0f, 43.0f);
                j.lineTo(64.868f, 43.0f);
                j.cubicTo(63.291f, 43.0f, 62.0f, 44.292f, 62.0f, 45.887f);
                j.lineTo(62.0f, 60.113f);
                j.cubicTo(62.0f, 61.718f, 63.284f, 63.0f, 64.868f, 63.0f);
                j.lineTo(84.132f, 63.0f);
                j.cubicTo(85.709f, 63.0f, 87.0f, 61.708f, 87.0f, 60.113f);
                j.lineTo(87.0f, 45.887f);
                j.cubicTo(87.0f, 44.281f, 85.716f, 43.0f, 84.132f, 43.0f);
                j.lineTo(84.132f, 43.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
