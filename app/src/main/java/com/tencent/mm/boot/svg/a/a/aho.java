package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aho extends c {
    private final int height = JsApiSetClipboardData.CTRL_INDEX;
    private final int width = JsApiSetClipboardData.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiSetClipboardData.CTRL_INDEX;
            case 1:
                return JsApiSetClipboardData.CTRL_INDEX;
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
                a.setColor(-14187817);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 37.0f, 0.0f, 1.0f, 39.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(72.0767f, 82.22588f);
                j.cubicTo(83.53856f, 73.9851f, 91.0f, 60.553818f, 91.0f, 45.38426f);
                j.cubicTo(91.0f, 20.319225f, 70.62896f, -3.5527137E-14f, 45.5f, -3.5527137E-14f);
                j.cubicTo(20.371044f, -3.5527137E-14f, -2.1316282E-14f, 20.319225f, -2.1316282E-14f, 45.38426f);
                j.cubicTo(-2.1316282E-14f, 61.038643f, 7.9460006f, 74.84186f, 20.034418f, 83.0f);
                j.lineTo(22.1966f, 79.985435f);
                j.cubicTo(11.048177f, 72.50055f, 3.7142856f, 59.796688f, 3.7142856f, 45.38426f);
                j.cubicTo(3.7142856f, 22.36535f, 22.422388f, 3.7048376f, 45.5f, 3.7048376f);
                j.cubicTo(68.577614f, 3.7048376f, 87.28571f, 22.36535f, 87.28571f, 45.38426f);
                j.cubicTo(87.28571f, 59.35643f, 80.393036f, 71.722824f, 69.81427f, 79.285f);
                j.lineTo(72.0767f, 82.22588f);
                j.close();
                j.moveTo(66.62715f, 75.14214f);
                j.cubicTo(75.9622f, 68.53627f, 82.054f, 57.669865f, 82.054f, 45.38426f);
                j.cubicTo(82.054f, 25.247396f, 65.68822f, 8.923243f, 45.5f, 8.923243f);
                j.cubicTo(25.311783f, 8.923243f, 8.945999f, 25.247396f, 8.945999f, 45.38426f);
                j.cubicTo(8.945999f, 58.04734f, 15.417901f, 69.202675f, 25.242413f, 75.7389f);
                j.lineTo(27.490881f, 72.604034f);
                j.cubicTo(18.643457f, 66.76842f, 12.807601f, 56.756123f, 12.807601f, 45.38426f);
                j.cubicTo(12.807601f, 27.374676f, 27.444487f, 12.7750225f, 45.5f, 12.7750225f);
                j.cubicTo(63.55551f, 12.7750225f, 78.1924f, 27.374676f, 78.1924f, 45.38426f);
                j.cubicTo(78.1924f, 56.424984f, 72.69147f, 66.184166f, 64.27428f, 72.083694f);
                j.lineTo(66.62715f, 75.14214f);
                j.close();
                j.moveTo(60.846767f, 67.62836f);
                j.cubicTo(67.92764f, 62.75864f, 72.5687f, 54.61206f, 72.5687f, 45.38426f);
                j.cubicTo(72.5687f, 30.472656f, 60.44963f, 18.384415f, 45.5f, 18.384415f);
                j.cubicTo(30.55037f, 18.384415f, 18.4313f, 30.472656f, 18.4313f, 45.38426f);
                j.cubicTo(18.4313f, 54.875706f, 23.341345f, 63.22327f, 30.766079f, 68.03768f);
                j.lineTo(33.130417f, 64.741264f);
                j.cubicTo(26.732042f, 60.664852f, 22.489536f, 53.51874f, 22.489536f, 45.38426f);
                j.cubicTo(22.489536f, 32.70826f, 32.79167f, 22.43233f, 45.5f, 22.43233f);
                j.cubicTo(58.20833f, 22.43233f, 68.51047f, 32.70826f, 68.51047f, 45.38426f);
                j.cubicTo(68.51047f, 53.303806f, 64.48919f, 60.286526f, 58.372215f, 64.41174f);
                j.lineTo(60.846767f, 67.62836f);
                j.close();
                j.moveTo(54.48061f, 59.353138f);
                j.cubicTo(59.084618f, 56.40215f, 62.134594f, 51.248478f, 62.134594f, 45.38426f);
                j.cubicTo(62.134594f, 36.220596f, 54.68703f, 28.79198f, 45.5f, 28.79198f);
                j.cubicTo(36.31297f, 28.79198f, 28.865408f, 36.220596f, 28.865408f, 45.38426f);
                j.cubicTo(28.865408f, 51.386845f, 32.06101f, 56.644955f, 36.847862f, 59.558327f);
                j.lineTo(38.943947f, 56.635918f);
                j.cubicTo(35.06329f, 54.381386f, 32.454987f, 50.18665f, 32.454987f, 45.38426f);
                j.cubicTo(32.454987f, 38.198025f, 38.295437f, 32.37243f, 45.5f, 32.37243f);
                j.cubicTo(52.704563f, 32.37243f, 58.545013f, 38.198025f, 58.545013f, 45.38426f);
                j.cubicTo(58.545013f, 50.091446f, 56.0391f, 54.214832f, 52.285336f, 56.499557f);
                j.lineTo(54.48061f, 59.353138f);
                j.close();
                j.moveTo(49.096928f, 52.35502f);
                j.cubicTo(51.627728f, 51.053127f, 53.35822f, 48.42027f, 53.35822f, 45.38426f);
                j.cubicTo(53.35822f, 41.055325f, 49.839973f, 37.54603f, 45.5f, 37.54603f);
                j.cubicTo(41.160027f, 37.54603f, 37.64178f, 41.055325f, 37.64178f, 45.38426f);
                j.cubicTo(37.64178f, 48.452805f, 39.40956f, 51.10951f, 41.984715f, 52.39641f);
                j.lineTo(44.138638f, 49.39336f);
                j.cubicTo(42.463356f, 48.82757f, 41.257534f, 47.246376f, 41.257534f, 45.38426f);
                j.cubicTo(41.257534f, 43.047173f, 43.15695f, 41.152588f, 45.5f, 41.152588f);
                j.cubicTo(47.84305f, 41.152588f, 49.742466f, 43.047173f, 49.742466f, 45.38426f);
                j.cubicTo(49.742466f, 47.258987f, 48.520252f, 48.848984f, 46.82725f, 49.40472f);
                j.lineTo(49.096928f, 52.35502f);
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
