package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class fw extends c {
    private final int height = 54;
    private final int width = 54;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(26.0f, 0.0f);
                j.cubicTo(12.533542f, 0.5350773f, 0.82137287f, 11.880697f, 0.0f, 25.0f);
                j.lineTo(0.0f, 0.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(29.0f, 0.0f);
                j.lineTo(54.0f, 0.0f);
                j.lineTo(54.0f, 26.0f);
                j.cubicTo(53.438755f, 12.482031f, 42.08586f, 0.7210938f, 29.0f, 0.0f);
                j.lineTo(29.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(21.470905f, 3.7110238f);
                j.cubicTo(33.007473f, 0.630928f, 45.994865f, 7.8811536f, 49.63694f, 19.211506f);
                j.cubicTo(52.53859f, 26.971746f, 50.667526f, 36.10203f, 45.3545f, 42.382225f);
                j.cubicTo(40.441704f, 48.312412f, 32.5272f, 51.622513f, 24.85283f, 50.902493f);
                j.cubicTo(18.869425f, 50.292473f, 13.106144f, 47.452385f, 9.113872f, 42.92224f);
                j.cubicTo(3.6507616f, 36.822052f, 1.4795256f, 27.781773f, 4.1210294f, 19.961529f);
                j.cubicTo(6.492379f, 11.971281f, 13.366292f, 5.591082f, 21.470905f, 3.7110238f);
                j.lineTo(21.470905f, 3.7110238f);
                j.close();
                j.moveTo(19.537832f, 16.591116f);
                j.cubicTo(18.1471f, 18.38323f, 18.035437f, 20.670403f, 17.781652f, 22.809057f);
                j.cubicTo(18.918602f, 22.82886f, 20.065702f, 22.848661f, 21.20265f, 22.858562f);
                j.cubicTo(21.334618f, 19.967419f, 22.654291f, 16.353489f, 26.095592f, 16.046553f);
                j.cubicTo(30.470816f, 15.0168295f, 33.912117f, 20.007023f, 31.820944f, 23.729868f);
                j.cubicTo(29.039478f, 28.63095f, 22.49187f, 29.720081f, 19.334806f, 34.32413f);
                j.cubicTo(17.852713f, 36.26476f, 17.46696f, 38.68065f, 17.0f, 40.997524f);
                j.cubicTo(23.273523f, 40.997524f, 29.536894f, 41.007427f, 35.810417f, 40.987625f);
                j.lineTo(35.810417f, 38.03707f);
                j.cubicTo(30.856567f, 37.997467f, 25.902718f, 38.076675f, 20.948868f, 37.987568f);
                j.cubicTo(23.303976f, 31.789427f, 31.455496f, 31.096346f, 34.734375f, 25.611092f);
                j.cubicTo(36.866154f, 22.195185f, 36.338287f, 17.11588f, 32.896984f, 14.69009f);
                j.cubicTo(28.877058f, 11.957365f, 22.41066f, 12.501929f, 19.537832f, 16.591116f);
                j.lineTo(19.537832f, 16.591116f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(0.0f, 28.0f);
                j.cubicTo(0.554895f, 41.466824f, 11.880697f, 53.177986f, 25.0f, 54.0f);
                j.lineTo(0.0f, 54.0f);
                j.lineTo(0.0f, 28.0f);
                j.lineTo(0.0f, 28.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(28.0f, 54.0f);
                j.cubicTo(41.516758f, 53.468296f, 53.280594f, 42.105553f, 54.0f, 29.0f);
                j.lineTo(54.0f, 54.0f);
                j.lineTo(28.0f, 54.0f);
                j.lineTo(28.0f, 54.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                i2 = c.a(i2, looper);
                i2.setColor(-16139513);
                canvas.save();
                a = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(25.64f, 0.0f);
                j.lineTo(28.61f, 0.0f);
                j.cubicTo(41.9f, 0.71f, 53.43f, 12.29f, 54.0f, 25.6f);
                j.lineTo(54.0f, 28.61f);
                j.cubicTo(53.29f, 41.92f, 41.68f, 53.46f, 28.34f, 54.0f);
                j.lineTo(25.23f, 54.0f);
                j.cubicTo(11.99f, 53.19f, 0.56f, 41.65f, 0.0f, 28.38f);
                j.lineTo(0.0f, 25.23f);
                j.cubicTo(0.81f, 11.99f, 12.36f, 0.54f, 25.64f, 0.0f);
                j.lineTo(25.64f, 0.0f);
                j.close();
                j.moveTo(21.470905f, 3.7110238f);
                j.cubicTo(13.366292f, 5.591082f, 6.492379f, 11.971281f, 4.1210294f, 19.961529f);
                j.cubicTo(1.4795256f, 27.781773f, 3.6507616f, 36.822052f, 9.113872f, 42.92224f);
                j.cubicTo(13.106144f, 47.452385f, 18.869425f, 50.292473f, 24.85283f, 50.902493f);
                j.cubicTo(32.5272f, 51.622513f, 40.441704f, 48.312412f, 45.3545f, 42.382225f);
                j.cubicTo(50.667526f, 36.10203f, 52.53859f, 26.971746f, 49.63694f, 19.211506f);
                j.cubicTo(45.994865f, 7.8811536f, 33.007473f, 0.630928f, 21.470905f, 3.7110238f);
                j.lineTo(21.470905f, 3.7110238f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(19.537832f, 16.591116f);
                j.cubicTo(22.41066f, 12.501929f, 28.877058f, 11.957365f, 32.896984f, 14.69009f);
                j.cubicTo(36.338287f, 17.11588f, 36.866154f, 22.195185f, 34.734375f, 25.611092f);
                j.cubicTo(31.455496f, 31.096346f, 23.303976f, 31.789427f, 20.948868f, 37.987568f);
                j.cubicTo(25.902718f, 38.076675f, 30.856567f, 37.997467f, 35.810417f, 38.03707f);
                j.lineTo(35.810417f, 40.987625f);
                j.cubicTo(29.536894f, 41.007427f, 23.273523f, 40.997524f, 17.0f, 40.997524f);
                j.cubicTo(17.46696f, 38.68065f, 17.852713f, 36.26476f, 19.334806f, 34.32413f);
                j.cubicTo(22.49187f, 29.720081f, 29.039478f, 28.63095f, 31.820944f, 23.729868f);
                j.cubicTo(33.912117f, 20.007023f, 30.470816f, 15.0168295f, 26.095592f, 16.046553f);
                j.cubicTo(22.654291f, 16.353489f, 21.334618f, 19.967419f, 21.20265f, 22.858562f);
                j.cubicTo(20.065702f, 22.848661f, 18.918602f, 22.82886f, 17.781652f, 22.809057f);
                j.cubicTo(18.035437f, 20.670403f, 18.1471f, 18.38323f, 19.537832f, 16.591116f);
                j.lineTo(19.537832f, 16.591116f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}