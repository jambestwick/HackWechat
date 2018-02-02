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

public final class dg extends c {
    private final int height = 41;
    private final int width = 47;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 47;
            case 1:
                return 41;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -126.0f, 0.0f, 1.0f, -1631.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 127.0f, 0.0f, 1.0f, 1631.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a2 = c.a(a, looper);
                a2.setColor(-10526881);
                a2.setStrokeWidth(6.0f);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(0.27375567f, 36.99819f);
                j.cubicTo(-0.9820049f, 39.20833f, 0.05327524f, 41.0f, 2.6142578f, 41.0f);
                j.lineTo(43.385742f, 41.0f);
                j.cubicTo(45.934128f, 41.0f, 46.981197f, 39.20691f, 45.726246f, 36.99819f);
                j.lineTo(25.273756f, 1.00181f);
                j.cubicTo(24.017996f, -1.2083286f, 21.981197f, -1.2069088f, 20.726244f, 1.00181f);
                j.lineTo(0.27375567f, 36.99819f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-10526881);
                j = c.j(looper);
                j.moveTo(22.22413f, 14.0f);
                j.cubicTo(21.548061f, 14.0f, 21.041523f, 14.548094f, 21.093502f, 15.234215f);
                j.lineTo(22.120932f, 28.7963f);
                j.cubicTo(22.14619f, 29.129715f, 22.437256f, 29.4f, 22.777334f, 29.4f);
                j.lineTo(22.722666f, 29.4f);
                j.cubicTo(23.059927f, 29.4f, 23.353582f, 29.132704f, 23.379068f, 28.7963f);
                j.lineTo(24.406498f, 15.234215f);
                j.cubicTo(24.458138f, 14.552577f, 23.953125f, 14.0f, 23.27587f, 14.0f);
                j.lineTo(22.22413f, 14.0f);
                j.close();
                j.moveTo(23.0f, 35.0f);
                j.cubicTo(24.10457f, 35.0f, 25.0f, 34.10457f, 25.0f, 33.0f);
                j.cubicTo(25.0f, 31.89543f, 24.10457f, 31.0f, 23.0f, 31.0f);
                j.cubicTo(21.89543f, 31.0f, 21.0f, 31.89543f, 21.0f, 33.0f);
                j.cubicTo(21.0f, 34.10457f, 21.89543f, 35.0f, 23.0f, 35.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}