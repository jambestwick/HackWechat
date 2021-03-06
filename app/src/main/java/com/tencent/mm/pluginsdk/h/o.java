package com.tencent.mm.pluginsdk.h;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class o {
    public final int action;
    public final String content;
    public final int errorCode;
    public final int fqv;
    public final String title;
    public final int type;
    public final String url;
    public final int vfX;

    public o(int i, int i2, String str) {
        String str2;
        Exception exception;
        int i3;
        Exception exception2;
        String str3;
        int i4;
        String str4;
        int i5 = 0;
        String str5 = "";
        int i6 = 5;
        String str6 = "";
        String str7 = "";
        try {
            Map y = bi.y(str, "e");
            if (y == null) {
                throw new IllegalArgumentException("values == null");
            }
            int intValue = Integer.valueOf((String) y.get(".e.ShowType")).intValue();
            try {
                i5 = Integer.valueOf((String) y.get(".e.Action")).intValue();
                i6 = Integer.valueOf((String) y.get(".e.DispSec")).intValue();
                str2 = (String) y.get(".e.Title");
            } catch (Exception e) {
                exception = e;
                str2 = str7;
                str7 = str6;
                i3 = i6;
                i6 = i5;
                i5 = intValue;
                exception2 = exception;
                x.e("MicroMsg.UnifyErrorProcessor", exception2.toString());
                str3 = str5;
                i4 = i6;
                str4 = str3;
                this.errorCode = i2;
                this.fqv = i;
                this.type = i5;
                this.action = i4;
                this.content = str4;
                this.vfX = i3;
                this.title = str2;
                this.url = str7;
            }
            try {
                str7 = (String) y.get(".e.Url");
                try {
                    i4 = i5;
                    i5 = intValue;
                    int i7 = i6;
                    str4 = (String) y.get(".e.Content");
                    i3 = i7;
                } catch (Exception e2) {
                    exception = e2;
                    i3 = i6;
                    i6 = i5;
                    i5 = intValue;
                    exception2 = exception;
                    x.e("MicroMsg.UnifyErrorProcessor", exception2.toString());
                    str3 = str5;
                    i4 = i6;
                    str4 = str3;
                    this.errorCode = i2;
                    this.fqv = i;
                    this.type = i5;
                    this.action = i4;
                    this.content = str4;
                    this.vfX = i3;
                    this.title = str2;
                    this.url = str7;
                }
            } catch (Exception e3) {
                exception = e3;
                str7 = str6;
                i3 = i6;
                i6 = i5;
                i5 = intValue;
                exception2 = exception;
                x.e("MicroMsg.UnifyErrorProcessor", exception2.toString());
                str3 = str5;
                i4 = i6;
                str4 = str3;
                this.errorCode = i2;
                this.fqv = i;
                this.type = i5;
                this.action = i4;
                this.content = str4;
                this.vfX = i3;
                this.title = str2;
                this.url = str7;
            }
            this.errorCode = i2;
            this.fqv = i;
            this.type = i5;
            this.action = i4;
            this.content = str4;
            this.vfX = i3;
            this.title = str2;
            this.url = str7;
        } catch (Exception e4) {
            exception2 = e4;
            str2 = str7;
            str7 = str6;
            i3 = 5;
            i6 = 0;
            x.e("MicroMsg.UnifyErrorProcessor", exception2.toString());
            str3 = str5;
            i4 = i6;
            str4 = str3;
            this.errorCode = i2;
            this.fqv = i;
            this.type = i5;
            this.action = i4;
            this.content = str4;
            this.vfX = i3;
            this.title = str2;
            this.url = str7;
        }
    }
}
