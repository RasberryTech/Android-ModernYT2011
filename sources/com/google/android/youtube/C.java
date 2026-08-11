package com.google.android.youtube;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class C extends BroadcastReceiver {
    final /* synthetic */ WatchActivity a;

    /* synthetic */ C(WatchActivity watchActivity) {
        this(watchActivity, (byte) 0);
    }

    private C(WatchActivity watchActivity, byte b) {
        this.a = watchActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.a.v.isPlaying()) {
            this.a.v.pauseVideo();
        }
    }
}
