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

public final class ack extends c {
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
                e = c.a(e, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(21.18f, 1.22f);
                j.cubicTo(25.03f, 0.8f, 28.96f, 0.81f, 32.81f, 1.21f);
                j.cubicTo(33.5f, 2.08f, 34.14f, 2.99f, 34.72f, 3.94f);
                j.cubicTo(40.13f, 4.23f, 45.58f, 3.63f, 50.96f, 4.23f);
                j.cubicTo(53.77f, 5.13f, 52.76f, 8.77f, 53.12f, 11.0f);
                j.lineTo(0.88f, 11.0f);
                j.cubicTo(1.24f, 8.77f, 0.21f, 5.12f, 3.03f, 4.22f);
                j.cubicTo(8.41f, 3.64f, 13.84f, 4.19f, 19.24f, 3.96f);
                j.cubicTo(19.84f, 3.01f, 20.48f, 2.1f, 21.18f, 1.22f);
                j.lineTo(21.18f, 1.22f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(6.0f, 14.0f);
                j.lineTo(48.0f, 14.0f);
                j.cubicTo(47.98f, 28.03f, 48.04f, 42.06f, 47.98f, 56.09f);
                j.cubicTo(48.18f, 57.84f, 47.2f, 60.01f, 45.15f, 59.91f);
                j.cubicTo(33.4f, 60.12f, 21.64f, 59.97f, 9.89f, 59.98f);
                j.cubicTo(8.08f, 60.21f, 5.95f, 59.15f, 6.09f, 57.08f);
                j.cubicTo(5.87f, 42.73f, 6.07f, 28.36f, 6.0f, 14.0f);
                j.lineTo(6.0f, 14.0f);
                j.close();
                j.moveTo(15.36f, 23.28f);
                j.cubicTo(14.64f, 27.12f, 15.08f, 31.06f, 15.01f, 34.95f);
                j.cubicTo(15.14f, 39.95f, 14.69f, 44.97f, 15.19f, 49.95f);
                j.cubicTo(15.61f, 51.71f, 17.83f, 50.53f, 19.05f, 50.62f);
                j.cubicTo(18.78f, 41.78f, 19.33f, 32.91f, 18.8f, 24.09f);
                j.cubicTo(18.85f, 22.4f, 16.37f, 23.11f, 15.36f, 23.28f);
                j.lineTo(15.36f, 23.28f);
                j.close();
                j.moveTo(25.36f, 23.28f);
                j.cubicTo(24.6f, 27.47f, 25.12f, 31.76f, 25.01f, 36.0f);
                j.cubicTo(25.16f, 40.9f, 24.57f, 45.85f, 25.35f, 50.72f);
                j.cubicTo(26.43f, 51.06f, 27.52f, 51.07f, 28.61f, 50.73f);
                j.cubicTo(29.44f, 46.53f, 28.86f, 42.21f, 28.99f, 37.96f);
                j.cubicTo(28.84f, 33.07f, 29.43f, 28.12f, 28.64f, 23.27f);
                j.cubicTo(27.55f, 22.94f, 26.46f, 22.94f, 25.36f, 23.28f);
                j.lineTo(25.36f, 23.28f);
                j.close();
                j.moveTo(35.35f, 23.38f);
                j.cubicTo(34.54f, 28.19f, 35.18f, 33.12f, 35.01f, 37.98f);
                j.cubicTo(35.16f, 42.21f, 34.53f, 46.54f, 35.41f, 50.71f);
                j.cubicTo(36.48f, 51.07f, 37.55f, 51.08f, 38.63f, 50.73f);
                j.cubicTo(39.37f, 46.87f, 38.91f, 42.9f, 38.99f, 39.0f);
                j.cubicTo(38.86f, 34.03f, 39.31f, 29.03f, 38.82f, 24.07f);
                j.cubicTo(38.51f, 22.4f, 36.44f, 22.92f, 35.35f, 23.38f);
                j.lineTo(35.35f, 23.38f);
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
