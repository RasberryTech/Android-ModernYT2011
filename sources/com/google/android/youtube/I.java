package com.google.android.youtube;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
final class I extends BroadcastReceiver {
    final /* synthetic */ WatchActivity a;
    private Handler b;

    /* synthetic */ I(WatchActivity watchActivity) {
        this(watchActivity, (byte) 0);
    }

    private I(WatchActivity watchActivity, byte b) {
        this.a = watchActivity;
    }

    public final void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.a.registerReceiver(this, intentFilter);
        this.b = new Handler();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            if (!this.a.v.isPlaying() && this.a.v.getCurrentPosition() > 0) {
                this.b.postDelayed(new J(this), 180000L);
                return;
            }
            return;
        }
        this.b.removeCallbacksAndMessages(null);
    }
}
