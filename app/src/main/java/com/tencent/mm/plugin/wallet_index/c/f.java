package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Map hashMap = new HashMap();
        hashMap.put("toUser", str);
        hashMap.put("receiverTitle", str2);
        hashMap.put("senderTitle", str3);
        hashMap.put("tempId", str4);
        hashMap.put("receiverdes", str6);
        hashMap.put("senderdes", str5);
        hashMap.put("Url", str7);
        hashMap.put("Scene", str8);
        D(hashMap);
    }

    public final int ayQ() {
        return 0;
    }

    public final int Hr() {
        return 1962;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneSendC2CMsg", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/h5sendc2cmsg";
    }
}
