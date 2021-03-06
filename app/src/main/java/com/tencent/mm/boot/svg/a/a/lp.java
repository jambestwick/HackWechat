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

public final class lp extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
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
                float[] a = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-4144960);
                Path j = c.j(looper);
                j.moveTo(16.0f, 2.032928f);
                j.cubicTo(21.182825f, -0.5018033f, 27.471985f, -0.5018033f, 32.973755f, 1.1269398f);
                j.cubicTo(32.993687f, 7.4179597f, 33.033554f, 13.70898f, 32.94385f, 20.0f);
                j.cubicTo(27.452051f, 14.116166f, 21.721043f, 8.446104f, 16.089703f, 2.6946049f);
                j.lineTo(16.0f, 2.032928f);
                j.lineTo(16.0f, 2.032928f);
                j.lineTo(16.0f, 2.032928f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4144960);
                j = c.j(looper);
                j.moveTo(35.044933f, 2.0f);
                j.cubicTo(40.505497f, 4.291358f, 45.505173f, 8.37037f, 48.0f, 13.723456f);
                j.cubicTo(44.0724f, 17.575308f, 40.054626f, 21.358025f, 36.297356f, 25.377777f);
                j.cubicTo(36.01681f, 25.535803f, 35.44571f, 25.851852f, 35.165165f, 26.0f);
                j.cubicTo(34.854565f, 18.019753f, 35.08501f, 10.0f, 35.044933f, 2.0f);
                j.lineTo(35.044933f, 2.0f);
                j.lineTo(35.044933f, 2.0f);
                j.lineTo(35.044933f, 2.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4144960);
                j = c.j(looper);
                j.moveTo(2.0f, 15.985457f);
                j.cubicTo(4.3267527f, 10.500481f, 8.496777f, 5.326352f, 14.046737f, 3.0f);
                j.cubicTo(18.307413f, 7.3619103f, 22.638597f, 11.643602f, 27.0f, 15.905239f);
                j.cubicTo(18.670025f, 16.085732f, 10.329976f, 15.945349f, 2.0f, 15.985457f);
                j.lineTo(2.0f, 15.985457f);
                j.lineTo(2.0f, 15.985457f);
                j.lineTo(2.0f, 15.985457f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4144960);
                j = c.j(looper);
                j.moveTo(49.04785f, 16.0f);
                j.cubicTo(50.593304f, 19.07393f, 50.989834f, 22.605059f, 51.0f, 26.0f);
                j.cubicTo(47.83793f, 24.025291f, 42.700947f, 24.778288f, 39.0f, 24.846382f);
                j.cubicTo(41.999393f, 22.443659f, 45.76377f, 17.663424f, 49.04785f, 16.0f);
                j.lineTo(49.04785f, 16.0f);
                j.lineTo(49.04785f, 16.0f);
                j.lineTo(49.04785f, 16.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4144960);
                j = c.j(looper);
                j.moveTo(1.1269572f, 18.018436f);
                j.cubicTo(7.4145637f, 17.989225f, 13.712394f, 17.998962f, 20.0f, 18.018436f);
                j.cubicTo(13.988435f, 23.636763f, 8.05866f, 29.547205f, 2.036871f, 35.0f);
                j.cubicTo(-0.22257785f, 29.634838f, -0.7133179f, 23.558867f, 1.1269572f, 18.018436f);
                j.lineTo(1.1269572f, 18.018436f);
                j.lineTo(1.1269572f, 18.018436f);
                j.lineTo(1.1269572f, 18.018436f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4144960);
                j = c.j(looper);
                j.moveTo(3.0f, 36.980186f);
                j.cubicTo(7.3834877f, 32.72422f, 11.636574f, 28.336838f, 15.939815f, 24.0f);
                j.cubicTo(16.020061f, 32.329964f, 16.020061f, 40.670036f, 15.939815f, 49.0f);
                j.cubicTo(10.493055f, 46.67489f, 5.357253f, 42.520016f, 3.0f, 36.980186f);
                j.lineTo(3.0f, 36.980186f);
                j.lineTo(3.0f, 36.980186f);
                j.lineTo(3.0f, 36.980186f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4144960);
                j = c.j(looper);
                j.moveTo(18.0f, 31.0f);
                j.cubicTo(21.24862f, 34.507523f, 24.574585f, 37.93347f, 27.832872f, 41.430798f);
                j.cubicTo(28.335636f, 44.612038f, 29.979282f, 47.487392f, 32.0f, 49.87332f);
                j.cubicTo(27.53315f, 51.514923f, 22.53453f, 51.229427f, 18.029005f, 49.87332f);
                j.cubicTo(17.990332f, 43.582214f, 18.05801f, 37.291107f, 18.0f, 31.0f);
                j.lineTo(18.0f, 31.0f);
                j.lineTo(18.0f, 31.0f);
                j.lineTo(18.0f, 31.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4802890);
                a = c.a(a, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 35.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                canvas.save();
                a2 = c.a(a2, looper);
                j = c.j(looper);
                j.moveTo(4.0f, 0.0f);
                j.cubicTo(3.8556423f, 0.70270455f, 3.6088626f, 2.7718356f, 3.464505f, 3.47454f);
                j.lineTo(3.464505f, 4.0f);
                j.cubicTo(2.6973581f, 3.2509282f, 1.2236129f, 2.1375713f, 0.0f, 0.8100131f);
                j.cubicTo(1.2236129f, 0.5459965f, 2.3443978f, 0.22751628f, 4.0f, 0.0f);
                j.lineTo(4.0f, 0.0f);
                j.lineTo(4.0f, 0.0f);
                j.lineTo(4.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1150121);
                e = c.a(a, 1.0f, 0.0f, 28.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(15.0f, 30.0f);
                j.cubicTo(23.284271f, 30.0f, 30.0f, 23.284271f, 30.0f, 15.0f);
                j.cubicTo(30.0f, 6.7157288f, 23.284271f, 0.0f, 15.0f, 0.0f);
                j.cubicTo(6.7157288f, 0.0f, 0.0f, 6.7157288f, 0.0f, 15.0f);
                j.cubicTo(0.0f, 23.284271f, 6.7157288f, 30.0f, 15.0f, 30.0f);
                j.lineTo(15.0f, 30.0f);
                j.lineTo(15.0f, 30.0f);
                j.lineTo(15.0f, 30.0f);
                j.close();
                j.moveTo(6.0f, 12.0f);
                j.lineTo(24.0f, 12.0f);
                j.lineTo(24.0f, 18.0f);
                j.lineTo(6.0f, 18.0f);
                j.lineTo(6.0f, 12.0f);
                j.lineTo(6.0f, 12.0f);
                j.lineTo(6.0f, 12.0f);
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
