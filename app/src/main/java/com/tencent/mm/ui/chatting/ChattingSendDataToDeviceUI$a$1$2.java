package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a.1;

class ChattingSendDataToDeviceUI$a$1$2 implements Runnable {
    final /* synthetic */ 1 yvj;

    ChattingSendDataToDeviceUI$a$1$2(1 1) {
        this.yvj = 1;
    }

    public final void run() {
        this.yvj.yvb.yxX.setProgress(0);
        this.yvj.yvb.yxX.setVisibility(4);
        this.yvj.yvb.yvg.setText(this.yvj.yvi.yuZ.getText(R.l.dSV));
        this.yvj.yvb.yvg.setTextColor(this.yvj.yvi.yuZ.getResources().getColor(R.e.btN));
        this.yvj.yvc.fsK = "send_data_failed";
        this.yvj.yvc.progress = 0;
        ChattingSendDataToDeviceUI.d(this.yvj.yvi.yuZ).put(this.yvj.yvc.deviceID, this.yvj.yvc);
        x.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[]{this.yvj.yvc.deviceID});
    }
}
