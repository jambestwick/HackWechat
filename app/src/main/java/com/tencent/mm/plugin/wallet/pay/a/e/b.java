package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;

public final class b extends f {
    public b(p pVar, Orders orders) {
        super(pVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_ff_verifyreg";
    }

    public final int Hr() {
        return 1517;
    }
}
