package com.tencent.mm.plugin.mmsight;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class d {
    private static float oqr = 0.01f;
    private static boolean oqs = false;
    private static int oqt = 0;
    private static int oqu = 0;
    private static ConcurrentHashMap<String, Long> oqv = new ConcurrentHashMap();

    private static class a implements Comparator<Size> {
        private a() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            return i2 > i ? 1 : 0;
        }
    }

    public static void a(com.tencent.mm.plugin.mmsight.model.a.d dVar, SightParams sightParams) {
        String str = sightParams.oqM;
        String str2 = sightParams.oqK;
        String str3 = sightParams.oqL;
        if (bh.ov(str) || bh.ov(str2) || bh.ov(str3)) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
            Object[] objArr = new Object[2];
            objArr[0] = str;
            int i = oqt;
            oqt = i + 1;
            objArr[1] = Integer.valueOf(i);
            File file = new File(String.format("%s/tempvideo%s.mp4", objArr));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(file.getAbsolutePath() + ".remux");
            if (file2.exists()) {
                file2.delete();
            }
            file2 = new File(file.getAbsoluteFile() + ".thumb");
            if (file2.exists()) {
                file2.delete();
            }
            file2 = new File(file.getAbsoluteFile() + ".soundmp4");
            if (file2.exists()) {
                file2.delete();
            }
            i.A(new 1(oqt - 3, str));
            str = file.getAbsolutePath();
            x.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathDefault, filePath: %s, thumbPath: %s", str, bh.az(str, "") + ".thumb");
            dVar.setFilePath(str);
            dVar.Fi(str2);
        } else {
            x.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathByTalker, fileName: %s, filePath: %s, thumbPath: %s", str, str2, str3);
            dVar.setFilePath(str2);
            dVar.Fi(str3);
        }
        x.i("MicroMsg.MMSightUtil", "captureImagePath %s", CaptureMMProxy.getInstance().getSubCoreImageFullPath("capture_" + System.currentTimeMillis()));
        dVar.Fj(str);
    }

    public static void gB(boolean z) {
        oqs = z;
    }

    public static Point db(Context context) {
        Point fz = ae.fz(context);
        if (!oqs && ae.fy(context)) {
            fz.y -= ae.fx(context);
        }
        return fz;
    }

    public static Point aZP() {
        return ae.fz(ac.getContext());
    }

    public static boolean a(Context context, Point point, boolean z) {
        Point db = db(context);
        x.i("MicroMsg.MMSightUtil", "checkIfNeedUsePreviewLarge: previewSize: %s, displaySize: %s, displayRatio: %s, previewRatio: %s, diff: %s", point, db, Float.valueOf(((float) db.y) / ((float) db.x)), Float.valueOf(z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x)), Float.valueOf(Math.abs((((float) db.y) / ((float) db.x)) - (z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x)))));
        if (Math.abs((((float) db.y) / ((float) db.x)) - (z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x))) > oqr) {
            return true;
        }
        return false;
    }

    public static Point a(Point point, Point point2, boolean z) {
        return a(point, point2, z, false);
    }

    public static Point a(Point point, Point point2, boolean z, boolean z2) {
        int i = point2.x;
        int i2 = point2.y;
        int i3 = z ? point.y : point.x;
        int i4 = z ? point.x : point.y;
        int i5 = (int) (((float) i) * (((float) i4) / ((float) i3)));
        if (i5 % 2 != 0) {
            i5--;
        }
        i3 = (int) ((((float) i3) / ((float) i4)) * ((float) i2));
        if (z2) {
            i4 = cM(i5, point2.y);
        } else {
            i4 = i5;
        }
        x.i("MicroMsg.MMSightUtil", "getCropPreviewSize, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", point2, point, Integer.valueOf(i), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i3), Boolean.valueOf(z));
        if (i4 <= point2.y && i <= point2.x) {
            return new Point(i, i4);
        }
        x.i("MicroMsg.MMSightUtil", "can not adapt to screen");
        return null;
    }

    public static Point b(Point point, Point point2, boolean z) {
        return b(point, point2, z, false);
    }

    public static Point b(Point point, Point point2, boolean z, boolean z2) {
        int i = point2.x;
        int i2 = point2.y;
        int i3 = (int) ((((float) (z ? point.y : point.x)) / ((float) (z ? point.x : point.y))) * ((float) i2));
        if (i3 % 2 != 0) {
            i3++;
        }
        if (z2) {
            i3 = cM(i3, point2.y);
        }
        x.i("MicroMsg.MMSightUtil", "getCropPreviewSize, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", point2, point, Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z));
        if (i3 <= point2.x) {
            return new Point(i3, i2);
        }
        x.i("MicroMsg.MMSightUtil", "can not adapt to screen");
        return null;
    }

    public static String bg(List<Size> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + ";");
        }
        return stringBuffer.toString();
    }

    public static String bh(List<Size> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + " " + ((((double) size.height) * 1.0d) / ((double) size.width)) + "||");
        }
        return stringBuffer.toString();
    }

    public static ArrayList<Size> a(Parameters parameters) {
        Object arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    public static String Ff(String str) {
        try {
            return com.tencent.mm.plugin.sight.base.d.Ff(str);
        } catch (Exception e) {
            x.e("MicroMsg.MMSightUtil", "getMediaInfo error: %s", e.getMessage());
            return null;
        }
    }

    public static String on(String str) {
        return e.gHu + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), str});
    }

    public static void Fg(String str) {
        x.i("MicroMsg.MMSightUtil", "setTime key %s %s", str, bh.cgy().toString());
        oqv.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static long Fh(String str) {
        if (!oqv.containsKey(str)) {
            return 0;
        }
        return System.currentTimeMillis() - ((Long) oqv.get(str)).longValue();
    }

    public static int dc(Context context) {
        if (VERSION.SDK_INT >= 16) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return (int) (((double) memoryInfo.totalMem) / 1024.0d);
        }
        double a;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            a = (double) a("MemTotal", fileInputStream);
            if (a > 0.0d) {
                a /= 1024.0d;
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
        } catch (IOException e2) {
            a = 0.0d;
        } catch (Throwable th) {
            fileInputStream.close();
        }
        return (int) a;
    }

    private static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == (byte) 10 || i == 0) {
                    if (bArr[i] == (byte) 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            continue;
                            break;
                        } else if (i3 == str.length() - 1) {
                            while (i2 < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && bArr[i2] != (byte) 10) {
                                if (Character.isDigit(bArr[i2])) {
                                    i = i2 + 1;
                                    while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && Character.isDigit(bArr[i])) {
                                        i++;
                                    }
                                    return bh.VI(new String(bArr, 0, i2, i - i2));
                                }
                                i2++;
                            }
                            return 0;
                        } else {
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (IOException e) {
        } catch (NumberFormatException e2) {
        }
        return 0;
    }

    public static Bitmap mz(String str) {
        if (bh.ov(str) || !FileOp.bO(str)) {
            x.e("MicroMsg.MMSightUtil", "getVideoThumb, %s not exist!!", str);
            return null;
        }
        x.i("MicroMsg.MMSightUtil", "getVideoThumb, %s", str);
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int i = bh.getInt(mediaMetadataRetriever.extractMetadata(18), -1);
            int i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), -1);
            int mp4Rotate = SightVideoJNI.getMp4Rotate(str);
            x.i("MicroMsg.MMSightUtil", "getVideoThumb, width: %s, height: %s, rotate: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mp4Rotate));
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0, 2);
            mediaMetadataRetriever.release();
            if (frameAtTime != null) {
                return frameAtTime;
            }
            int i3;
            x.i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever failed, try ffmpeg");
            if (i <= 0 || i2 <= 0) {
                x.i("MicroMsg.MMSightUtil", "getSimpleMp4Info: %s", SightVideoJNI.getSimpleMp4Info(str));
                JSONObject jSONObject = new JSONObject(r0);
                i2 = jSONObject.getInt("videoWidth");
                i3 = jSONObject.getInt("videoHeight");
            } else {
                i3 = i2;
                i2 = i;
            }
            byte[] videoThumb = MP4MuxerJNI.getVideoThumb(str, i2, i3);
            if (videoThumb == null) {
                x.e("MicroMsg.MMSightUtil", "getVideoThumb, error, can not get rgb byte!!");
                return null;
            }
            Buffer wrap = ByteBuffer.wrap(videoThumb);
            frameAtTime = Bitmap.createBitmap(i2, i3, Config.ARGB_8888);
            frameAtTime.copyPixelsFromBuffer(wrap);
            if (mp4Rotate > 0) {
                return com.tencent.mm.sdk.platformtools.d.b(frameAtTime, (float) mp4Rotate);
            }
            return frameAtTime;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightUtil", e, "get video thumb error! %s", e.getMessage());
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        byte[] h = j.ouM.h(Integer.valueOf(bArr.length));
        int i4 = i * i2;
        Object obj = i3 % 180 != 0 ? 1 : null;
        Object obj2 = i3 % 270 != 0 ? 1 : null;
        Object obj3 = i3 >= 180 ? 1 : null;
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = 0; i6 < i; i6++) {
                int i7;
                int i8;
                int i9;
                int i10;
                int i11 = (i5 * i) + i6;
                int i12 = (((i5 >> 1) * i) + i4) + (i6 & -2);
                int i13 = i12 + 1;
                if (obj != null) {
                    i7 = i2;
                } else {
                    i7 = i;
                }
                if (obj != null) {
                    i8 = i;
                } else {
                    i8 = i2;
                }
                if (obj != null) {
                    i9 = i5;
                } else {
                    i9 = i6;
                }
                if (obj != null) {
                    i10 = i6;
                } else {
                    i10 = i5;
                }
                if (obj2 != null) {
                    i9 = (i7 - i9) - 1;
                }
                if (obj3 != null) {
                    i10 = (i8 - i10) - 1;
                }
                i8 = (i10 * i7) + i9;
                i10 = (((i10 >> 1) * i7) + i4) + (i9 & -2);
                i9 = i10 + 1;
                h[i8] = (byte) (bArr[i11] & 255);
                h[i10] = (byte) (bArr[i12] & 255);
                h[i9] = (byte) (bArr[i13] & 255);
            }
        }
        j.ouM.D(bArr);
        return h;
    }

    public static boolean a(int i, int i2, int i3, PInt pInt, PInt pInt2) {
        int i4;
        int i5;
        boolean z;
        if (i3 <= 0 || Math.min(i, i2) <= i3) {
            i4 = i2;
            i5 = i;
            z = false;
        } else {
            if (i < i2) {
                i4 = (int) (((float) i2) / ((((float) i) * 1.0f) / ((float) i3)));
                i5 = i3;
            } else {
                i5 = (int) (((float) i) / ((((float) i2) * 1.0f) / ((float) i3)));
                i4 = i3;
            }
            z = true;
        }
        pInt.value = i5;
        pInt2.value = i4;
        x.d("MicroMsg.MMSightUtil", "check bitmap size result[%b] raw[%d %d] minSize[%d] out[%d %d]", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
        return z;
    }

    public static boolean sI(int i) {
        return i % 16 == 0;
    }

    public static int sJ(int i) {
        return cM(i, Integer.MAX_VALUE);
    }

    public static int cM(int i, int i2) {
        int i3 = i % 16;
        if (i3 == 0) {
            return i;
        }
        int i4 = (16 - i3) + i;
        if (i4 < i2) {
            return i4;
        }
        return i - i3;
    }
}
