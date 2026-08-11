package com.google.android.youtube.player;

import android.os.ConditionVariable;
import android.os.Looper;
import defpackage.C0210ge;
import defpackage.InterfaceC0004ad;

/* JADX INFO: loaded from: classes.dex */
final class d extends Thread {
    private /* synthetic */ c[] a;
    private /* synthetic */ C0210ge b;
    private /* synthetic */ InterfaceC0004ad c;
    private /* synthetic */ ConditionVariable d;

    d(c[] cVarArr, C0210ge c0210ge, InterfaceC0004ad interfaceC0004ad, ConditionVariable conditionVariable) {
        this.a = cVarArr;
        this.b = c0210ge;
        this.c = interfaceC0004ad;
        this.d = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Looper.prepare();
        this.a[0] = new c(this.b, this.c);
        this.d.open();
        Looper.loop();
    }
}
