package com.tencent.mm.plugin.ext.voicecontrol;

class ExtControlProviderVoiceControl$3 implements Runnable {
    final /* synthetic */ ExtControlProviderVoiceControl mbL;
    final /* synthetic */ a mbM;

    ExtControlProviderVoiceControl$3(ExtControlProviderVoiceControl extControlProviderVoiceControl, a aVar) {
        this.mbL = extControlProviderVoiceControl;
        this.mbM = aVar;
    }

    public final void run() {
        this.mbL.a(this.mbM.mbO, this.mbM.appId, this.mbM.mbP);
    }
}
