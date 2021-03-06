package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.u;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

final class l {
    private static int zWD = 5;
    private static int zWE = 1;
    private static final String[] zWF = new String[]{"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private boolean Mu;
    private long mContentLength;
    Context mContext;
    private String mDownloadUrl;
    private boolean mFinished;
    private int mRetryTimes;
    private String zWG;
    private String zWH;
    File zWI;
    private int zWJ = 30000;
    private int zWK = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
    private boolean zWL;
    private int zWM;
    private HttpURLConnection zWN;
    private String zWO;
    private v$b zWP;
    private String zWQ;
    private int zWR;
    private boolean zWS;
    private Handler zWT;
    private Set<String> zWU;
    private int zWV = zWD;
    boolean zWW;
    String zWX;
    String[] zWY = null;
    int zWZ = 0;

    public l(Context context) {
        this.mContext = context.getApplicationContext();
        v.hn(this.mContext);
        this.zWP = v.cEJ();
        this.zWU = new HashSet();
        this.zWO = "tbs_downloading_" + this.mContext.getPackageName();
        t.cEF();
        this.zWI = t.hi(this.mContext);
        if (this.zWI == null) {
            throw new NullPointerException("TbsCorePrivateDir is null!");
        }
        cDZ();
        this.zWQ = null;
        this.zWR = -1;
    }

    private boolean HT(int i) {
        try {
            File file = new File(this.zWI, "x5.tbs");
            File gC = gC(this.mContext);
            if (gC == null) {
                return false;
            }
            File file2 = new File(gC, p.gK(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            file.delete();
            f.j(file2, file);
            if (a.a(this.mContext, file, i)) {
                return true;
            }
            TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
            return false;
        } catch (Exception e) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e.getMessage());
            return false;
        }
    }

    private boolean X(boolean z, boolean z2) {
        long j = 0;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z);
        File file = new File(this.zWI, !z ? "x5.tbs" : "x5.tbs.temp");
        if (!file.exists()) {
            return false;
        }
        String string = o.gG(this.mContext).zXm.getString("tbs_apk_md5", null);
        String Q = a.Q(file);
        if (string == null || !string.equals(Q)) {
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " md5 failed");
            if (!z) {
                return false;
            }
            this.zWP.abk("fileMd5 not match");
            return false;
        }
        boolean renameTo;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + Q + ") successful!");
        if (z) {
            long j2;
            long j3 = o.gG(this.mContext).zXm.getLong("tbs_apkfilesize", 0);
            if (!file.exists()) {
                j2 = 0;
            } else if (j3 > 0) {
                j2 = file.length();
                if (j3 == j2) {
                    j = j2;
                }
            }
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " filelength failed");
            this.zWP.abk("fileLength:" + j2 + ",contentLength:" + j3);
            return false;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + j + ") successful!");
        int i = -1;
        if (z2) {
            i = a.c(this.mContext, file);
            int i2 = o.gG(this.mContext).zXm.getInt("tbs_download_version", 0);
            if (i2 != i) {
                TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " versionCode failed");
                if (!z) {
                    return false;
                }
                this.zWP.abk("fileVersion:" + i + ",configVersion:" + i2);
                return false;
            }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
        if (z2) {
            string = c.d(this.mContext, file);
            if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(string)) {
                TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " signature failed");
                if (!z) {
                    return false;
                }
                this.zWP.abk("signature:" + (string == null ? "null" : Integer.valueOf(string.length())));
                return false;
            }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
        if (z) {
            Throwable th;
            try {
                renameTo = file.renameTo(new File(this.zWI, "x5.tbs"));
                th = null;
            } catch (Throwable e) {
                th = e;
                renameTo = false;
            }
            if (!renameTo) {
                k(109, l(th), true);
                return false;
            }
        }
        renameTo = false;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + renameTo + ") successful!");
        return true;
    }

    public static void a(File file, Context context) {
        if (file.exists()) {
            try {
                File gC = gC(context);
                if (gC != null) {
                    File file2;
                    if (o.gG(context).zXm.getInt("tbs_download_version_type", 0) == 1) {
                        file2 = new File(gC, "x5.tbs.decouple");
                    } else {
                        file2 = new File(gC, p.gK(context) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                    }
                    file2.delete();
                    f.j(file, file2);
                    if (o.gG(context).zXm.getInt("tbs_download_version_type", 0) != 1 && o.gG(context).zXm.getInt("tbs_decouplecoreversion", 0) == a.c(context, file)) {
                        file2 = new File(gC, "x5.tbs.decouple");
                        if (a.c(context, file) != a.c(context, file2)) {
                            file2.delete();
                            f.j(file, file2);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private static File an(Context context, int i) {
        File file = new File(f.ar(context, i));
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        return new File(file, p.gK(context) ? "x5.oversea.tbs.org" : "x5.tbs.org").exists() ? file : null;
    }

    private void cDZ() {
        this.mRetryTimes = 0;
        this.zWM = 0;
        this.mContentLength = -1;
        this.zWH = null;
        this.zWL = false;
        this.Mu = false;
        this.mFinished = false;
        this.zWS = false;
    }

    private boolean cEb() {
        if (this.zWY == null || this.zWZ < 0 || this.zWZ >= this.zWY.length) {
            return false;
        }
        String[] strArr = this.zWY;
        int i = this.zWZ;
        this.zWZ = i + 1;
        this.zWH = strArr[i];
        this.mRetryTimes = 0;
        this.zWM = 0;
        this.mContentLength = -1;
        this.zWL = false;
        this.Mu = false;
        this.mFinished = false;
        this.zWS = false;
        return true;
    }

    private long cEc() {
        File file = new File(this.zWI, "x5.tbs.temp");
        return file.exists() ? file.length() : 0;
    }

    private static boolean cEd() {
        Closeable inputStream;
        Closeable inputStreamReader;
        Throwable th;
        boolean z = false;
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            inputStream = Runtime.getRuntime().exec("ping " + "www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i = 0;
                    do {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.contains("TTL") || readLine.contains("ttl")) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = bufferedReader;
                        }
                    } while (i < 5);
                    h(inputStream);
                    h(inputStreamReader);
                    h(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    h(inputStream);
                    h(inputStreamReader);
                    h(closeable);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                h(inputStream);
                h(inputStreamReader);
                h(closeable);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            inputStream = null;
            h(inputStream);
            h(inputStreamReader);
            h(closeable);
            throw th;
        }
        return z;
    }

    private boolean cEe() {
        CharSequence charSequence;
        Object obj;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = b.hL(this.mContext) == 3;
        TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z3);
        if (z3) {
            String hM = b.hM(this.mContext);
            TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + hM);
            HttpURLConnection httpURLConnection2;
            try {
                httpURLConnection2 = (HttpURLConnection) new URL("http://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.getInputStream();
                    int responseCode = httpURLConnection2.getResponseCode();
                    TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    if (responseCode != d.CTRL_INDEX) {
                        z = false;
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                            charSequence = hM;
                            z2 = z;
                        } catch (Exception e) {
                            obj = hM;
                            z2 = z;
                        }
                    } else {
                        obj = hM;
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    httpURLConnection = httpURLConnection2;
                    th = th2;
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
        if (!(z2 || TextUtils.isEmpty(charSequence) || this.zWU.contains(charSequence))) {
            this.zWU.add(charSequence);
            if (this.zWT == null) {
                this.zWT = new 1(this, r.cEE().getLooper());
            }
            this.zWT.sendMessageDelayed(this.zWT.obtainMessage(150, charSequence), 120000);
        }
        if (z2 && this.zWU.contains(charSequence)) {
            this.zWU.remove(charSequence);
        }
        return z2;
    }

    private static String d(URL url) {
        String str = "";
        try {
            str = InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e) {
        } catch (Error e2) {
        }
        return str;
    }

    @TargetApi(8)
    static File gC(Context context) {
        try {
            File file = VERSION.SDK_INT >= 8 ? new File(f.ar(context, 4)) : null;
            if (file == null || file.exists() || file.isDirectory()) {
                return file;
            }
            file.mkdirs();
            return file;
        } catch (Exception e) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    @TargetApi(8)
    static File gD(Context context) {
        try {
            if (VERSION.SDK_INT < 8) {
                return null;
            }
            File an = an(context, 4);
            if (an == null) {
                an = an(context, 3);
            }
            if (an == null) {
                an = an(context, 2);
            }
            return an == null ? an(context, 1) : an;
        } catch (Exception e) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    public static void gE(Context context) {
        try {
            t.cEF();
            File hi = t.hi(context);
            new File(hi, "x5.tbs").delete();
            new File(hi, "x5.tbs.temp").delete();
            hi = gC(context);
            if (hi != null) {
                new File(hi, "x5.tbs.org").delete();
                new File(hi, "x5.oversea.tbs.org").delete();
            }
        } catch (Exception e) {
        }
    }

    private void gv(long j) {
        long j2;
        this.mRetryTimes++;
        if (j <= 0) {
            try {
                switch (this.mRetryTimes) {
                    case 1:
                    case 2:
                        j2 = 20000 * ((long) this.mRetryTimes);
                        break;
                    case 3:
                    case 4:
                        j2 = 100000;
                        break;
                    default:
                        j2 = 200000;
                        break;
                }
            } catch (Exception e) {
                return;
            }
        }
        j2 = j;
        Thread.sleep(j2);
    }

    private static void h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    private void k(int i, String str, boolean z) {
        if (z || this.mRetryTimes > this.zWV) {
            this.zWP.setErrorCode(i);
            this.zWP.abl(str);
        }
    }

    private static String l(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT ? stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) : stackTraceString;
    }

    private void nQ(boolean z) {
        u.ib(this.mContext);
        o gG = o.gG(this.mContext);
        gG.zXl.put("request_full_package", Boolean.valueOf(false));
        gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
        gG.commit();
        QbSdk.zWf.ly(z ? 100 : 120);
        int i = gG.zXm.getInt("tbs_responsecode", 0);
        o.gG(this.mContext).zXm.getInt("tbs_downloaddecouplecore", 0);
        if (i == 3 || i > 10000) {
            File gC = gC(this.mContext);
            if (gC != null) {
                File file = new File(gC, p.gK(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                int c = a.c(this.mContext, file);
                File file2 = new File(this.zWI, "x5.tbs");
                String absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
                int i2 = gG.zXm.getInt("tbs_download_version", 0);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", i);
                bundle.putInt("old_core_ver", c);
                bundle.putInt("new_core_ver", i2);
                bundle.putString("old_apk_location", file.getAbsolutePath());
                bundle.putString("new_apk_location", absolutePath);
                bundle.putString("diff_file_location", absolutePath);
                t.cEF().f(this.mContext, bundle);
                return;
            }
            clearCache();
            gG.zXl.put("tbs_needdownload", Boolean.valueOf(true));
            gG.commit();
            return;
        }
        int i3 = gG.zXm.getInt("tbs_download_version", 0);
        t.cEF();
        t.s(this.mContext, new File(this.zWI, "x5.tbs").getAbsolutePath(), i3);
        a(new File(this.zWI, "x5.tbs"), this.mContext);
    }

    private boolean nR(boolean z) {
        TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + z);
        File file = z ? new File(this.zWI, "x5.tbs") : new File(this.zWI, "x5.tbs.temp");
        return file.exists() ? file.delete() : true;
    }

    public final void W(boolean r34, boolean r35) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r33 = this;
        r2 = com.tencent.smtt.sdk.t.cEF();
        r0 = r33;
        r3 = r0.mContext;
        r2 = r2.gO(r3);
        if (r2 == 0) goto L_0x0021;
    L_0x000e:
        if (r34 != 0) goto L_0x0021;
    L_0x0010:
        r2 = 0;
        com.tencent.smtt.sdk.p.zXu = r2;
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r3 = -322; // 0xfffffffffffffebe float:NaN double:NaN;
        r2.HU(r3);
    L_0x0020:
        return;
    L_0x0021:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXm;
        r3 = "tbs_responsecode";
        r4 = 0;
        r2 = r2.getInt(r3, r4);
        r3 = 1;
        if (r2 == r3) goto L_0x003c;
    L_0x0036:
        r3 = 2;
        if (r2 == r3) goto L_0x003c;
    L_0x0039:
        r3 = 4;
        if (r2 != r3) goto L_0x004f;
    L_0x003c:
        r2 = 1;
        r17 = r2;
    L_0x003f:
        if (r35 != 0) goto L_0x0053;
    L_0x0041:
        r0 = r33;
        r1 = r17;
        r2 = r0.nP(r1);
        if (r2 == 0) goto L_0x0053;
    L_0x004b:
        r2 = 0;
        com.tencent.smtt.sdk.p.zXu = r2;
        goto L_0x0020;
    L_0x004f:
        r2 = 0;
        r17 = r2;
        goto L_0x003f;
    L_0x0053:
        r0 = r34;
        r1 = r33;
        r1.zWW = r0;
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXm;
        r3 = "tbs_downloadurl";
        r4 = 0;
        r2 = r2.getString(r3, r4);
        r0 = r33;
        r0.mDownloadUrl = r2;
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXm;
        r3 = "tbs_downloadurl_list";
        r4 = 0;
        r2 = r2.getString(r3, r4);
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "backupUrlStrings:";
        r4.<init>(r5);
        r4 = r4.append(r2);
        r4 = r4.toString();
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.i(r3, r4, r5);
        r3 = 0;
        r0 = r33;
        r0.zWY = r3;
        r3 = 0;
        r0 = r33;
        r0.zWZ = r3;
        if (r34 != 0) goto L_0x00c2;
    L_0x00a4:
        if (r2 == 0) goto L_0x00c2;
    L_0x00a6:
        r3 = "";
        r4 = r2.trim();
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x00c2;
    L_0x00b3:
        r3 = r2.trim();
        r4 = ";";
        r3 = r3.split(r4);
        r0 = r33;
        r0.zWY = r3;
    L_0x00c2:
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "[TbsApkDownloader.startDownload] mDownloadUrl=";
        r4.<init>(r5);
        r0 = r33;
        r5 = r0.mDownloadUrl;
        r4 = r4.append(r5);
        r5 = " backupUrlStrings=";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " mLocation=";
        r2 = r2.append(r4);
        r0 = r33;
        r4 = r0.zWH;
        r2 = r2.append(r4);
        r4 = " mCanceled=";
        r2 = r2.append(r4);
        r0 = r33;
        r4 = r0.Mu;
        r2 = r2.append(r4);
        r4 = " mHttpRequest=";
        r2 = r2.append(r4);
        r0 = r33;
        r4 = r0.zWN;
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r2);
        r0 = r33;
        r2 = r0.mDownloadUrl;
        if (r2 != 0) goto L_0x0136;
    L_0x011a:
        r0 = r33;
        r2 = r0.zWH;
        if (r2 != 0) goto L_0x0136;
    L_0x0120:
        r2 = com.tencent.smtt.sdk.QbSdk.zWf;
        r3 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r2.ly(r3);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r3 = -302; // 0xfffffffffffffed2 float:NaN double:NaN;
        r2.HU(r3);
        goto L_0x0020;
    L_0x0136:
        r0 = r33;
        r2 = r0.zWN;
        if (r2 == 0) goto L_0x0158;
    L_0x013c:
        r0 = r33;
        r2 = r0.Mu;
        if (r2 != 0) goto L_0x0158;
    L_0x0142:
        r2 = com.tencent.smtt.sdk.QbSdk.zWf;
        r3 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r2.ly(r3);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r3 = -303; // 0xfffffffffffffed1 float:NaN double:NaN;
        r2.HU(r3);
        goto L_0x0020;
    L_0x0158:
        if (r34 != 0) goto L_0x018b;
    L_0x015a:
        r0 = r33;
        r2 = r0.zWU;
        r0 = r33;
        r3 = r0.mContext;
        r3 = com.tencent.smtt.utils.b.hM(r3);
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x018b;
    L_0x016c:
        r2 = "TbsDownload";
        r3 = "[TbsApkDownloader.startDownload] WIFI Unavailable";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = com.tencent.smtt.sdk.QbSdk.zWf;
        r3 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r2.ly(r3);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r3 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r2.HU(r3);
        goto L_0x0020;
    L_0x018b:
        r33.cDZ();
        r2 = "TbsDownload";
        r3 = "STEP 1/2 begin downloading...";
        r4 = 1;
        com.tencent.smtt.utils.TbsLog.i(r2, r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r22 = r2.cEj();
        r4 = 0;
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXm;
        r3 = "tbs_downloadflow";
        r6 = 0;
        r2 = r2.getLong(r3, r6);
        if (r34 == 0) goto L_0x0354;
    L_0x01ba:
        r5 = zWE;
        r0 = r33;
        r0.zWV = r5;
        r6 = r4;
    L_0x01c1:
        r0 = r33;
        r4 = r0.mRetryTimes;
        r0 = r33;
        r5 = r0.zWV;
        if (r4 > r5) goto L_0x01e9;
    L_0x01cb:
        r0 = r33;
        r4 = r0.zWM;
        r5 = 8;
        if (r4 <= r5) goto L_0x035d;
    L_0x01d3:
        r2 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r3 = 0;
        r4 = 1;
        r0 = r33;
        r0.k(r2, r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r3 = -306; // 0xfffffffffffffece float:NaN double:NaN;
        r2.HU(r3);
    L_0x01e9:
        r0 = r33;
        r2 = r0.Mu;
        if (r2 != 0) goto L_0x0268;
    L_0x01ef:
        r0 = r33;
        r2 = r0.mFinished;
        if (r2 == 0) goto L_0x023a;
    L_0x01f5:
        r0 = r33;
        r2 = r0.zWY;
        if (r2 != 0) goto L_0x0206;
    L_0x01fb:
        if (r6 != 0) goto L_0x0206;
    L_0x01fd:
        r2 = 1;
        r0 = r33;
        r1 = r17;
        r6 = r0.X(r2, r1);
    L_0x0206:
        r0 = r33;
        r3 = r0.zWP;
        if (r6 == 0) goto L_0x1043;
    L_0x020c:
        r2 = 1;
    L_0x020d:
        r3.zYs = r2;
        if (r17 != 0) goto L_0x1049;
    L_0x0211:
        r0 = r33;
        r3 = r0.zWP;
        if (r6 == 0) goto L_0x1046;
    L_0x0217:
        r2 = 1;
    L_0x0218:
        r3.zYq = r2;
    L_0x021a:
        if (r6 == 0) goto L_0x1052;
    L_0x021c:
        r2 = 1;
        r0 = r33;
        r0.nQ(r2);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r3 = -317; // 0xfffffffffffffec3 float:NaN double:NaN;
        r2.HU(r3);
        r2 = 100;
        r3 = "success";
        r4 = 1;
        r0 = r33;
        r0.k(r2, r3, r4);
    L_0x023a:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        if (r6 == 0) goto L_0x1067;
    L_0x0244:
        r3 = r2.zXm;
        r4 = "tbs_download_success_retrytimes";
        r5 = 0;
        r3 = r3.getInt(r4, r5);
        r4 = r2.zXl;
        r5 = "tbs_download_success_retrytimes";
        r3 = r3 + 1;
        r3 = java.lang.Integer.valueOf(r3);
        r4.put(r5, r3);
    L_0x025c:
        r2.commit();
        r0 = r33;
        r3 = r0.zWP;
        if (r6 == 0) goto L_0x108e;
    L_0x0265:
        r2 = 1;
    L_0x0266:
        r3.zYv = r2;
    L_0x0268:
        r2 = "TbsDownload";
        r3 = "[TbsApkDownloader.closeHttpRequest]";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r0 = r33;
        r2 = r0.zWN;
        if (r2 == 0) goto L_0x029b;
    L_0x0277:
        r0 = r33;
        r2 = r0.Mu;
        if (r2 != 0) goto L_0x028f;
    L_0x027d:
        r0 = r33;
        r2 = r0.zWP;
        r0 = r33;
        r3 = r0.zWN;
        r3 = r3.getURL();
        r3 = d(r3);
        r2.zYo = r3;
    L_0x028f:
        r0 = r33;	 Catch:{ Throwable -> 0x1091 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x1091 }
        r2.disconnect();	 Catch:{ Throwable -> 0x1091 }
    L_0x0296:
        r2 = 0;
        r0 = r33;
        r0.zWN = r2;
    L_0x029b:
        r0 = r33;
        r2 = r0.zWP;
        r3 = r2.mErrorCode;
        r0 = r33;
        r2 = r0.Mu;
        if (r2 != 0) goto L_0x10d2;
    L_0x02a7:
        r0 = r33;
        r2 = r0.zWS;
        if (r2 == 0) goto L_0x10d2;
    L_0x02ad:
        r0 = r33;
        r2 = r0.zWP;
        r4 = java.lang.System.currentTimeMillis();
        r2.zYm = r4;
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.utils.b.hK(r2);
        if (r2 != 0) goto L_0x02c4;
    L_0x02c1:
        r2 = "";
    L_0x02c4:
        r0 = r33;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.utils.b.hL(r4);
        r0 = r33;
        r5 = r0.zWP;
        r5.zYt = r2;
        r0 = r33;
        r5 = r0.zWP;
        r5.zYu = r4;
        r0 = r33;
        r5 = r0.zWR;
        if (r4 != r5) goto L_0x02e8;
    L_0x02de:
        r0 = r33;
        r4 = r0.zWQ;
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x02ef;
    L_0x02e8:
        r0 = r33;
        r2 = r0.zWP;
        r4 = 0;
        r2.zYy = r4;
    L_0x02ef:
        r0 = r33;
        r2 = r0.zWP;
        r2 = r2.mErrorCode;
        if (r2 == 0) goto L_0x0301;
    L_0x02f7:
        r0 = r33;
        r2 = r0.zWP;
        r2 = r2.mErrorCode;
        r4 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        if (r2 != r4) goto L_0x031c;
    L_0x0301:
        r0 = r33;
        r2 = r0.zWP;
        r2 = r2.zYv;
        if (r2 != 0) goto L_0x031c;
    L_0x0309:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.utils.b.isNetworkAvailable(r2);
        if (r2 != 0) goto L_0x10ae;
    L_0x0313:
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r4 = 0;
        r5 = 1;
        r0 = r33;
        r0.k(r2, r4, r5);
    L_0x031c:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXm;
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r2 = r2.getInt(r4, r5);
        r4 = 1;
        if (r2 != r4) goto L_0x10bf;
    L_0x0331:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.v.hn(r2);
        r4 = com.tencent.smtt.sdk.v.a.zYi;
        r0 = r33;
        r5 = r0.zWP;
        r2.a(r4, r5);
    L_0x0342:
        r0 = r33;
        r2 = r0.zWP;
        r2.cDZ();
        r2 = 100;
        if (r3 == r2) goto L_0x0020;
    L_0x034d:
        r2 = com.tencent.smtt.sdk.QbSdk.zWf;
        r2.ly(r3);
        goto L_0x0020;
    L_0x0354:
        r5 = zWD;
        r0 = r33;
        r0.zWV = r5;
    L_0x035a:
        r6 = r4;
        goto L_0x01c1;
    L_0x035d:
        r18 = java.lang.System.currentTimeMillis();
        if (r34 != 0) goto L_0x0469;
    L_0x0363:
        r0 = r33;	 Catch:{ Throwable -> 0x10df }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x10df }
        r4 = com.tencent.smtt.sdk.o.gG(r4);	 Catch:{ Throwable -> 0x10df }
        r4 = r4.zXm;	 Catch:{ Throwable -> 0x10df }
        r5 = "tbs_downloadstarttime";	 Catch:{ Throwable -> 0x10df }
        r8 = 0;	 Catch:{ Throwable -> 0x10df }
        r4 = r4.getLong(r5, r8);	 Catch:{ Throwable -> 0x10df }
        r4 = r18 - r4;	 Catch:{ Throwable -> 0x10df }
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ Throwable -> 0x10df }
        r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));	 Catch:{ Throwable -> 0x10df }
        if (r4 <= 0) goto L_0x040c;	 Catch:{ Throwable -> 0x10df }
    L_0x037f:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x10df }
        r5 = "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD";	 Catch:{ Throwable -> 0x10df }
        com.tencent.smtt.utils.TbsLog.i(r4, r5);	 Catch:{ Throwable -> 0x10df }
        r0 = r33;	 Catch:{ Throwable -> 0x10df }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x10df }
        r4 = com.tencent.smtt.sdk.o.gG(r4);	 Catch:{ Throwable -> 0x10df }
        r4 = r4.zXl;	 Catch:{ Throwable -> 0x10df }
        r5 = "tbs_downloadstarttime";	 Catch:{ Throwable -> 0x10df }
        r7 = java.lang.Long.valueOf(r18);	 Catch:{ Throwable -> 0x10df }
        r4.put(r5, r7);	 Catch:{ Throwable -> 0x10df }
        r0 = r33;	 Catch:{ Throwable -> 0x10df }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x10df }
        r4 = com.tencent.smtt.sdk.o.gG(r4);	 Catch:{ Throwable -> 0x10df }
        r4 = r4.zXl;	 Catch:{ Throwable -> 0x10df }
        r5 = "tbs_downloadflow";	 Catch:{ Throwable -> 0x10df }
        r8 = 0;	 Catch:{ Throwable -> 0x10df }
        r7 = java.lang.Long.valueOf(r8);	 Catch:{ Throwable -> 0x10df }
        r4.put(r5, r7);	 Catch:{ Throwable -> 0x10df }
        r0 = r33;	 Catch:{ Throwable -> 0x10df }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x10df }
        r4 = com.tencent.smtt.sdk.o.gG(r4);	 Catch:{ Throwable -> 0x10df }
        r4.commit();	 Catch:{ Throwable -> 0x10df }
        r4 = 0;
    L_0x03bf:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.utils.f.hS(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 != 0) goto L_0x046a;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x03c9:
        r2 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "DownloadBegin FreeSpace too small";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = 105; // 0x69 float:1.47E-43 double:5.2E-322;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.k(r2, r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -308; // 0xfffffffffffffecc float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x01e9;
    L_0x03eb:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x040c:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x10df }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x10df }
        r7 = "[TbsApkDownloader.startDownload] downloadFlow=";	 Catch:{ Throwable -> 0x10df }
        r5.<init>(r7);	 Catch:{ Throwable -> 0x10df }
        r5 = r5.append(r2);	 Catch:{ Throwable -> 0x10df }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x10df }
        com.tencent.smtt.utils.TbsLog.i(r4, r5);	 Catch:{ Throwable -> 0x10df }
        r4 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1));	 Catch:{ Throwable -> 0x10df }
        if (r4 < 0) goto L_0x1138;	 Catch:{ Throwable -> 0x10df }
    L_0x0426:
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x10df }
        r5 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";	 Catch:{ Throwable -> 0x10df }
        r7 = 1;	 Catch:{ Throwable -> 0x10df }
        com.tencent.smtt.utils.TbsLog.i(r4, r5, r7);	 Catch:{ Throwable -> 0x10df }
        r4 = 112; // 0x70 float:1.57E-43 double:5.53E-322;	 Catch:{ Throwable -> 0x10df }
        r5 = 0;	 Catch:{ Throwable -> 0x10df }
        r7 = 1;	 Catch:{ Throwable -> 0x10df }
        r0 = r33;	 Catch:{ Throwable -> 0x10df }
        r0.k(r4, r5, r7);	 Catch:{ Throwable -> 0x10df }
        r0 = r33;	 Catch:{ Throwable -> 0x10df }
        r4 = r0.mContext;	 Catch:{ Throwable -> 0x10df }
        r4 = com.tencent.smtt.sdk.o.gG(r4);	 Catch:{ Throwable -> 0x10df }
        r5 = -307; // 0xfffffffffffffecd float:NaN double:NaN;	 Catch:{ Throwable -> 0x10df }
        r4.HU(r5);	 Catch:{ Throwable -> 0x10df }
        if (r34 != 0) goto L_0x01e9;
    L_0x0448:
        r0 = r33;
        r4 = r0.mContext;
        r4 = com.tencent.smtt.sdk.o.gG(r4);
        r4 = r4.zXl;
        r5 = "tbs_downloadflow";
        r2 = java.lang.Long.valueOf(r2);
        r4.put(r5, r2);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0469:
        r4 = r2;
    L_0x046a:
        r2 = 1;
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWS = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWH;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == 0) goto L_0x0659;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0475:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWH;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0479:
        r3 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = "try url:";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = ",mRetryTimes:";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r0.mRetryTimes;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r3, r7, r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.zWG;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r2.equals(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 != 0) goto L_0x04b3;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x04a9:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.zWP;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r3.zYn;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 != 0) goto L_0x065f;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x04b1:
        r3.zYn = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x04b3:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWG = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = new java.net.URL;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == 0) goto L_0x04c9;
    L_0x04c2:
        r0 = r33;	 Catch:{ Throwable -> 0x06f9, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x06f9, all -> 0x0716 }
        r2.disconnect();	 Catch:{ Throwable -> 0x06f9, all -> 0x0716 }
    L_0x04c9:
        r2 = r3.openConnection();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWN = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "User-Agent";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = com.tencent.smtt.sdk.p.cEx();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.setRequestProperty(r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "Accept-Encoding";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = "identity";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.setRequestProperty(r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "GET";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.setRequestMethod(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.setInstanceFollowRedirects(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.zWK;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.setConnectTimeout(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.zWJ;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.setReadTimeout(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r12 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWL;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 != 0) goto L_0x057a;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x051e:
        r12 = r33.cEc();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = "[TbsApkDownloader.startDownload] range=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3.<init>(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.append(r12);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContentLength;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 > 0) goto L_0x0739;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0542:
        r2 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = "STEP 1/2 begin downloading...current";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3.<init>(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.append(r12);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "Range";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = "bytes=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r12);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = "-";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.setRequestProperty(r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x057a:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.zWP;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 != 0) goto L_0x078a;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0584:
        r2 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0585:
        r3.zYr = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.utils.b.hL(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = com.tencent.smtt.utils.b.hK(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.zWQ;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 != 0) goto L_0x078d;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x059d:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.zWR;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = -1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 != r8) goto L_0x078d;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x05a4:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWQ = r3;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWR = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x05ac:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mRetryTimes;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 <= 0) goto L_0x05c0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x05b2:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "Referer";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.mDownloadUrl;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.addRequestProperty(r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x05c0:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.getResponseCode();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = "[TbsApkDownloader.startDownload] responseCode=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.zWP;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3.zYp = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x0623;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x05e6:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = com.tencent.smtt.sdk.p.gK(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 != 0) goto L_0x0623;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x05f0:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = com.tencent.smtt.utils.b.hL(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = 3;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 == r7) goto L_0x0601;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x05fb:
        r3 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 == 0) goto L_0x060b;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0601:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = com.tencent.smtt.utils.b.hL(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 != 0) goto L_0x0623;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x060b:
        r33.stopDownload();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = com.tencent.smtt.sdk.QbSdk.zWf;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 == 0) goto L_0x0619;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0612:
        r3 = com.tencent.smtt.sdk.QbSdk.zWf;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = 111; // 0x6f float:1.56E-43 double:5.5E-322;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3.ly(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0619:
        r3 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = "Download is canceled due to NOT_WIFI error!";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r3, r7, r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0623:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.Mu;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 == 0) goto L_0x07ae;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0629:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x01e9;
    L_0x0638:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0659:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mDownloadUrl;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        goto L_0x0479;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x065f:
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7.<init>();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r3.zYn;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = ";";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3.zYn = r7;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        goto L_0x04b3;
    L_0x067d:
        r2 = move-exception;
        r30 = r2;
        r2 = r4;
        r5 = r30;
        r4 = r6;
    L_0x0684:
        r6 = r5 instanceof javax.net.ssl.SSLHandshakeException;	 Catch:{ all -> 0x10d7 }
        if (r6 == 0) goto L_0x0ff9;	 Catch:{ all -> 0x10d7 }
    L_0x0688:
        if (r34 != 0) goto L_0x0ff9;	 Catch:{ all -> 0x10d7 }
    L_0x068a:
        r0 = r33;	 Catch:{ all -> 0x10d7 }
        r6 = r0.zWY;	 Catch:{ all -> 0x10d7 }
        if (r6 == 0) goto L_0x0ff9;	 Catch:{ all -> 0x10d7 }
    L_0x0690:
        r6 = r33.cEb();	 Catch:{ all -> 0x10d7 }
        if (r6 == 0) goto L_0x0ff9;	 Catch:{ all -> 0x10d7 }
    L_0x0696:
        r6 = "TbsDownload";	 Catch:{ all -> 0x10d7 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x10d7 }
        r8 = "[startdownload]url:";	 Catch:{ all -> 0x10d7 }
        r7.<init>(r8);	 Catch:{ all -> 0x10d7 }
        r0 = r33;	 Catch:{ all -> 0x10d7 }
        r8 = r0.zWH;	 Catch:{ all -> 0x10d7 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x10d7 }
        r8 = " download exception：";	 Catch:{ all -> 0x10d7 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x10d7 }
        r5 = r5.toString();	 Catch:{ all -> 0x10d7 }
        r5 = r7.append(r5);	 Catch:{ all -> 0x10d7 }
        r5 = r5.toString();	 Catch:{ all -> 0x10d7 }
        com.tencent.smtt.utils.TbsLog.e(r6, r5);	 Catch:{ all -> 0x10d7 }
        r5 = 125; // 0x7d float:1.75E-43 double:6.2E-322;	 Catch:{ all -> 0x10d7 }
        r6 = 0;	 Catch:{ all -> 0x10d7 }
        r7 = 1;	 Catch:{ all -> 0x10d7 }
        r0 = r33;	 Catch:{ all -> 0x10d7 }
        r0.k(r5, r6, r7);	 Catch:{ all -> 0x10d7 }
    L_0x06c8:
        r0 = r33;	 Catch:{ all -> 0x10d7 }
        r5 = r0.mContext;	 Catch:{ all -> 0x10d7 }
        r5 = com.tencent.smtt.sdk.o.gG(r5);	 Catch:{ all -> 0x10d7 }
        r6 = -316; // 0xfffffffffffffec4 float:NaN double:NaN;	 Catch:{ all -> 0x10d7 }
        r5.HU(r6);	 Catch:{ all -> 0x10d7 }
        if (r34 != 0) goto L_0x035a;
    L_0x06d7:
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5 = r5.zXl;
        r6 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r2);
        r5.put(r6, r7);
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5.commit();
        r6 = r4;
        goto L_0x01c1;
    L_0x06f9:
        r2 = move-exception;
        r7 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r9 = "[initHttpRequest] mHttpRequest.disconnect() Throwable:";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8.<init>(r9);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r8.append(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.e(r7, r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        goto L_0x04c9;
    L_0x0716:
        r2 = move-exception;
    L_0x0717:
        if (r34 != 0) goto L_0x0738;
    L_0x0719:
        r0 = r33;
        r3 = r0.mContext;
        r3 = com.tencent.smtt.sdk.o.gG(r3);
        r3 = r3.zXl;
        r6 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r3.put(r6, r4);
        r0 = r33;
        r3 = r0.mContext;
        r3 = com.tencent.smtt.sdk.o.gG(r3);
        r3.commit();
    L_0x0738:
        throw r2;
    L_0x0739:
        r2 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = "#1 STEP 1/2 begin downloading...current/total=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3.<init>(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.append(r12);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = "/";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.append(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r0.mContentLength;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "Range";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = "bytes=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r12);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = "-";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r0.mContentLength;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.setRequestProperty(r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        goto L_0x057a;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x078a:
        r2 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        goto L_0x0585;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x078d:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.zWR;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 != r7) goto L_0x079d;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0793:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.zWQ;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r3.equals(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 != 0) goto L_0x05ac;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x079d:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.zWP;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7.zYy = r8;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWQ = r3;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWR = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        goto L_0x05ac;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x07ae:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == r3) goto L_0x07b6;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x07b2:
        r3 = 206; // 0xce float:2.89E-43 double:1.02E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 != r3) goto L_0x0d25;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x07b6:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.getContentLength();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = (long) r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2 + r12;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.mContentLength = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = "[TbsApkDownloader.startDownload] mContentLength=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3.<init>(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r0.mContentLength;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWP;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r0.mContentLength;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.zYw = r8;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.zXm;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "tbs_apkfilesize";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.getLong(r3, r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 == 0) goto L_0x08e7;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0801:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r0.mContentLength;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 == 0) goto L_0x08e7;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0809:
        r7 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r9 = "DownloadBegin tbsApkFileSize=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8.<init>(r9);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r8.append(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r9 = "  but contentLength=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r8.append(r9);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r10 = r0.mContentLength;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r8.append(r10);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r9 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r7, r8, r9);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x08ce;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0831:
        r7 = r33.cEe();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 != 0) goto L_0x0847;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0837:
        r7 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 == 0) goto L_0x08ce;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x083d:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = com.tencent.smtt.utils.b.isNetworkAvailable(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 == 0) goto L_0x08ce;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0847:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.zWY;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 == 0) goto L_0x0877;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x084d:
        r7 = r33.cEb();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r7 == 0) goto L_0x0877;
    L_0x0853:
        if (r34 != 0) goto L_0x112d;
    L_0x0855:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r4);
        r2.put(r3, r7);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        r2 = r4;
        goto L_0x01c1;
    L_0x0877:
        r7 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r9 = "tbsApkFileSize=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8.<init>(r9);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r8.append(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "  but contentLength=";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r0.mContentLength;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.append(r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.k(r7, r2, r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -310; // 0xfffffffffffffeca float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x08ab:
        if (r34 != 0) goto L_0x01e9;
    L_0x08ad:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x08ce:
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r3 = "WifiNetworkUnAvailable";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.k(r2, r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        goto L_0x08ab;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x08e7:
        r8 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = "TbsDownload";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r9 = "[TbsApkDownloader.startDownload] begin readResponse";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        com.tencent.smtt.utils.TbsLog.i(r2, r9);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ IOException -> 0x10fd, all -> 0x10e7 }
        r2 = r0.zWN;	 Catch:{ IOException -> 0x10fd, all -> 0x10e7 }
        r14 = r2.getInputStream();	 Catch:{ IOException -> 0x10fd, all -> 0x10e7 }
        if (r14 == 0) goto L_0x1134;
    L_0x08fd:
        r0 = r33;	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        r2 = r0.zWN;	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        r2 = r2.getContentEncoding();	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        if (r2 == 0) goto L_0x0988;	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
    L_0x0907:
        r7 = "gzip";	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        r7 = r2.contains(r7);	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        if (r7 == 0) goto L_0x0988;	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
    L_0x0910:
        r7 = new java.util.zip.GZIPInputStream;	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        r7.<init>(r14);	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
    L_0x0915:
        r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r2];	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r24 = r0;	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r15 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r2 = new java.io.File;	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r0 = r33;	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r3 = r0.zWI;	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r9 = "x5.tbs.temp";	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r2.<init>(r3, r9);	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r3 = 1;	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r15.<init>(r2, r3);	 Catch:{ IOException -> 0x110a, all -> 0x10f2 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r16 = 0;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r12;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = r18;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r18 = r12;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0938:
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r12 = r0.Mu;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        if (r12 == 0) goto L_0x09fb;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x093e:
        r2 = "TbsDownload";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = "STEP 1/2 begin downloading...Canceled!";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3, r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r0.mContext;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2.HU(r3);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r4;
        r5 = r16;
        r4 = r6;
    L_0x0959:
        if (r5 == 0) goto L_0x0bf4;
    L_0x095b:
        h(r15);	 Catch:{ Throwable -> 0x10e4 }
        h(r7);	 Catch:{ Throwable -> 0x10e4 }
        h(r14);	 Catch:{ Throwable -> 0x10e4 }
        if (r34 != 0) goto L_0x035a;
    L_0x0966:
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5 = r5.zXl;
        r6 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r2);
        r5.put(r6, r7);
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5.commit();
        r6 = r4;
        goto L_0x01c1;
    L_0x0988:
        if (r2 == 0) goto L_0x09f8;
    L_0x098a:
        r7 = "deflate";	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        r2 = r2.contains(r7);	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        if (r2 == 0) goto L_0x09f8;	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
    L_0x0993:
        r7 = new java.util.zip.InflaterInputStream;	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        r2 = new java.util.zip.Inflater;	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        r9 = 1;	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        r2.<init>(r9);	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        r7.<init>(r14, r2);	 Catch:{ IOException -> 0x09a0, all -> 0x10ed }
        goto L_0x0915;
    L_0x09a0:
        r2 = move-exception;
        r7 = r14;
        r30 = r4;
        r5 = r2;
        r4 = r6;
        r6 = r3;
        r2 = r30;
    L_0x09a9:
        r9 = r5 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x0d11 }
        if (r9 != 0) goto L_0x09b1;	 Catch:{ all -> 0x0d11 }
    L_0x09ad:
        r9 = r5 instanceof java.net.SocketException;	 Catch:{ all -> 0x0d11 }
        if (r9 == 0) goto L_0x0c35;	 Catch:{ all -> 0x0d11 }
    L_0x09b1:
        r9 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;	 Catch:{ all -> 0x0d11 }
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r0.zWJ = r9;	 Catch:{ all -> 0x0d11 }
        r10 = 0;	 Catch:{ all -> 0x0d11 }
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r0.gv(r10);	 Catch:{ all -> 0x0d11 }
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;	 Catch:{ all -> 0x0d11 }
        r5 = l(r5);	 Catch:{ all -> 0x0d11 }
        r10 = 0;	 Catch:{ all -> 0x0d11 }
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r0.k(r9, r5, r10);	 Catch:{ all -> 0x0d11 }
        h(r8);	 Catch:{ Throwable -> 0x10e4 }
        h(r6);	 Catch:{ Throwable -> 0x10e4 }
        h(r7);	 Catch:{ Throwable -> 0x10e4 }
        if (r34 != 0) goto L_0x035a;
    L_0x09d6:
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5 = r5.zXl;
        r6 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r2);
        r5.put(r6, r7);
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5.commit();
        r6 = r4;
        goto L_0x01c1;
    L_0x09f8:
        r7 = r14;
        goto L_0x0915;
    L_0x09fb:
        r12 = 0;
        r13 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = r24;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r25 = r7.read(r0, r12, r13);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        if (r25 > 0) goto L_0x0a53;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a06:
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r0.zWY;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        if (r2 == 0) goto L_0x0a34;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a0c:
        r2 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r1 = r17;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r0.X(r2, r1);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        if (r2 != 0) goto L_0x0a34;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a17:
        if (r34 != 0) goto L_0x0a28;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a19:
        r2 = r33.cEb();	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        if (r2 == 0) goto L_0x0a28;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a1f:
        r2 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r30 = r2;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r4;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r5 = r30;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r4 = r6;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        goto L_0x0959;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a28:
        r2 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0.mFinished = r2;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r6 = 0;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r4;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r5 = r16;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r4 = r6;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        goto L_0x0959;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a34:
        r2 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0.mFinished = r2;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r0.zWY;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        if (r2 == 0) goto L_0x0a40;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a3f:
        r6 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a40:
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r0.mContext;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = -311; // 0xfffffffffffffec9 float:NaN double:NaN;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2.HU(r3);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r4;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r5 = r16;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r4 = r6;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        goto L_0x0959;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a53:
        r12 = 0;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r24;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r1 = r25;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r15.write(r0, r12, r1);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r15.flush();	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        if (r34 != 0) goto L_0x0b04;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a60:
        r0 = r25;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r12 = (long) r0;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r4 = r4 + r12;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r12 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1));	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        if (r12 < 0) goto L_0x0aaa;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0a68:
        r2 = "TbsDownload";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3, r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = "downloadFlow=";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3.<init>(r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = " downloadMaxflow=";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = r3.append(r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r22;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = r3.append(r0);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0.k(r2, r3, r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r0.mContext;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = -307; // 0xfffffffffffffecd float:NaN double:NaN;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2.HU(r3);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r4;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r5 = r16;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r4 = r6;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        goto L_0x0959;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0aaa:
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r12 = r0.mContext;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r12 = com.tencent.smtt.utils.f.hS(r12);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        if (r12 != 0) goto L_0x0b04;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
    L_0x0ab4:
        r2 = "TbsDownload";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = "DownloadEnd FreeSpace too small ";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3, r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = 105; // 0x69 float:1.47E-43 double:5.2E-322;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = "freespace=";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3.<init>(r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = com.tencent.smtt.utils.u.cFH();	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = r3.append(r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = ",and minFreeSpace=";	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = r3.append(r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = r0.mContext;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = com.tencent.smtt.sdk.o.gG(r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = r8.cEl();	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = r3.append(r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r8 = 1;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0.k(r2, r3, r8);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r0 = r33;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r0.mContext;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r3 = -308; // 0xfffffffffffffecc float:NaN double:NaN;	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2.HU(r3);	 Catch:{ IOException -> 0x1115, all -> 0x10f6 }
        r2 = r4;
        r5 = r16;
        r4 = r6;
        goto L_0x0959;
    L_0x0b04:
        r12 = r4;
        r0 = r25;
        r4 = (long) r0;
        r20 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r8 = r20 - r8;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r33;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r0.zWP;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r26 = r0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r26;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r0.zYx;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r28 = r0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r8 = r8 + r28;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r26;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0.zYx = r8;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r33;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r8 = r0.zWP;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r8.zYB;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r26 = r0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r4 = r4 + r26;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r8.zYB = r4;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r25;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r4 = (long) r0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r4 = r4 + r18;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = r8 - r10;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r26 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = (r18 > r26 ? 1 : (r18 == r26 ? 0 : -1));	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        if (r18 <= 0) goto L_0x1130;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0b3d:
        r10 = "TbsDownload";	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r11 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = "#2 STEP 1/2 begin downloading...current/total=";	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r18;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r11.<init>(r0);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r11 = r11.append(r4);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = "/";	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r18;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r11 = r11.append(r0);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r33;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r0.mContentLength;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = r0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r18;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r11 = r11.append(r0);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r11 = r11.toString();	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = 1;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r18;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        com.tencent.smtt.utils.TbsLog.i(r10, r11, r0);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r10 = com.tencent.smtt.sdk.QbSdk.zWf;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        if (r10 == 0) goto L_0x0b8a;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0b72:
        r10 = (double) r4;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r33;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r0.mContentLength;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = r0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r18;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = (double) r0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = r0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r10 = r10 / r18;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r10 = r10 * r18;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r10 = (int) r10;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r11 = com.tencent.smtt.sdk.QbSdk.zWf;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r11.kO(r10);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0b8a:
        if (r34 != 0) goto L_0x0be6;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0b8c:
        r10 = r4 - r2;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r18 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r10 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1));	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        if (r10 <= 0) goto L_0x0be6;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0b95:
        r0 = r33;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2 = r0.mContext;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2 = com.tencent.smtt.sdk.p.gK(r2);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        if (r2 != 0) goto L_0x0be5;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0b9f:
        r0 = r33;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2 = r0.mContext;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2 = com.tencent.smtt.utils.b.hL(r2);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r3 = 3;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        if (r2 == r3) goto L_0x0bb0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0baa:
        r2 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        if (r2 == 0) goto L_0x0bba;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0bb0:
        r0 = r33;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2 = r0.mContext;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2 = com.tencent.smtt.utils.b.hL(r2);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        if (r2 != 0) goto L_0x0be5;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0bba:
        r33.stopDownload();	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2 = com.tencent.smtt.sdk.QbSdk.zWf;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        if (r2 == 0) goto L_0x0bc8;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0bc1:
        r2 = com.tencent.smtt.sdk.QbSdk.zWf;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r3 = 111; // 0x6f float:1.56E-43 double:5.5E-322;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2.ly(r3);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
    L_0x0bc8:
        r2 = "TbsDownload";	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r3 = "Download is paused due to NOT_WIFI error!";	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r4 = 0;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3, r4);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r0 = r33;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2 = r0.mContext;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r3 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r2.HU(r3);	 Catch:{ IOException -> 0x1121, all -> 0x10f9 }
        r5 = r16;
        r2 = r12;
        r4 = r6;
        goto L_0x0959;
    L_0x0be5:
        r2 = r4;
    L_0x0be6:
        r30 = r8;
        r8 = r2;
        r2 = r30;
    L_0x0beb:
        r10 = r2;
        r18 = r4;
        r2 = r8;
        r4 = r12;
        r8 = r20;
        goto L_0x0938;
    L_0x0bf4:
        r6 = r4;
        r4 = r2;
    L_0x0bf6:
        h(r15);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        h(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        h(r14);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mFinished;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 != 0) goto L_0x0c12;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0c05:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -319; // 0xfffffffffffffec1 float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0c12:
        if (r34 != 0) goto L_0x01e9;
    L_0x0c14:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0c35:
        if (r34 != 0) goto L_0x0cae;
    L_0x0c37:
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r9 = r0.mContext;	 Catch:{ all -> 0x0d11 }
        r9 = com.tencent.smtt.utils.f.hS(r9);	 Catch:{ all -> 0x0d11 }
        if (r9 != 0) goto L_0x0cae;	 Catch:{ all -> 0x0d11 }
    L_0x0c41:
        r5 = 105; // 0x69 float:1.47E-43 double:5.2E-322;	 Catch:{ all -> 0x0d11 }
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0d11 }
        r10 = "freespace=";	 Catch:{ all -> 0x0d11 }
        r9.<init>(r10);	 Catch:{ all -> 0x0d11 }
        r10 = com.tencent.smtt.utils.u.cFH();	 Catch:{ all -> 0x0d11 }
        r9 = r9.append(r10);	 Catch:{ all -> 0x0d11 }
        r10 = ",and minFreeSpace=";	 Catch:{ all -> 0x0d11 }
        r9 = r9.append(r10);	 Catch:{ all -> 0x0d11 }
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r10 = r0.mContext;	 Catch:{ all -> 0x0d11 }
        r10 = com.tencent.smtt.sdk.o.gG(r10);	 Catch:{ all -> 0x0d11 }
        r10 = r10.cEl();	 Catch:{ all -> 0x0d11 }
        r9 = r9.append(r10);	 Catch:{ all -> 0x0d11 }
        r9 = r9.toString();	 Catch:{ all -> 0x0d11 }
        r10 = 1;	 Catch:{ all -> 0x0d11 }
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r0.k(r5, r9, r10);	 Catch:{ all -> 0x0d11 }
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r5 = r0.mContext;	 Catch:{ all -> 0x0d11 }
        r5 = com.tencent.smtt.sdk.o.gG(r5);	 Catch:{ all -> 0x0d11 }
        r9 = -308; // 0xfffffffffffffecc float:NaN double:NaN;	 Catch:{ all -> 0x0d11 }
        r5.HU(r9);	 Catch:{ all -> 0x0d11 }
        h(r8);	 Catch:{ Throwable -> 0x10e4 }
        h(r6);	 Catch:{ Throwable -> 0x10e4 }
        h(r7);	 Catch:{ Throwable -> 0x10e4 }
        if (r34 != 0) goto L_0x112a;
    L_0x0c8c:
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5 = r5.zXl;
        r6 = "tbs_downloadflow";
        r2 = java.lang.Long.valueOf(r2);
        r5.put(r6, r2);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        r6 = r4;
        goto L_0x01e9;
    L_0x0cae:
        r10 = 0;
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r0.gv(r10);	 Catch:{ all -> 0x0d11 }
        r9 = 0;	 Catch:{ all -> 0x0d11 }
        r10 = new java.io.File;	 Catch:{ all -> 0x0d11 }
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r11 = r0.zWI;	 Catch:{ all -> 0x0d11 }
        r12 = "x5.tbs.temp";	 Catch:{ all -> 0x0d11 }
        r10.<init>(r11, r12);	 Catch:{ all -> 0x0d11 }
        r10 = r10.exists();	 Catch:{ all -> 0x0d11 }
        if (r10 == 0) goto L_0x0cc9;	 Catch:{ all -> 0x0d11 }
    L_0x0cc8:
        r9 = 1;	 Catch:{ all -> 0x0d11 }
    L_0x0cc9:
        if (r9 != 0) goto L_0x0d04;	 Catch:{ all -> 0x0d11 }
    L_0x0ccb:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;	 Catch:{ all -> 0x0d11 }
        r5 = l(r5);	 Catch:{ all -> 0x0d11 }
        r10 = 0;	 Catch:{ all -> 0x0d11 }
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r0.k(r9, r5, r10);	 Catch:{ all -> 0x0d11 }
    L_0x0cd7:
        h(r8);	 Catch:{ Throwable -> 0x10e4 }
        h(r6);	 Catch:{ Throwable -> 0x10e4 }
        h(r7);	 Catch:{ Throwable -> 0x10e4 }
        if (r34 != 0) goto L_0x035a;
    L_0x0ce2:
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5 = r5.zXl;
        r6 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r2);
        r5.put(r6, r7);
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5.commit();
        r6 = r4;
        goto L_0x01c1;
    L_0x0d04:
        r9 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r5 = l(r5);	 Catch:{ all -> 0x0d11 }
        r10 = 0;	 Catch:{ all -> 0x0d11 }
        r0 = r33;	 Catch:{ all -> 0x0d11 }
        r0.k(r9, r5, r10);	 Catch:{ all -> 0x0d11 }
        goto L_0x0cd7;
    L_0x0d11:
        r5 = move-exception;
        r14 = r7;
        r15 = r8;
        r7 = r6;
        r6 = r4;
        r30 = r2;
        r2 = r5;
        r4 = r30;
    L_0x0d1b:
        h(r15);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        h(r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        h(r14);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        throw r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0d25:
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 < r3) goto L_0x0da9;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0d29:
        r3 = 307; // 0x133 float:4.3E-43 double:1.517E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 > r3) goto L_0x0da9;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0d2d:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "Location";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.getHeaderField(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 != 0) goto L_0x0d70;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0d3e:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWH = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWM;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2 + 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWM = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x112d;
    L_0x0d4e:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r4);
        r2.put(r3, r7);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        r2 = r4;
        goto L_0x01c1;
    L_0x0d70:
        r2 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r3 = 0;
        r7 = 1;
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.k(r2, r3, r7);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -312; // 0xfffffffffffffec8 float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x01e9;
    L_0x0d88:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0da9:
        r3 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r7 = java.lang.String.valueOf(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.k(r3, r7, r8);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 != r3) goto L_0x0e2b;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0db9:
        r2 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r1 = r17;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.X(r2, r1);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == 0) goto L_0x0df5;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0dc4:
        r6 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -214; // 0xffffffffffffff2a float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x01e9;
    L_0x0dd4:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0df5:
        r2 = 0;
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.nR(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -313; // 0xfffffffffffffec7 float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x01e9;
    L_0x0e0a:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0e2b:
        r3 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r2 == r3) goto L_0x0e33;
    L_0x0e2f:
        r3 = 406; // 0x196 float:5.69E-43 double:2.006E-321;
        if (r2 != r3) goto L_0x0e6d;
    L_0x0e33:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r8 = r0.mContentLength;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r10 = -1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 != 0) goto L_0x0e6d;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0e3d:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -314; // 0xfffffffffffffec6 float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x01e9;
    L_0x0e4c:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0e6d:
        r3 = 202; // 0xca float:2.83E-43 double:1.0E-321;
        if (r2 != r3) goto L_0x0e95;
    L_0x0e71:
        if (r34 != 0) goto L_0x112d;
    L_0x0e73:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r4);
        r2.put(r3, r7);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        r2 = r4;
        goto L_0x01c1;
    L_0x0e95:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.mRetryTimes;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.zWV;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 >= r7) goto L_0x0f11;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0e9f:
        r3 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 != r3) goto L_0x0f11;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0ea3:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.zWN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = "Retry-After";	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r2.getHeaderField(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = java.lang.Long.parseLong(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.gv(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.Mu;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == 0) goto L_0x0eed;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0ebd:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x01e9;
    L_0x0ecc:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0eed:
        if (r34 != 0) goto L_0x112d;
    L_0x0eef:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r4);
        r2.put(r3, r7);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        r2 = r4;
        goto L_0x01c1;
    L_0x0f11:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.mRetryTimes;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r7 = r0.zWV;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 >= r7) goto L_0x0f8c;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0f1b:
        r3 = 408; // 0x198 float:5.72E-43 double:2.016E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == r3) goto L_0x0f2b;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0f1f:
        r3 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == r3) goto L_0x0f2b;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0f23:
        r3 = 502; // 0x1f6 float:7.03E-43 double:2.48E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == r3) goto L_0x0f2b;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0f27:
        r3 = 408; // 0x198 float:5.72E-43 double:2.016E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 != r3) goto L_0x0f8c;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0f2b:
        r2 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.gv(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.Mu;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == 0) goto L_0x0f68;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0f38:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x01e9;
    L_0x0f47:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0f68:
        if (r34 != 0) goto L_0x112d;
    L_0x0f6a:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r4);
        r2.put(r3, r7);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        r2 = r4;
        goto L_0x01c1;
    L_0x0f8c:
        r8 = r33.cEc();	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r10 = 0;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 > 0) goto L_0x0fc9;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0f96:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = r0.zWL;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r3 != 0) goto L_0x0fc9;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0f9c:
        r3 = 410; // 0x19a float:5.75E-43 double:2.026E-321;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r2 == r3) goto L_0x0fc9;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
    L_0x0fa0:
        r2 = 1;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r0.zWL = r2;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x112d;
    L_0x0fa7:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r4);
        r2.put(r3, r7);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        r2 = r4;
        goto L_0x01c1;
    L_0x0fc9:
        r0 = r33;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = r0.mContext;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2 = com.tencent.smtt.sdk.o.gG(r2);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r3 = -315; // 0xfffffffffffffec5 float:NaN double:NaN;	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        r2.HU(r3);	 Catch:{ Throwable -> 0x067d, all -> 0x0716 }
        if (r34 != 0) goto L_0x01e9;
    L_0x0fd8:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2 = r2.zXl;
        r3 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r3, r4);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        goto L_0x01e9;
    L_0x0ff9:
        r6 = 0;
        r0 = r33;	 Catch:{ all -> 0x10d7 }
        r0.gv(r6);	 Catch:{ all -> 0x10d7 }
        r6 = 107; // 0x6b float:1.5E-43 double:5.3E-322;	 Catch:{ all -> 0x10d7 }
        r5 = l(r5);	 Catch:{ all -> 0x10d7 }
        r7 = 0;	 Catch:{ all -> 0x10d7 }
        r0 = r33;	 Catch:{ all -> 0x10d7 }
        r0.k(r6, r5, r7);	 Catch:{ all -> 0x10d7 }
        r0 = r33;	 Catch:{ all -> 0x10d7 }
        r5 = r0.Mu;	 Catch:{ all -> 0x10d7 }
        if (r5 == 0) goto L_0x06c8;	 Catch:{ all -> 0x10d7 }
    L_0x1012:
        r0 = r33;	 Catch:{ all -> 0x10d7 }
        r5 = r0.mContext;	 Catch:{ all -> 0x10d7 }
        r5 = com.tencent.smtt.sdk.o.gG(r5);	 Catch:{ all -> 0x10d7 }
        r6 = -309; // 0xfffffffffffffecb float:NaN double:NaN;	 Catch:{ all -> 0x10d7 }
        r5.HU(r6);	 Catch:{ all -> 0x10d7 }
        if (r34 != 0) goto L_0x112a;
    L_0x1021:
        r0 = r33;
        r5 = r0.mContext;
        r5 = com.tencent.smtt.sdk.o.gG(r5);
        r5 = r5.zXl;
        r6 = "tbs_downloadflow";
        r2 = java.lang.Long.valueOf(r2);
        r5.put(r6, r2);
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r2.commit();
        r6 = r4;
        goto L_0x01e9;
    L_0x1043:
        r2 = 0;
        goto L_0x020d;
    L_0x1046:
        r2 = 2;
        goto L_0x0218;
    L_0x1049:
        r0 = r33;
        r2 = r0.zWP;
        r3 = 0;
        r2.zYq = r3;
        goto L_0x021a;
    L_0x1052:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.o.gG(r2);
        r3 = -318; // 0xfffffffffffffec2 float:NaN double:NaN;
        r2.HU(r3);
        r2 = 0;
        r0 = r33;
        r0.nR(r2);
        goto L_0x023a;
    L_0x1067:
        r3 = r2.zXm;
        r4 = "tbs_download_failed_retrytimes";
        r5 = 0;
        r3 = r3.getInt(r4, r5);
        r4 = r2.zXl;
        r5 = "tbs_download_failed_retrytimes";
        r3 = r3 + 1;
        r7 = java.lang.Integer.valueOf(r3);
        r4.put(r5, r7);
        r4 = r2.cEn();
        if (r3 != r4) goto L_0x025c;
    L_0x1085:
        r0 = r33;
        r3 = r0.zWP;
        r4 = 2;
        r3.zYr = r4;
        goto L_0x025c;
    L_0x108e:
        r2 = 0;
        goto L_0x0266;
    L_0x1091:
        r2 = move-exception;
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "[closeHttpRequest] mHttpRequest.disconnect() Throwable:";
        r4.<init>(r5);
        r2 = r2.toString();
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.e(r3, r2);
        goto L_0x0296;
    L_0x10ae:
        r2 = cEd();
        if (r2 != 0) goto L_0x031c;
    L_0x10b4:
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r4 = 0;
        r5 = 1;
        r0 = r33;
        r0.k(r2, r4, r5);
        goto L_0x031c;
    L_0x10bf:
        r0 = r33;
        r2 = r0.mContext;
        r2 = com.tencent.smtt.sdk.v.hn(r2);
        r4 = com.tencent.smtt.sdk.v.a.zYf;
        r0 = r33;
        r5 = r0.zWP;
        r2.a(r4, r5);
        goto L_0x0342;
    L_0x10d2:
        r2 = 0;
        com.tencent.smtt.sdk.p.zXu = r2;
        goto L_0x0020;
    L_0x10d7:
        r4 = move-exception;
        r30 = r4;
        r4 = r2;
        r2 = r30;
        goto L_0x0717;
    L_0x10df:
        r4 = move-exception;
        r5 = r4;
        r4 = r6;
        goto L_0x0684;
    L_0x10e4:
        r5 = move-exception;
        goto L_0x0684;
    L_0x10e7:
        r2 = move-exception;
        r14 = r7;
        r15 = r8;
        r7 = r3;
        goto L_0x0d1b;
    L_0x10ed:
        r2 = move-exception;
        r7 = r3;
        r15 = r8;
        goto L_0x0d1b;
    L_0x10f2:
        r2 = move-exception;
        r15 = r8;
        goto L_0x0d1b;
    L_0x10f6:
        r2 = move-exception;
        goto L_0x0d1b;
    L_0x10f9:
        r2 = move-exception;
        r4 = r12;
        goto L_0x0d1b;
    L_0x10fd:
        r2 = move-exception;
        r30 = r2;
        r31 = r4;
        r5 = r30;
        r4 = r6;
        r6 = r3;
        r2 = r31;
        goto L_0x09a9;
    L_0x110a:
        r2 = move-exception;
        r30 = r2;
        r2 = r4;
        r5 = r30;
        r4 = r6;
        r6 = r7;
        r7 = r14;
        goto L_0x09a9;
    L_0x1115:
        r2 = move-exception;
        r8 = r15;
        r30 = r4;
        r5 = r2;
        r4 = r6;
        r2 = r30;
        r6 = r7;
        r7 = r14;
        goto L_0x09a9;
    L_0x1121:
        r2 = move-exception;
        r5 = r2;
        r8 = r15;
        r4 = r6;
        r2 = r12;
        r6 = r7;
        r7 = r14;
        goto L_0x09a9;
    L_0x112a:
        r6 = r4;
        goto L_0x01e9;
    L_0x112d:
        r2 = r4;
        goto L_0x01c1;
    L_0x1130:
        r8 = r2;
        r2 = r10;
        goto L_0x0beb;
    L_0x1134:
        r7 = r3;
        r15 = r8;
        goto L_0x0bf6;
    L_0x1138:
        r4 = r2;
        goto L_0x03bf;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.l.W(boolean, boolean):void");
    }

    public final boolean cEa() {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            File file = new File(f.ar(this.mContext, 4), "x5.tbs.decouple");
            if (file.exists()) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                File HX = p.HX(o.gG(this.mContext).zXm.getInt("tbs_decouplecoreversion", -1));
                if (HX != null && HX.exists()) {
                    f.j(HX, file);
                }
            }
            if (a.a(this.mContext, file, o.gG(this.mContext).zXm.getInt("tbs_decouplecoreversion", -1))) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
                t.cEF();
                return t.gQ(this.mContext);
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup no backup file !!!");
            file = new File(f.ar(this.mContext, 4), "x5.tbs.decouple");
            if (file.exists()) {
                file.delete();
            }
            return false;
        } catch (Exception e) {
        }
    }

    public final void clearCache() {
        stopDownload();
        nR(false);
        nR(true);
    }

    public final boolean nP(boolean z) {
        int i;
        int i2 = o.gG(this.mContext).zXm.getInt("use_backup_version", 0);
        int gY = t.cEF().gY(this.mContext);
        if (i2 == 0) {
            i2 = o.gG(this.mContext).zXm.getInt("tbs_download_version", 0);
            this.zWX = "by default key";
            i = i2;
        } else {
            this.zWX = "by new key";
            i = i2;
        }
        if (i == 0 || i == gY) {
            return false;
        }
        if (z) {
            File file;
            boolean z2;
            File file2;
            File HW = p.HW(i);
            if (HW != null && HW.exists()) {
                file = new File(f.ar(this.mContext, 4), p.gK(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                try {
                    if (o.gG(this.mContext).zXm.getInt("tbs_download_version_type", 0) != 1) {
                        f.j(HW, file);
                        z2 = true;
                        file2 = new File(f.ar(this.mContext, 4), p.gK(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                        gY = o.gG(this.mContext).zXm.getInt("use_backup_version", 0);
                        if (gY == 0) {
                            gY = o.gG(this.mContext).zXm.getInt("tbs_download_version", 0);
                        }
                        if (a.a(this.mContext, file2, gY)) {
                            try {
                                if (o.gG(this.mContext).zXm.getInt("tbs_downloaddecouplecore", 0) != 1) {
                                    file = new File(f.ar(this.mContext, 4), p.gK(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                }
                            } catch (Exception e) {
                            }
                            if (!a.a(this.mContext, HW, i)) {
                                f.T(HW);
                            }
                        } else if (HT(i)) {
                            o.gG(this.mContext).zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
                            o.gG(this.mContext).HU(-214);
                            nQ(false);
                            if (z2) {
                                return true;
                            }
                            k(100, "use local backup apk in startDownload" + this.zWX, true);
                            if (o.gG(this.mContext).zXm.getInt("tbs_downloaddecouplecore", 0) != 1) {
                                v.hn(this.mContext).a(v.a.zYi, this.zWP);
                            } else {
                                v.hn(this.mContext).a(v.a.zYf, this.zWP);
                            }
                            this.zWP.cDZ();
                            return true;
                        }
                    }
                } catch (Exception e2) {
                }
            }
            z2 = false;
            if (p.gK(this.mContext)) {
            }
            file2 = new File(f.ar(this.mContext, 4), p.gK(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            gY = o.gG(this.mContext).zXm.getInt("use_backup_version", 0);
            if (gY == 0) {
                gY = o.gG(this.mContext).zXm.getInt("tbs_download_version", 0);
            }
            if (a.a(this.mContext, file2, gY)) {
                if (o.gG(this.mContext).zXm.getInt("tbs_downloaddecouplecore", 0) != 1) {
                    if (p.gK(this.mContext)) {
                    }
                    file = new File(f.ar(this.mContext, 4), p.gK(this.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                    if (file.exists()) {
                        file.delete();
                    }
                }
                if (a.a(this.mContext, HW, i)) {
                    f.T(HW);
                }
            } else if (HT(i)) {
                o.gG(this.mContext).zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
                o.gG(this.mContext).HU(-214);
                nQ(false);
                if (z2) {
                    return true;
                }
                k(100, "use local backup apk in startDownload" + this.zWX, true);
                if (o.gG(this.mContext).zXm.getInt("tbs_downloaddecouplecore", 0) != 1) {
                    v.hn(this.mContext).a(v.a.zYf, this.zWP);
                } else {
                    v.hn(this.mContext).a(v.a.zYi, this.zWP);
                }
                this.zWP.cDZ();
                return true;
            }
        }
        if (X(false, z)) {
            o.gG(this.mContext).zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
            o.gG(this.mContext).HU(-214);
            nQ(false);
            return true;
        }
        if (!(nR(true) || nR(true))) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
            o.gG(this.mContext).HU(-301);
        }
        return false;
    }

    public final void stopDownload() {
        this.Mu = true;
        if (x.hq(this.mContext)) {
            v.hn(this.mContext);
            v$b cEJ = v.cEJ();
            cEJ.setErrorCode(-309);
            cEJ.m(new Exception());
            if (o.gG(this.mContext).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
                v.hn(this.mContext).a(v.a.zYi, cEJ);
            } else {
                v.hn(this.mContext).a(v.a.zYf, cEJ);
            }
        }
    }
}
