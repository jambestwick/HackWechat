package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.contact.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.b$a;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class abc extends c {
    private final int height = b$a.CTRL_INDEX;
    private final int width = d.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return d.CTRL_INDEX;
            case 1:
                return b$a.CTRL_INDEX;
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
                float[] a2 = c.a(e, 1.0f, 0.0f, 1.333333f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                a3.setColor(WebView.NIGHT_MODE_COLOR);
                a3.setStrokeWidth(4.0f);
                Path j = c.j(looper);
                j.moveTo(2.0f, 16.0f);
                j.cubicTo(2.0f, 8.268013f, 8.268013f, 2.0f, 16.0f, 2.0f);
                j.lineTo(133.33333f, 2.0f);
                j.cubicTo(141.0653f, 2.0f, 147.33333f, 8.268013f, 147.33333f, 16.0f);
                j.lineTo(147.33333f, 250.66666f);
                j.cubicTo(147.33333f, 258.39865f, 141.0653f, 264.66666f, 133.33333f, 264.66666f);
                j.lineTo(16.0f, 264.66666f);
                j.cubicTo(8.268013f, 264.66666f, 2.0f, 258.39865f, 2.0f, 250.66666f);
                j.lineTo(2.0f, 16.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(a, looper);
                a4.setColor(WebView.NIGHT_MODE_COLOR);
                a4.setStrokeWidth(2.0f);
                Path j2 = c.j(looper);
                j2.moveTo(11.666667f, 29.0f);
                j2.lineTo(11.666667f, 232.33333f);
                j2.lineTo(137.66667f, 232.33333f);
                j2.lineTo(137.66667f, 29.0f);
                j2.lineTo(11.666667f, 29.0f);
                j2.close();
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(i2, looper);
                a4.setColor(WebView.NIGHT_MODE_COLOR);
                j2 = c.j(looper);
                j2.moveTo(65.333336f, 13.333333f);
                j2.lineTo(85.333336f, 13.333333f);
                j2.lineTo(85.333336f, 17.333332f);
                j2.lineTo(65.333336f, 17.333332f);
                j2.lineTo(65.333336f, 13.333333f);
                j2.close();
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1549736);
                e = c.a(a2, 1.0f, 0.0f, 38.0f, 0.0f, 1.0f, 90.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a5 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(74.55886f, 18.44114f);
                j.lineTo(73.35034f, 19.649662f);
                j.lineTo(38.0f, 55.0f);
                j.lineTo(2.6496618f, 19.649662f);
                j.lineTo(1.4411386f, 18.44114f);
                j.lineTo(0.23261555f, 17.232616f);
                j.cubicTo(9.399959f, 6.675522f, 22.920404f, 0.0f, 38.0f, 0.0f);
                j.cubicTo(53.079597f, 0.0f, 66.600044f, 6.675522f, 75.76739f, 17.232616f);
                j.lineTo(74.55886f, 18.44114f);
                j.close();
                j.moveTo(73.35034f, 19.649662f);
                j.cubicTo(64.80579f, 9.706631f, 52.138332f, 3.409091f, 38.0f, 3.409091f);
                j.cubicTo(23.861668f, 3.409091f, 11.194205f, 9.706631f, 2.6496618f, 19.649662f);
                j.lineTo(38.0f, 55.0f);
                j.lineTo(73.35034f, 19.649662f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a5);
                canvas.restore();
                canvas.save();
                a5 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(64.41209f, 28.587917f);
                j.lineTo(38.0f, 55.0f);
                j.lineTo(11.587917f, 28.587917f);
                j.cubicTo(17.821682f, 20.907948f, 27.337685f, 16.0f, 38.0f, 16.0f);
                j.cubicTo(48.662315f, 16.0f, 58.178318f, 20.907948f, 64.41209f, 28.587917f);
                j.close();
                j.moveTo(61.952404f, 31.047596f);
                j.cubicTo(56.358055f, 23.986908f, 47.707962f, 19.457626f, 38.0f, 19.457626f);
                j.cubicTo(28.292036f, 19.457626f, 19.641943f, 23.986908f, 14.047595f, 31.047596f);
                j.lineTo(38.0f, 55.0f);
                j.lineTo(61.952404f, 31.047596f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a5);
                canvas.restore();
                canvas.save();
                a5 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(24.464458f, 41.46446f);
                j.cubicTo(27.298983f, 36.97893f, 32.30161f, 34.0f, 38.0f, 34.0f);
                j.cubicTo(43.69839f, 34.0f, 48.701015f, 36.97893f, 51.53554f, 41.46446f);
                j.lineTo(38.0f, 55.0f);
                j.lineTo(24.464458f, 41.46446f);
                j.close();
                j.moveTo(26.967703f, 43.9677f);
                j.lineTo(38.0f, 55.0f);
                j.lineTo(49.0323f, 43.9677f);
                j.cubicTo(46.89699f, 40.070786f, 42.757057f, 37.42857f, 38.0f, 37.42857f);
                j.cubicTo(33.242943f, 37.42857f, 29.103008f, 40.070786f, 26.967703f, 43.9677f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a5);
                canvas.restore();
                canvas.save();
                a5 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(41.284134f, 51.715866f);
                j.lineTo(38.0f, 55.0f);
                j.lineTo(34.715866f, 51.715866f);
                j.cubicTo(35.438572f, 50.6787f, 36.640026f, 50.0f, 38.0f, 50.0f);
                j.cubicTo(39.359974f, 50.0f, 40.561428f, 50.6787f, 41.284134f, 51.715866f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a5);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
