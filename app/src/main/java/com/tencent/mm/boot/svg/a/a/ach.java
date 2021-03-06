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
import com.tencent.wcdb.FileUtils;

public final class ach extends c {
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-8355712);
                e = c.a(e, 1.0f, 0.0f, 19.0f, 0.0f, 1.0f, 16.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(21.0f, 4.0f);
                j.cubicTo(24.147535f, 2.5501022f, 26.619455f, 0.6325835f, 30.0f, 0.0f);
                j.cubicTo(32.320007f, 0.4151329f, 34.539692f, 2.204158f, 37.0f, 3.0f);
                j.cubicTo(43.236816f, 7.22529f, 49.936226f, 10.398091f, 56.0f, 15.0f);
                j.cubicTo(49.32077f, 18.819359f, 42.22787f, 22.367758f, 35.0f, 26.0f);
                j.cubicTo(33.530743f, 27.379005f, 31.71464f, 28.66394f, 30.0f, 29.0f);
                j.cubicTo(27.628403f, 28.73313f, 25.983818f, 27.596455f, 24.0f, 27.0f);
                j.cubicTo(17.256424f, 22.585207f, 9.951647f, 18.86878f, 3.0f, 15.0f);
                j.cubicTo(8.882162f, 10.556237f, 15.359604f, 7.502045f, 21.0f, 4.0f);
                j.lineTo(21.0f, 4.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(3.5527137E-15f, 33.0f);
                j.cubicTo(0.19570836f, 28.427235f, -0.4422517f, 23.633385f, 1.0f, 19.0f);
                j.cubicTo(8.269891f, 23.19211f, 15.755954f, 27.604858f, 23.0f, 32.0f);
                j.cubicTo(24.946566f, 32.809895f, 26.990032f, 33.963226f, 27.0f, 36.0f);
                j.cubicTo(27.139553f, 45.43637f, 26.850477f, 54.7232f, 27.0f, 64.0f);
                j.cubicTo(19.852854f, 61.53287f, 13.782265f, 56.70894f, 7.0f, 53.0f);
                j.cubicTo(4.771078f, 51.70448f, 1.4217879f, 50.872074f, 3.5527137E-15f, 48.0f);
                j.cubicTo(-0.2827617f, 43.139736f, 0.2056765f, 38.12525f, 3.5527137E-15f, 33.0f);
                j.lineTo(3.5527137E-15f, 33.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(38.0f, 30.0f);
                j.cubicTo(44.67517f, 26.346733f, 50.804043f, 21.516281f, 58.0f, 19.0f);
                j.cubicTo(57.851246f, 28.388054f, 58.160683f, 37.786213f, 58.0f, 47.0f);
                j.cubicTo(57.891174f, 49.29643f, 55.934727f, 50.45857f, 54.0f, 51.0f);
                j.cubicTo(48.39841f, 54.85448f, 42.359375f, 58.148888f, 36.0f, 62.0f);
                j.cubicTo(34.743202f, 62.70649f, 32.896557f, 63.43409f, 31.0f, 64.0f);
                j.cubicTo(31.089836f, 54.935326f, 30.94011f, 45.870647f, 31.0f, 37.0f);
                j.cubicTo(30.690561f, 32.75365f, 35.2423f, 31.581406f, 38.0f, 30.0f);
                j.lineTo(38.0f, 30.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
