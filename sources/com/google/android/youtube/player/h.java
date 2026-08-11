package com.google.android.youtube.player;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class h extends Handler {
    public volatile int a;
    private /* synthetic */ YouTubePlayer b;

    /* synthetic */ h(YouTubePlayer youTubePlayer) {
        this(youTubePlayer, (byte) 0);
    }

    private h(YouTubePlayer youTubePlayer, byte b) {
        this.b = youTubePlayer;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.b.c != null) {
            YouTubePlayer.a(this.b, this.b.c.getCurrentPosition(), this.a, this.b.c.getDuration());
            sendEmptyMessageDelayed(5, 1000L);
        } else {
            removeMessages(5);
        }
    }
}
