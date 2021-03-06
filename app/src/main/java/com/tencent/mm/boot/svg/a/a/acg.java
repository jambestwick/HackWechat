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

public final class acg extends c {
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
                j.cubicTo(23.772043f, 2.8152332f, 26.37612f, 0.7137211f, 30.0f, 0.0f);
                j.cubicTo(32.078842f, 0.30729657f, 34.147972f, 1.9726459f, 36.0f, 3.0f);
                j.cubicTo(42.838318f, 7.038083f, 49.76233f, 10.289479f, 56.0f, 15.0f);
                j.cubicTo(49.126453f, 18.992912f, 41.839077f, 22.64082f, 35.0f, 27.0f);
                j.cubicTo(32.47248f, 28.11268f, 29.555513f, 30.144804f, 27.0f, 28.0f);
                j.cubicTo(18.927252f, 23.681664f, 10.832413f, 19.369598f, 3.0f, 15.0f);
                j.cubicTo(8.672443f, 10.676078f, 14.960579f, 7.7418914f, 21.0f, 4.0f);
                j.lineTo(21.0f, 4.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(-3.5527137E-15f, 19.0f);
                j.cubicTo(3.0177057f, 19.327692f, 5.4976025f, 21.134958f, 8.0f, 23.0f);
                j.cubicTo(13.1464405f, 25.464455f, 18.205828f, 28.383886f, 23.0f, 31.0f);
                j.cubicTo(24.908522f, 32.1573f, 26.940243f, 33.259537f, 27.0f, 35.0f);
                j.cubicTo(27.139431f, 44.58971f, 26.790852f, 53.794853f, 27.0f, 63.0f);
                j.cubicTo(22.179638f, 61.848114f, 18.315382f, 58.521553f, 14.0f, 56.0f);
                j.cubicTo(9.819993f, 53.824646f, 5.3880486f, 51.788986f, 1.0f, 49.0f);
                j.cubicTo(-0.059756547f, 47.965923f, 0.12947252f, 45.969986f, -3.5527137E-15f, 44.0f);
                j.cubicTo(0.01991885f, 35.930714f, 0.14939137f, 27.460392f, -3.5527137E-15f, 19.0f);
                j.lineTo(-3.5527137E-15f, 19.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(53.0f, 21.0f);
                j.cubicTo(54.20546f, 20.188654f, 56.05791f, 19.43584f, 58.0f, 19.0f);
                j.cubicTo(57.83069f, 27.825754f, 58.039837f, 36.65151f, 58.0f, 45.0f);
                j.cubicTo(58.059757f, 47.319675f, 57.213207f, 49.122467f, 56.0f, 50.0f);
                j.cubicTo(49.235706f, 53.718594f, 42.702324f, 57.056732f, 36.0f, 61.0f);
                j.cubicTo(34.754704f, 61.831158f, 32.90225f, 62.534443f, 31.0f, 63.0f);
                j.cubicTo(31.109554f, 54.511032f, 31.019918f, 46.02206f, 31.0f, 38.0f);
                j.cubicTo(31.039837f, 35.740208f, 31.029879f, 33.521385f, 33.0f, 33.0f);
                j.cubicTo(39.2962f, 28.578568f, 46.02877f, 25.111662f, 53.0f, 21.0f);
                j.lineTo(53.0f, 21.0f);
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
