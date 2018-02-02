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

public final class wg extends c {
    private final int height = 93;
    private final int width = 93;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 93;
            case 1:
                return 93;
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
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(79.564964f, 14.00827f);
                j.cubicTo(98.37848f, 31.740889f, 98.37848f, 61.25771f, 79.564964f, 78.99145f);
                j.cubicTo(61.702847f, 97.66952f, 31.972158f, 97.66952f, 14.110418f, 78.99145f);
                j.cubicTo(-4.7034726f, 61.25771f, -4.7034726f, 31.740889f, 14.110418f, 14.00827f);
                j.cubicTo(31.970652f, -4.669423f, 61.702847f, -4.669423f, 79.564964f, 14.00827f);
                j.close();
                j.moveTo(87.011604f, 47.88731f);
                j.cubicTo(87.011604f, 25.044458f, 69.258606f, 7.65122f, 48.775578f, 7.65122f);
                j.cubicTo(25.459192f, 7.65122f, 7.7072563f, 25.044458f, 7.7072563f, 47.88731f);
                j.cubicTo(7.7072563f, 67.95526f, 25.460253f, 85.3485f, 45.94328f, 85.3485f);
                j.cubicTo(69.258606f, 85.3485f, 87.011604f, 67.95526f, 87.011604f, 47.88731f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(e, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 29.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.0201076f, 10.956513f);
                j.lineTo(10.898551f, 10.956513f);
                j.lineTo(23.47826f, 41.739132f);
                j.lineTo(0.61864334f, 11.767624f);
                j.cubicTo(0.4495329f, 11.545901f, 0.4921835f, 11.229069f, 0.7139061f, 11.059958f);
                j.cubicTo(0.80188197f, 10.992858f, 0.90946317f, 10.956513f, 1.0201076f, 10.956513f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(45.936413f, 10.956513f);
                j.lineTo(36.289856f, 10.956513f);
                j.lineTo(23.47826f, 41.739132f);
                j.lineTo(46.33788f, 11.767624f);
                j.cubicTo(46.50699f, 11.545901f, 46.464336f, 11.229069f, 46.242615f, 11.059958f);
                j.cubicTo(46.15464f, 10.992858f, 46.04706f, 10.956513f, 45.936413f, 10.956513f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                i2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(14.347826f, 10.956513f);
                j2.lineTo(32.608696f, 10.956513f);
                j2.lineTo(23.47826f, 41.739132f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(11.146245f, 7.826087f);
                j.lineTo(18.26087f, 0.0f);
                j.lineTo(10.837229f, -9.992007E-16f);
                j.cubicTo(10.729838f, -1.361002E-15f, 10.625245f, 0.034240846f, 10.538644f, 0.097747825f);
                j.lineTo(1.2437316f, 6.914017f);
                j.cubicTo(1.0188628f, 7.078921f, 0.97025156f, 7.394894f, 1.1351553f, 7.619763f);
                j.cubicTo(1.2302675f, 7.749461f, 1.3814809f, 7.826087f, 1.5423163f, 7.826087f);
                j.lineTo(11.146245f, 7.826087f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                i2 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(20.869566f, 0.0f);
                j2.lineTo(26.086956f, 0.0f);
                j2.lineTo(32.608696f, 7.826087f);
                j2.lineTo(14.347826f, 7.826087f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(36.32361f, 7.826087f);
                j.lineTo(28.695652f, 0.0f);
                j.lineTo(36.386032f, 1.2212453E-15f);
                j.cubicTo(36.49554f, 1.241362E-15f, 36.60208f, 0.03560397f, 36.68959f, 0.101443335f);
                j.lineTo(45.749187f, 6.9177127f);
                j.cubicTo(45.972015f, 7.085364f, 46.016747f, 7.40191f, 45.849094f, 7.6247377f);
                j.cubicTo(45.753708f, 7.7515154f, 45.604282f, 7.826087f, 45.44563f, 7.826087f);
                j.lineTo(36.32361f, 7.826087f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
