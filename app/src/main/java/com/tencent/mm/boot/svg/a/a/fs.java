package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class fs extends c {
    private final int height = JsApiSetAudioState.CTRL_INDEX;
    private final int width = 476;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 476;
            case 1:
                return JsApiSetAudioState.CTRL_INDEX;
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
                e = c.a(e, -1.0f, 0.0f, 473.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-13158344);
                float[] a2 = c.a(e, -1.0f, 0.0f, 470.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(304.0f, 278.731f);
                j.lineTo(304.0f, 284.001f);
                j.lineTo(166.0f, 284.001f);
                j.lineTo(166.0f, 278.731f);
                j.lineTo(219.0f, 273.731f);
                j.lineTo(219.0f, 240.001f);
                j.lineTo(251.0f, 240.001f);
                j.lineTo(251.0f, 273.731f);
                j.lineTo(304.0f, 278.731f);
                j.close();
                j.moveTo(254.0f, 240.0f);
                j.lineTo(366.985f, 240.0f);
                j.lineTo(366.985f, 237.001f);
                j.lineTo(254.0f, 237.001f);
                j.lineTo(216.0f, 237.0f);
                j.lineTo(62.006f, 237.001f);
                j.cubicTo(55.938f, 237.001f, 51.0f, 232.063f, 51.0f, 225.994f);
                j.lineTo(51.0f, 14.007f);
                j.cubicTo(51.0f, 7.938f, 55.938f, 3.001f, 62.006f, 3.001f);
                j.lineTo(407.993f, 3.001f);
                j.cubicTo(414.063f, 3.001f, 419.0f, 7.938f, 419.0f, 14.007f);
                j.lineTo(419.0f, 97.39f);
                j.lineTo(422.0f, 97.39f);
                j.lineTo(422.0f, 14.007f);
                j.cubicTo(422.0f, 6.266f, 415.729f, 0.0f, 407.993f, 0.0f);
                j.lineTo(62.007f, 0.0f);
                j.cubicTo(54.276f, 0.0f, 48.0f, 6.271f, 48.0f, 14.007f);
                j.lineTo(48.0f, 225.994f);
                j.cubicTo(48.0f, 233.735f, 54.271f, 240.0f, 62.007f, 240.0f);
                j.lineTo(216.0f, 240.0f);
                j.lineTo(216.0f, 271.0f);
                j.lineTo(163.0f, 276.0f);
                j.lineTo(163.0f, 287.0f);
                j.lineTo(307.0f, 287.0f);
                j.lineTo(307.0f, 276.0f);
                j.lineTo(254.0f, 271.0f);
                j.lineTo(254.0f, 240.0f);
                j.close();
                j.moveTo(365.9854f, 226.0006f);
                j.lineTo(62.0004f, 226.0006f);
                j.lineTo(62.0004f, 14.0006f);
                j.lineTo(408.0004f, 14.0006f);
                j.lineTo(408.0004f, 95.3906f);
                j.cubicTo(408.0004f, 95.3906f, 408.9994f, 97.02239f, 408.9994f, 95.01775f);
                j.lineTo(408.9994f, 13.0006f);
                j.lineTo(60.9994f, 13.0006f);
                j.lineTo(60.9994f, 227.0006f);
                j.lineTo(365.9854f, 227.0006f);
                j.lineTo(365.9854f, 226.0006f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(a2, -1.0f, 0.0f, 106.0f, 0.0f, 1.0f, 96.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                a4.setColor(-13092808);
                j = c.j(looper);
                j.moveTo(3.0f, 183.006f);
                j.lineTo(3.0f, 7.994f);
                j.cubicTo(3.0f, 5.24f, 5.243f, 3.0f, 8.0f, 3.0f);
                j.lineTo(98.0f, 3.0f);
                j.cubicTo(100.757f, 3.0f, 103.0f, 5.24f, 103.0f, 7.994f);
                j.lineTo(103.0f, 183.006f);
                j.cubicTo(103.0f, 185.76f, 100.757f, 188.0f, 98.0f, 188.0f);
                j.lineTo(8.0f, 188.0f);
                j.cubicTo(5.243f, 188.0f, 3.0f, 185.76f, 3.0f, 183.006f);
                j.lineTo(3.0f, 183.006f);
                j.close();
                j.moveTo(98.0f, 191.0f);
                j.cubicTo(102.418f, 191.0f, 106.0f, 187.418f, 106.0f, 183.006f);
                j.lineTo(106.0f, 7.994f);
                j.cubicTo(106.0f, 3.579f, 102.412f, 0.0f, 98.0f, 0.0f);
                j.lineTo(8.0f, 0.0f);
                j.cubicTo(3.582f, 0.0f, 0.0f, 3.582f, 0.0f, 7.994f);
                j.lineTo(0.0f, 183.006f);
                j.cubicTo(0.0f, 187.421f, 3.588f, 191.0f, 8.0f, 191.0f);
                j.lineTo(98.0f, 191.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                e = c.a(a3, 1.0f, 0.0f, 35.0f, 0.0f, 1.0f, 77.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.restore();
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 10.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-13092808);
                Path j2 = c.j(looper);
                j2.moveTo(1.0f, 157.0f);
                j2.lineTo(91.0f, 157.0f);
                j2.lineTo(91.0f, 11.0f);
                j2.lineTo(1.0f, 11.0f);
                j2.lineTo(1.0f, 157.0f);
                j2.close();
                j2.moveTo(0.0f, 158.0f);
                j2.lineTo(92.0f, 158.0f);
                j2.lineTo(92.0f, 10.0f);
                j2.lineTo(0.0f, 10.0f);
                j2.lineTo(0.0f, 158.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i3);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-372399);
                a2 = c.a(e, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 52.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a5 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(56.0f, 28.345678f);
                j.cubicTo(56.0f, 12.535704f, 43.464294f, 0.0f, 27.654322f, 0.0f);
                j.cubicTo(12.535704f, 0.0f, 0.0f, 12.535704f, 0.0f, 28.345678f);
                j.cubicTo(0.0f, 43.464294f, 12.535704f, 56.0f, 27.654322f, 56.0f);
                j.cubicTo(43.464294f, 56.0f, 56.0f, 43.464294f, 56.0f, 28.345678f);
                j.close();
                j.moveTo(53.0f, 28.308641f);
                j.cubicTo(53.0f, 14.192593f, 41.807407f, 3.0f, 27.691359f, 3.0f);
                j.cubicTo(14.192593f, 3.0f, 3.0f, 14.192593f, 3.0f, 28.308641f);
                j.cubicTo(3.0f, 41.807407f, 14.192593f, 53.0f, 27.691359f, 53.0f);
                j.cubicTo(41.807407f, 53.0f, 53.0f, 41.807407f, 53.0f, 28.308641f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a5);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(28.745098f, 15.0f);
                j.cubicTo(27.229023f, 15.0f, 26.05724f, 16.23637f, 26.127232f, 17.748198f);
                j.lineTo(26.822258f, 32.76079f);
                j.cubicTo(26.873497f, 33.867523f, 27.801048f, 34.764706f, 28.916443f, 34.764706f);
                j.lineTo(28.573753f, 34.764706f);
                j.cubicTo(29.679102f, 34.764706f, 30.616858f, 33.864098f, 30.667936f, 32.76079f);
                j.lineTo(31.362965f, 17.748198f);
                j.cubicTo(31.433233f, 16.23041f, 30.25809f, 15.0f, 28.745098f, 15.0f);
                j.close();
                j.moveTo(28.745098f, 43.54902f);
                j.cubicTo(30.261173f, 43.54902f, 31.490196f, 42.319996f, 31.490196f, 40.80392f);
                j.cubicTo(31.490196f, 39.287846f, 30.261173f, 38.058823f, 28.745098f, 38.058823f);
                j.cubicTo(27.229023f, 38.058823f, 26.0f, 39.287846f, 26.0f, 40.80392f);
                j.cubicTo(26.0f, 42.319996f, 27.229023f, 43.54902f, 28.745098f, 43.54902f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint a6 = c.a(i2, looper);
                a6.setColor(-13092808);
                Path j3 = c.j(looper);
                j3.moveTo(39.0f, 3.0f);
                j3.lineTo(53.0f, 3.0f);
                j3.lineTo(53.0f, 0.0f);
                j3.lineTo(39.0f, 0.0f);
                j3.close();
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                WeChatSVGRenderC2Java.setFillType(j3, 2);
                canvas.drawPath(j3, a6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-372399);
                e = c.a(a2, 1.0f, 0.0f, 185.0f, 0.0f, 1.0f, 66.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a7 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(100.0f, 50.617283f);
                j.cubicTo(100.0f, 22.385185f, 77.614815f, 0.0f, 49.382717f, 0.0f);
                j.cubicTo(22.385185f, 0.0f, 0.0f, 22.385185f, 0.0f, 50.617283f);
                j.cubicTo(0.0f, 77.614815f, 22.385185f, 100.0f, 49.382717f, 100.0f);
                j.cubicTo(77.614815f, 100.0f, 100.0f, 77.614815f, 100.0f, 50.617283f);
                j.close();
                j.moveTo(97.0f, 50.580246f);
                j.cubicTo(97.0f, 24.042074f, 75.957924f, 3.0f, 49.419754f, 3.0f);
                j.cubicTo(24.042074f, 3.0f, 3.0f, 24.042074f, 3.0f, 50.580246f);
                j.cubicTo(3.0f, 75.957924f, 24.042074f, 97.0f, 49.419754f, 97.0f);
                j.cubicTo(75.957924f, 97.0f, 97.0f, 75.957924f, 97.0f, 50.580246f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a7);
                canvas.restore();
                canvas.save();
                a7 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(49.02918f, 25.490196f);
                j.cubicTo(46.85807f, 25.490196f, 45.17907f, 27.240437f, 45.27915f, 29.402136f);
                j.lineTo(46.639496f, 58.785625f);
                j.cubicTo(46.690598f, 59.88947f, 47.627117f, 60.784313f, 48.72854f, 60.784313f);
                j.lineTo(51.27146f, 60.784313f);
                j.cubicTo(52.374104f, 60.784313f, 53.30918f, 59.89422f, 53.360504f, 58.785625f);
                j.lineTo(54.72085f, 29.402136f);
                j.cubicTo(54.820877f, 27.24163f, 53.149216f, 25.490196f, 50.97082f, 25.490196f);
                j.lineTo(49.02918f, 25.490196f);
                j.close();
                j.moveTo(50.0f, 76.47059f);
                j.cubicTo(52.70728f, 76.47059f, 54.901962f, 74.2759f, 54.901962f, 71.56863f);
                j.cubicTo(54.901962f, 68.86135f, 52.70728f, 66.666664f, 50.0f, 66.666664f);
                j.cubicTo(47.29272f, 66.666664f, 45.098038f, 68.86135f, 45.098038f, 71.56863f);
                j.cubicTo(45.098038f, 74.2759f, 47.29272f, 76.47059f, 50.0f, 76.47059f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}