package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class h {
    protected static String aBs = "weixin/android";
    protected static int gKi = 0;
    protected static String host = "";
    protected static String pov = "";

    public static class b {
        int pow;
        Map<String, String> pox;
        Map<String, String> poy;
        d poz;

        public b(int i, Map<String, String> map, Map<String, String> map2, d dVar) {
            this.pow = i;
            this.pox = map;
            this.poy = map2;
            this.poz = dVar;
        }

        public final String toString() {
            return "Request method:" + this.pow + ", params:" + (this.pox != null ? this.pox : "") + ", cookie:" + (this.poy != null ? this.poy : "");
        }
    }

    public static class d {
        String filePath;
        String fwF;

        public d(String str, String str2) {
            this.fwF = str;
            this.filePath = str2;
        }
    }

    public abstract c a(String str, String str2, b bVar, a aVar);

    public abstract void cancel();

    public static void setHost(String str) {
        x.host = str;
    }

    public static void setUserAgent(String str) {
        x.aBs = str;
    }

    public static void HH(String str) {
        pov = str;
    }

    protected static String b(String str, String str2, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(str2.startsWith("http://") || str2.startsWith("https://"))) {
            stringBuilder.append(str + host);
        }
        stringBuilder.append(str2);
        if (map == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append('?');
        Object obj = 1;
        for (String str3 : map.keySet()) {
            stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str3, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(bh.ou((String) map.get(str3)), ProtocolPackage.ServerEncoding));
            obj = null;
        }
        return stringBuilder.toString();
    }

    protected static String M(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : map.keySet()) {
            stringBuilder.append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) map.get(str), ProtocolPackage.ServerEncoding));
            int i2 = i + 1;
            if (map.size() > i2) {
                stringBuilder.append("; ");
            }
            i = i2;
        }
        return stringBuilder.toString();
    }

    protected static Map<String, String> HI(String str) {
        Map<String, String> hashMap = new HashMap();
        if (!(str == null || str.length() == 0)) {
            for (String split : str.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }
}
