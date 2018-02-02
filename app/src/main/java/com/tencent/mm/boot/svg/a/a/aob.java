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

public final class aob extends c {
    private final int height = 60;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 60;
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
                a.setColor(-8534461);
                e = c.a(e, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 9.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(21.318575f, 1.5690247f);
                j.cubicTo(22.687094f, 0.6905305f, 24.47516f, 1.1697091f, 26.023485f, 1.0f);
                j.cubicTo(39.02942f, 1.1098118f, 52.045345f, 0.93011975f, 65.05128f, 1.089846f);
                j.cubicTo(67.09906f, 0.96006846f, 68.23783f, 3.2062182f, 67.95814f, 4.9931555f);
                j.cubicTo(67.92817f, 16.024246f, 68.05803f, 27.065321f, 67.8982f, 38.096413f);
                j.cubicTo(67.97811f, 40.06304f, 65.860405f, 41.26099f, 64.092316f, 40.95152f);
                j.cubicTo(50.70679f, 40.971485f, 37.31128f, 40.971485f, 23.925755f, 40.95152f);
                j.cubicTo(22.167656f, 41.251007f, 20.0f, 40.112957f, 20.089903f, 38.12636f);
                j.cubicTo(19.900108f, 27.424706f, 20.089903f, 16.703083f, 20.0f, 6.001427f);
                j.cubicTo(20.079914f, 4.464062f, 19.780237f, 2.517399f, 21.318575f, 1.5690247f);
                j.lineTo(21.318575f, 1.5690247f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.018742f, 5.804835f);
                j.cubicTo(0.949004f, 4.142785f, 1.198068f, 2.4706624f, 2.0149982f, 1.0f);
                j.cubicTo(7.245344f, 5.129942f, 11.828123f, 10.005288f, 16.918993f, 14.306472f);
                j.cubicTo(17.048506f, 18.728533f, 16.988731f, 23.15059f, 16.968805f, 27.57265f);
                j.cubicTo(11.917787f, 31.984638f, 7.2553067f, 36.829765f, 2.0050356f, 41.0f);
                j.cubicTo(0.60031426f, 38.5724f, 1.0984424f, 35.71166f, 1.0386671f, 33.05238f);
                j.cubicTo(1.0486296f, 23.966507f, 1.0685548f, 14.880634f, 1.018742f, 5.804835f);
                j.lineTo(1.018742f, 5.804835f);
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
